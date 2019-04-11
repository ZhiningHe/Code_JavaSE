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

    public synchronized void MyThread0(){
        while (flag != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName()+" ");
        flag =1;
        notifyAll();
        count++;
    }

    public synchronized void MyThread1(){
        while (flag != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName()+" ");
        flag =2;
        notifyAll();
        count++;
    }

    public synchronized void MyThread2(){
        while (flag != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName()+" ");
        flag =2;
        notifyAll();
        count++;
    }

    public static void main(String[] args) {
        WorkTest print = new WorkTest();
        MyThread3 myThread = new MyThread3(print);
        new Thread(myThread,"MyThread-0").start();
        new Thread(myThread,"MyThread-1").start();
        //new Thread(myThread,"MyThread-2").start();
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
               if(Thread.currentThread().getName().equals("MyThread-0")){
                   print.MyThread0();
               }else if(Thread.currentThread().getName().equals("MyThread-1")){
                   print.MyThread1();
               }else if(Thread.currentThread().getName().equals("MyThread-2")){
                   print.MyThread2();
               }
            }
            System.out.println(" ");
        }
    }
}