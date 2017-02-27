package io.vertx.book.rx;

import rx.Observable;

/**
 * Demonstrate how RX java allows observing stream
 */
public class ObservableExample {

    
    public static void main(String[] args) {
        // Create a stream of integer [0..20]
        Observable<Integer> observable = Observable.range(0, 21);

        observable.subscribe(
            data -> {
                // Called with the next data available in the stream
                System.out.println(data);
            },
            error -> {
                // Called when an error occurs
                error.printStackTrace();
            },
            () -> {
                // Called when we reached the end of the stream
                System.out.println("No more data");
            }
        );
    }

}
