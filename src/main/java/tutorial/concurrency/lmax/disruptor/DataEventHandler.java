package tutorial.concurrency.lmax.disruptor;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 2/28/2017.
 */
import com.lmax.disruptor.EventHandler;

public class DataEventHandler implements EventHandler<DataEvent>
{
    public void onEvent(DataEvent event, long sequence, boolean endOfBatch)
    {
        System.out.println("get Event data " + event.getData());
        System.out.println("Doing business logic!");
    }
}
