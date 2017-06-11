package tutorial;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 6/11/2017.
 */
import org.testng.annotations.*;

public class TestNGDemo {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        System.out.println("Fast test");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}
