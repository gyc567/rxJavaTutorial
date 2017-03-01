package tutorial.concurrency.lmax.disruptor;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 2/28/2017.
 */
public class DataEvent
{
    private long value;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void set(long value)
    {
        this.value = value;
    }
}
