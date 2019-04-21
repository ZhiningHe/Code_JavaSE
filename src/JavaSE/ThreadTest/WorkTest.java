package JavaSE.ThreadTest;

/**
 *三个线程打印如下
 * 0
 * 01
 * 012
 * 0120
 * 01201
 * 012012
 * ……
 * 重复30次
 */
public class WorkTest {
    private int count = 1;
    private int flag = 0;

    public int getCount() {
        return count;
    }

    public synchronized void MyThread0() throws InterruptedException {
        while (flag != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName()+" ");
        flag =1;
        Thread.sleep(1000);
        notifyAll();
        count++;
    }

    public synchronized void MyThread1() throws InterruptedException {
        while (flag != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName()+" ");
        flag =2;
        Thread.sleep(1000);
        notifyAll();
        count++;
    }

    public synchronized void MyThread2() throws InterruptedException {
        while (flag != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName()+" ");
        flag =2;
        Thread.sleep(1000);
        notifyAll();
        count++;
    }

    public static void main(String[] args) {
        WorkTest print = new WorkTest();
        MyThread3 myThread = new MyThread3(print);
        new Thread(myThread,"0").start();
        new Thread(myThread,"1").start();
        new Thread(myThread,"2").start();
    }
}

class MyThread3 implements Runnable{
    private WorkTest print;

    public MyThread3(WorkTest print) {
        this.print = print;
    }

    @Override
    public void run() {
        while(print.getCount() <30){
            for (int i=0;i<print.getCount();i++) {
               if(Thread.currentThread().getName().equals("0")){
                   try {
                       print.MyThread0();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }else if(Thread.currentThread().getName().equals("1")){
                   try {
                       print.MyThread1();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }else if(Thread.currentThread().getName().equals("2")){
                   try {
                       print.MyThread2();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
            System.out.println(" ");
        }
    }
}