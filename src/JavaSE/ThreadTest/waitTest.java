package JavaSE.ThreadTest;



class MyThread1 implements Runnable{
    private Object object;
    private boolean flag;

    public MyThread1(Object object, boolean flag) {
        this.object = object;
        this.flag = flag;
    }

    public void waitmethod() throws InterruptedException {
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+" start");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" end");
        }
    }
    public  void notifymethod(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+" start");
            object.notify();
            System.out.println(Thread.currentThread().getName()+" end");
        }
    }

    @Override
    public void run() {
        if(flag ==true){
            try {
                waitmethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            notifymethod();
        }
    }
}

public class waitTest{

    public static void main(String[] args) throws InterruptedException {
        //对象的对象锁
        Object object = new Object();
        //创建类对象调用方法
        MyThread1 wait = new MyThread1(object,true);
        MyThread1 notify = new MyThread1(object,false);
        //创建Thread类对象启动线程
        Thread waitthread = new Thread(wait,"wait");
        Thread notifythread = new Thread(notify,"notify");
        waitthread.start();
        Thread.sleep(1000);
        notifythread.start();
    }
}
