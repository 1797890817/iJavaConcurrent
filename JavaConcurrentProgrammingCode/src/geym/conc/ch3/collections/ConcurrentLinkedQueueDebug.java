
package geym.conc.ch3.collections;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDebug {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
        q.add("1");
        q.poll();
        q.add("3");
        System.out.println(q);
    }
}
