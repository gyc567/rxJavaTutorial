package tutorial;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 10/21/2016.
 */
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
