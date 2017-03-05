# Hello Consumer Microservice - Event Bus

This directory contains the source code of the _Hello_ microservice consumer using event bus (message) interactions. It invokes the [Hello microservice - Event Bus](../hello-microservice-message).

## Running in development mode
  
```
mvn compile vertx:run -Dvertx.runArgs="-cluster -Djava.net.preferIPv4Stack=true"
```

Hit `CTRL+C` to stop the execution and reloading. 


## Packaging
      
```
mvn clean package
```
 
## Execution using the application package
 
```
java -jar target/hello-consumer-microservice-message-1.0-SNAPSHOT.jar -cluster -Djava.net.preferIPv4Stack=true
``` 
 
