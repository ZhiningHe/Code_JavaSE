package JavaSE.ThreadTest;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;

/**
 * 启动三个线程，名称是A，B，C；按顺序打印ABCABCABCABCABC
 */
public class ABCABC {
    private int flag = 1;
    private int count =0;
    public synchronized void A(){
        while (flag != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag =2;
        notifyAll();
        count++;
    }

    public synchronized void B(){
        while (flag != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag =3;
        notifyAll();
        count++;
    }

    public synchronized void C(){
        while (flag != 3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag =1;
        notifyAll();
        count++;
    }

    public int getCount() {
        return count;
    }


    public static void main(String[] args) {
        ABCABC print = new ABCABC();
        MyThread2 thread = new MyThread2(print);
        new Thread(thread,"A").start();
        new Thread(thread,"B").start();
        new Thread(thread,"C").start();
    }
}

class MyThread2 implements Runnable{
    private ABCABC print;

    public MyThread2(ABCABC print) {
        this.print = print;
    }

    @Override
    public void run() {
        while (print.getCount()<13){
            if(Thread.currentThread().getName().equals("A")){
                print.A();
            }else if(Thread.currentThread().getName().equals("B")){
                print.B();
            }else if(Thread.currentThread().getName().equals("C")) {
                print.C();
            }
        }
    }
}
