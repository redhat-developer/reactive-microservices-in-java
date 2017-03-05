# Hello Microservice Consumer - OpenShift

This directory contains the source code of the _Hello_ consumer microservice running on top of OpenShift. It requires the deployment of the [Hello Microservice](../hello-microservice-openshift).

## Deployment
 
```
mvn fabric8:deploy -Popenshift 
```

## Accessing the service

Open the route url from the OpenShift dashboard. Alternatively, you can retrieve the route url as follows:

```
$ oc describe routes hello-consumer 
Name:                   hello-consumer
Namespace:              reactive-microservices
Created:                About a minute ago
Labels:                 group=io.vertx.book
                        project=hello-consumer
                        provider=fabric8
                        version=1.0-SNAPSHOT
Annotations:            openshift.io/host.generated=true
Requested Host:         hello-consumer-reactive-microservices.192.168.64.12.xip.io
                          exposed on router router about a minute ago
Path:                   <none>
TLS Termination:        <none>
Insecure Policy:        <none>
Endpoint Port:          http

Service:        hello-consumer
Weight:         100 (100%)
Endpoints:      172.17.0.10:8080
$ curl hello-consumer-reactive-microservices.192.168.64.12.xip.io 
```

Or:

```
oc describe routes hello-consumer | grep "Requested" | awk '{$1=""; print $3}'
```