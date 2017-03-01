package tutorial.concurrency.lmax.disruptor;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 2/28/2017.
 */
import com.lmax.disruptor.EventFactory;

public class DataEventFactory implements EventFactory<DataEvent>
{
    public DataEvent newInstance()
    {
        return new DataEvent();
    }
}
