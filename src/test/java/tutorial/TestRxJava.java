package tutorial;

import org.junit.Test;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by eric567 [email:gyc567@126.com]
 * on 8/30/2016.
 */
public class TestRxJava {

    @Test
    public void test_hello_world() {

        Observable.just("Hello, world!").map(s -> s + " -Dan")
                .subscribe(s -> System.out.println(s));
        System.out.println("-----------------------------------");

        Observable.just("Hello, RX")
                .map(s -> s.hashCode())
                .map(i -> Integer.toString(i))
                .map(i -> i + 1)
                .map(i -> i.toString())
                .map(s -> s + "at")
                .map(s -> s.toUpperCase())
                .subscribe(i -> System.out.println(i));


        System.out.println("-----------------------------------");
        String[] urls = {"url1", "url2"};
        Observable.from(urls)
                .subscribe(url -> System.out.println(url));


        System.out.println("-----------------------------------");
        String[] urlls = {"url_a", "url_b", "url_c"};
        query("key word")//search from text
                .flatMap(urlss -> Observable.from(urlls))
                .flatMap(url -> getTitle(url))
                .subscribe(title -> System.out.println(title));

        System.out.println("-----------------------------------");
        String[] urlls_filter = {"url_a", "url_b", "url_c","url_d"};
        query("key word")//search from text
                .flatMap(urlss -> Observable.from(urlls_filter))
                .flatMap(url -> getTitle(url))
                .filter(title -> !title.contains("a"))
                .take(5)
                .doOnNext(title -> saveTitle(title))
                .subscribeOn(Schedulers.io())
                .subscribe(title -> System.out.println(title));

    }

    public Observable<String> query(String txt) {
        return Observable.just(txt);
    }

    public Observable<String> getTitle(String txt) {
        return Observable.just(txt + "||title");
    }

    public void saveTitle(String txt) {
        System.out.println(txt + "is saved!");
    }


}
