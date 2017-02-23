package tutorial.concurrency;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 2/22/2017.
 */

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class AddThread implements Runnable {
    private List<Double> list;

    public AddThread(List<Double> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000; ++i) {
            list.add(Math.random());
        }
        System.out.println("list size is "+list.size());
    }
}

public class TestCopyOnWriteList {
    private static final int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) {
       // List<Double> list = new ArrayList<>();
        List<Double> list = new CopyOnWriteArrayList<>();

        ExecutorService es = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        es.execute(new AddThread(list));
        es.execute(new AddThread(list));
        es.shutdown();
    }
}
