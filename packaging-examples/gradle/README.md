# Vert.x Application Packaging with Gradle

This example shows how you can use Gradle (https://gradle.org/) to package a Vert.x application as a _fat jar_.


## Build the application

Just run:

```
./gradlew shadowJar
```

On Windows, use:

```
./gradlew.bat shadowJar
```

It will download _gradle_ automatically, compile and package the application.

## Run the application

The application is packaged into `build/libs/vertx-hello-all.jar`. Launch it with:


```
java -jar build/libs/vertx-hello-all.jar 
```

Then, open a browser to: http://localhost:8080, you should see "Hello from Vert.x".


