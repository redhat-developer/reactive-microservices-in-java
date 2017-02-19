# Vert.x Application Packaging with Apache Maven and the Maven-Shade-Plugin

This example shows how you can use Apache Maven (http://maven.apache.org/) to package a Vert.x application as a _fat jar_. This example uses the Vert.x Maven Plugin (https://vmp.fabric8.io/).


## Build the application

Just run:

```
./mvnw package
```

On Windows, use:

```
./mvnw.bat package
```

## Run the application

The application is packaged into `target/vertx-hello-1.0-SNAPSHOT.jar`. Launch it with:

```
java -jar target/vertx-hello-1.0-SNAPSHOT.jar 
```

Then, open a browser to: http://localhost:8080, you should see "Hello from Vert.x".

## Run the application in development mode

If you want to modify the application code and get _hot_ reload, just launch:

```
mvn compile vertx:run
```

Now, update your source files and save. The application is re-packaged and restarted.


