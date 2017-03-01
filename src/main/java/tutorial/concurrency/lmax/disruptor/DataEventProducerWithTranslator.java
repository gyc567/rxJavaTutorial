//package tutorial.concurrency.lmax.disruptor;
//
///**
// * Created by eric567 [email:gyc567@126.com]
// * on 2/28/2017.
// */
//
//import com.lmax.disruptor.EventTranslatorOneArg;
//import com.lmax.disruptor.RingBuffer;
//
//import java.nio.ByteBuffer;
//
//public class DataEventProducerWithTranslator
//{
//    private final RingBuffer<DataEvent> ringBuffer;
//
//    public DataEventProducerWithTranslator(RingBuffer<DataEvent> ringBuffer)
//    {
//        this.ringBuffer = ringBuffer;
//    }
//
//    private static final EventTranslatorOneArg<DataEvent, ByteBuffer> TRANSLATOR =
//            new EventTranslatorOneArg<DataEvent, ByteBuffer>()
//            {
//                public void translateTo(DataEvent event, long sequence, ByteBuffer bb)
//                {
//                    event.set(bb.getLong(0));
//                }
//            };
//
//    public void onData(ByteBuffer bb)
//    {
//        ringBuffer.publishEvent(TRANSLATOR, bb);
//    }
//}
