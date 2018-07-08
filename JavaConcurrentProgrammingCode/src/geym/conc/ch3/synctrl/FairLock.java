package geym.conc.ch3.synctrl;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:公平锁演示
 */
public class FairLock implements Runnable {
    // 非公平锁，一个线程会扎堆执行
    //public static ReentrantLock fairLock = new ReentrantLock();
    //参数表式公平锁，线程交替执行
    public static ReentrantLock fairLock = new ReentrantLock(true);


    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + " 获得锁");
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1, "Thread_t1");
        Thread t2 = new Thread(r1, "Thread_t2");
        t1.start();
        t2.start();
    }
}
