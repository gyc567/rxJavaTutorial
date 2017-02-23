package tutorial;

import java.util.stream.Stream;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 11/7/2016.
 */
public class SolutionForBinaryGap {

    private  int a=0;
    private  String b="";
    private String[] str;

    public SolutionForBinaryGap(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public SolutionForBinaryGap(String... str) {
        this.str = str;
    }

    public static int getLongestZeroNumber(int N) {
        return Stream.of(
                Integer.toBinaryString(N).replaceAll("0+$", "").split("1+")
        ).filter(a -> a != null)
                .map(String::length)
                .max(Integer::compare)
                .orElse(0);

    }
}
