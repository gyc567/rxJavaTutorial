package tutorial.concurrency.sample;

import java.util.concurrent.Semaphore;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 2/22/2017.
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for(int i=0;i<N;i++)
            new Worker(i,semaphore).start();
    }

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("worker"+this.num+"using one machine to producing...");
                Thread.sleep(2000);
                System.out.println("worker"+this.num+"release the machine");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
