package geym.conc.ch4.tl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description: SimipleDateFonnat.parse()方法并不是线程安全的 。 因此，在线程
 * 池中共享这个对象必然导致错误 。笨例执行会引发异常！
 */
public class ThreadLocalDemo {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static class ParseDate implements Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        public void run() {
            try {
                Date t = sdf.parse("2015-03-29 19:29:" + i % 60);
                System.out.println(i + ":" + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            es.execute(new ParseDate(i));
        }
    }
}
