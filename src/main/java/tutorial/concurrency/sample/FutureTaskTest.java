package tutorial.concurrency.sample;

import java.util.concurrent.*;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 2/22/2017.
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();

       // Future<Integer> result = executor.submit(task);
        FutureTask<Integer> result = new FutureTask<Integer>(task);
        executor.submit(result);

        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("main thread is running!");

        try {
            System.out.println("task result--->"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("all job is finished!");
    }
}
class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("the sub thread is counting....");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
    }
}