package tutorial;

import java.util.List;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 10/21/2016.
 */
public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
    default List<String> sort(List<String> names)
    {

        names.sort((a, b) -> b.compareTo(a));
        return names;
    }
}
