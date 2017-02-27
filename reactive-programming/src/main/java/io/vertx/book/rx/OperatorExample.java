package io.vertx.book.rx;

import rx.Observable;

/**
 * An example using RX operators
 */
public class OperatorExample {

    public static void main(String[] args) {
        // Create a stream of integer [0..20]
        Observable<Integer> observable = Observable.range(0, 21);
        Observable<Integer> anotherObservable = Observable.range(0, 21);

        observable
            .map(i -> i + 1)
            .zipWith(anotherObservable, (a, b) -> a + b)
            .subscribe(
                System.out::println,
                Throwable::printStackTrace,
                () -> {
                    // Called when we reached the end of the stream
                    System.out.println("No more data");
                }
            );
    }
}
