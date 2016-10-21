package tutorial;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 10/21/2016.
 */
public class ConverterUtil {

    static Converter<String, Integer> converter=(from) -> Integer.valueOf(from);

    public static Object convert(String from) {

           return converter.convert(from);
    }
}
