# Hello Microservice - OpenShift

This directory contains the source code of the _Hello_ microservice running on top of OpenShift.

## Deployment
 
```
mvn fabric8:deploy -Popenshift 
```

## Accessing the service

Open the route url from the OpenShift dashboard. Alternatively, you can retrieve the route url as follows:

```
$ oc describe routes hello-microservice 
  Name:                   hello-microservice
  Namespace:              reactive-microservices
  Created:                2 minutes ago
  Labels:                 group=io.vertx.book
                          project=hello-microservice
                          provider=fabric8
                          version=1.0-SNAPSHOT
  Annotations:            openshift.io/host.generated=true
  Requested Host:         hello-microservice-reactive-microservices.192.168.64.12.xip.io
                            exposed on router router 2 minutes ago
  Path:                   <none>
  TLS Termination:        <none>
  Insecure Policy:        <none>
  Endpoint Port:          http
  
  Service:        hello-microservice
  Weight:         100 (100%)
  Endpoints:      172.17.0.9:8080
$ curl hello-microservice-reactive-microservices.192.168.64.12.xip.io 
```

Or:

```
oc describe routes hello-microservice | grep "Requested" | awk '{$1=""; print $3}'
```