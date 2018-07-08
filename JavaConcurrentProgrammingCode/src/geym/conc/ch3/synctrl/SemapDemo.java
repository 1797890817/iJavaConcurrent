package geym.conc.ch3.synctrl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemapDemo implements Runnable {
    //信号量却可 以指定多个线程 ，同时访问 某一个资源。此处指定数量为5
    final Semaphore semp = new Semaphore(5);
    //final Semaphore semp = new Semaphore(5,true);    //第二个参数指定是否是公平的

    @Override
    public void run() {
        try {
            semp.acquire();     //申请许可证
            //模拟耗时操作
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ":done!");
            semp.release();     //释放许可证
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo demo = new SemapDemo();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);
        }
    }
}
