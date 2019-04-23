package JavaSE;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;

class MyThreadd implements Runnable{

    @Override
    public void run() {
        for (int i =0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"、"+i);
        }
    }
}


public class ThreadPool {
    public static void main(String[] args) {
        MyThreadd myThreadd = new MyThreadd();
        ExecutorService executorService = new ThreadPoolExecutor(3,5,2000,
                TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
        for(int i= 0 ;i<5;i++){
            executorService.submit(myThreadd);
        }
        executorService.shutdown();
    }
}

