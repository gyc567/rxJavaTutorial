package tutorial.concurrency.sample;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 2/22/2017.
 */
public class BillServiceImpl implements BillService{
    @Override
    public void bill(String code) {
        System.out.println(code+"---------Bill service billing---------");
    }
}
