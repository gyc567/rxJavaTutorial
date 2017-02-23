package tutorial.concurrency.sample;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 2/22/2017.
 */
public class CyclicBarrierReusingTest {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier  = new CyclicBarrier(N);

        for(int i=0;i<N;i++) {
            new Writer(barrier).start();
        }

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---------CyclicBarrier reusing-----");

        for(int i=0;i<N;i++) {
            new Writer(barrier).start();
        }
    }
    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("Thread"+Thread.currentThread().getName()+"writing data...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("Thread"+Thread.currentThread().getName()+"finish wrote date,waiting other thread");

                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"threads finish job, now do other job!...");
        }
    }
}
