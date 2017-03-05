# Hello Consumer Microservice - HTTP

This directory contains the source code of the _Hello_ microservice consumer using HTTP interactions. It invokes the [Hello microservice - HTTP](../hello-microservice-http).

## Running in development mode
 
 
```
mvn compile vertx:run
```

Hit `CTRL+C` to stop the execution and reloading.


## Packaging
      
```
mvn clean package
```
 
## Execution using the application package
 
```
java -jar target/hello-consumer-microservice-http-1.0-SNAPSHOT.jar 
``` 
 
