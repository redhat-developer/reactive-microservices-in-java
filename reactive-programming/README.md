# Very simple RX examples

This project contains the RX examples given in the book. There are far from being a complete introduction to reactive
 programming and RX-Java.
 
 The examples are intended to be run directly from the _main_ method of the different classes. So, once imported in 
 your IDE, you should be able to run them. Alternatively, you can package the project and run them using:
  

```
java -cp target/reactive-programming-example-1.0-SNAPSHOT.jar FULLY_QUALIFIED_CLASS_NAME
```

For example:

```
java -cp target/reactive-programming-example-1.0-SNAPSHOT.jar io.vertx.book.rx.ObservableExample

```

## Packaging the project

Just run:

```
./mvnw package
```

On Windows, use:

```
./mvnw.bat package
```


