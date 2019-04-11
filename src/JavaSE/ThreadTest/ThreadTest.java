package JavaSE.ThreadTest;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class MyThread implements Runnable,Callable<String> {
    private int ticket = 100;
    @Override
//    public void run() {
//        for(int i=0;i<100;i++){
//            //线程在外面等
//            synchronized (this){
//                //为程序上锁
//                if(this.ticket >0){
//                    System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"张");
//                }
//            }
//        }
//    }
    public void run() {
        for(int i=0;i<100;i++){
            //线程在外面等
            synchronized (this){
                //为程序上锁
                if(this.ticket >0){
                    System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"张");
                }
            }
        }
    }
    @Override
    public String call() throws Exception {
        for(int i=0;i<10;i++){
            System.out.println("还剩下"+ticket--+"张");
        }
        return "票卖完了~";
    }
}


public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread,"A");
        Thread thread2 = new Thread(myThread,"B");
        thread1.start();
        thread2.start();
//        Callable<String> callable = new MyThread();
//        FutureTask<String> futureTask = new FutureTask<>(callable);
//        Thread thread = new Thread(futureTask);
//        thread.start();
//        System.out.println(futureTask.get());
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello World");
//            }
//        }).start();

//        Runnable runnable = ()-> System.out.println("Hello World");
//        new Thread(runnable).start();

    }
}
