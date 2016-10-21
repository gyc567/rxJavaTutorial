package tutorial;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 10/21/2016.
 */
public class ConverterUtil {

//    static Converter<String, Integer> converter=(from) -> Integer.valueOf(from);


    public static Object convert(String from) {
        Converter<String, Integer> converter=Integer::valueOf;
           return converter.convert(from);
    }

    public static Object startWith(String from)
    {
        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        return converter.convert(from);

    }


    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }
}
