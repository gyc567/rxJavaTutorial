package tutorial.concurrency.lmax.disruptor;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 2/28/2017.
 */

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public class DataEventProducer
{
    private final RingBuffer<DataEvent> ringBuffer;

    public DataEventProducer(RingBuffer<DataEvent> ringBuffer)
    {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer bb)
    {
        long sequence = ringBuffer.next();  // Grab the next sequence
        try
        {
            DataEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
            // for the sequence
            event.set(bb.getLong(0));  // Fill with data
            event.setData("bb"+bb.getLong(0));
        }
        finally
        {
            ringBuffer.publish(sequence);
        }
    }
}
