# Vert.x Application Packaging with Apache Maven and the Maven-Shade-Plugin

This example shows how you can use Apache Maven (http://maven.apache.org/) to package a Vert.x application as a _fat jar_. This example uses the Maven Shade Plugin (https://maven.apache.org/plugins/maven-shade-plugin/).


## Build the application

Just run:

```
./mvnw clean package
```

On Windows, use:

```
./mvnw.bat clean package
```

## Run the application

The application is packaged into `target/vertx-hello-1.0-SNAPSHOT.jar`. Launch it with:

```
java -jar target/vertx-hello-1.0-SNAPSHOT.jar 
```

Then, open a browser to: http://localhost:8080, you should see "Hello from Vert.x".


