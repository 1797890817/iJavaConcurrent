package geym.conc.ch2.create;

public class CreateThread {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.start();        //启动线程，交由CPU执行，并不是立即执行
    }
}
