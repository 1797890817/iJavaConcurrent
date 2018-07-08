package geym.conc.ch2.create;

public class CreateThread3 implements Runnable {

    public static void main(String[] args) {
        //java中继承是宝贵资源(因为是单继承)，尽量使用实现接口的方式
        Thread t1 = new Thread(new CreateThread3());
        t1.start();
    }

    @Override
    public void run() {
        System.out.println("Oh, I am Runnable");
    }


}
