package geym.conc.ch3.fork;

public class CountTaskOneThread {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (long i = 1; i <= 2000000000L; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("单线程计算花费时间：" + (end - start) / 1000 + " s");
        System.out.println("总和为：" + sum);

    }

}
