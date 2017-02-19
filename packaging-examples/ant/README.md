= Vert.x Application Packaging with Apache Ant

This example shows how you can use Apache Ant (http://ant.apache.org/) and Ivy (http://ant.apache.org/ivy/) to 
package a Vert.x application as a _fat jar_.

== Initialization

You first need to retrieve Ivy and install the application dependencies. The dependencies are described in the `ivy.xml` file.

```
# Install Ivy locally
ant ivy 

# Resolve the dependencies
ant resolve
```

== Package

Once the dependencies are resolved, you can build the application _fat-jar_ with:

```
ant
```

== Run

The application is packaged into `dist/vertx-hello.jar`. Launch it with:


```
java -jar dist/vertx-hello.jar
```

Then, open a browser to: http://localhost:8080, you should see "Hello from Vert.x".

