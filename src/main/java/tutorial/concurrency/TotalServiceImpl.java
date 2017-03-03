package tutorial.concurrency;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 2/22/2017.
 */
public class TotalServiceImpl implements TotalService{
    @Override
    public void count() {
        System.out.println("-----CyclicBarrierTest service count-------");
    }
}
