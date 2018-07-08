package geym.conc.ch2.join;

/**
 * Description:at.join();让调用者线程等等当前线程
 */
public class JoinMain {
    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 10000000; i++) ;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
        //原代码没有这一行为了效果更加明显，才添加的
        Thread.sleep(5);
        at.join();
        System.out.println(i);
    }
}
