package tutorial
/**
 * Created by eric567 [email:gyc567@126.com] 
 * on 10/21/2016.
 */
import spock.lang.Specification
class FormulaTest extends Specification {
    def "Calculate"() {
        given: "an instance of Formula "
        Formula formula=new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        int num=100;
        when:"invoke the method calculate of this instance with @param num"
        int rt=formula.calculate(num)
        then:"the result shall be 100"
        rt==100
    }

    def "Sqrt"() {

        given:"an instance of Formula"
        Formula formula=new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        int num=100
        when:"invoke the method calculate of this instance with @param num"
        int rt=formula.sqrt(num)
        then:"the result shall be 10"
        rt==10



    }
}
