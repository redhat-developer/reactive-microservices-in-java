# Hello Consumer Microservice - Event Bus with timeout and reply

This directory contains the source code of the _Hello_ microservice consumer using event bus (message) interactions. It implements a simple fault-tolerance strategy using timeouts and retries. It invokes the [Hello microservice - Event Bus - Faulty](../hello-microservice-faulty).

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
java -jar target/hello-consumer-microservice-timeout-1.0-SNAPSHOT.jar -cluster -Djava.net.preferIPv4Stack=true
``` 
 
