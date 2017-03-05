# Microservices

This directory contains the different microservices developed in the book. In order of appearance:

* [Hello Microservice - HTTP](hello-microservice-http)
* [Hello Consumer Microservice - HTTP](hello-consumer-microservice-http)
* [Hello Microservice - Event Bus](hello-microservice-message)
* [Hello Consumer Microservice - Event Bus](hello-consumer-microservice-message)
* [Hello Microservice with faults](hello-microservice-faulty)
* [Hello Consumer Microservice with timeout and reply](hello-consumer-microservice-timeout)

The _-consumer_ projects invoke the corresponding services:

* The [Hello Consumer Microservice - HTTP](hello-consumer-microservice-http) invokes the [Hello Microservice - HTTP](hello-microservice-http).
* The [Hello Consumer Microservice - Event Bus](hello-consumer-microservice-message) invokes the [Hello Microservice - Event Bus](hello-microservice-message).
* The [Hello Consumer Microservice with timeout and reply](hello-consumer-microservice-timeout) invokes the [Hello Microservice with faults](hello-microservice-faulty).
   
Be aware to run both at the same time.  
 
Each project is built with Apache Maven:
 
```
cd $DIRECTORY
mvn clean package
```
 
Each project contains a `README` with running instructions. 
