# Hello Microservice - Event Bus

This directory contains the source code of the _Hello_ microservice using event bus (message) interactions.

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
java -jar target/hello-microservice-message-1.0-SNAPSHOT.jar -cluster -Djava.net.preferIPv4Stack=true
``` 
 
