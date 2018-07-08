package geym.conc.ch3.synctrl;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (lock == 1) {
            while (true) {
                if (lock1.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }
                        // System.out.println(Thread.currentThread().getId() + "获得lock1,即将请求lock2");
                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread()
                                        .getId() + ":My Job done");
                                return;
                            } finally {
                                lock2.unlock();
                            }
                        }
                    } finally {
                        lock1.unlock();
                    }
                }
            }
        } else {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }
                        //System.out.println(Thread.currentThread().getId() + "获得lock2,即将请求lock1");       //添加打印输出，让效果更加明显可见！
                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread()
                                        .getId() + ":My Job done");
                                return;
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // System.out.println("这个例子演示了，使用tryLock()可以破除死锁，有非常大的价值");
        TryLock r1 = new TryLock(1);
        TryLock r2 = new TryLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        //让主线程，等待两个子线程先执行完
        //t1.join();
        //t2.join();
        //System.out.println("只要执行足够长的时间，线程总是会得到所有需要的资源，从而正常执行.就算在死锁状态也会被破除！");
    }
}
