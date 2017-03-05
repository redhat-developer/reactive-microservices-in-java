# Microservices on OpenShift

This directory contains the different microservices running on top of OpenShift developed in the book. In order of appearance:

* [Hello Microservice](hello-microservice-openshift)
* [Hello Consumer Microservice](hello-microservice-consumer-openshift)
* [Hello Microservice with Health Check](hello-microservice-openshift-health-checks)
* [Hello Consumer Microservice with Circuit Breaker](hello-microservice-consumer-openshift-circuit-breaker)
 
Each project is built with Apache Maven:
 
```
cd $DIRECTORY
mvn clean package
```
 
Each project contains a `README` with running instructions. 


You need access to an OpenShift v3.x instance to run them. Either use [OpenShift Online](https://www.openshift.com/devpreview/) of []MiniShift](https://github.com/minishift/minishift).

Once running, login using the `oc` command line. For MiniShift, use:

```
oc login https://192.168.64.12:8443 -u developer -p developer
```

Also, create a new project:

```
oc new-project reactive-microservices
oc policy add-role-to-user admin developer -n reactive-microservices
oc policy add-role-to-user view -n reactive-microservices -z default
```

NOTE: on OpenShift Online you may not be able to create a new project (as you have a limited number of projects). In this context, run:

```
oc project -q # Print the name of the current project
oc policy add-role-to-user admin developer -n $PROJECT_NAME
oc policy add-role-to-user view -n $PROJECT_NAME -z default
```

Replace `$PROJECT_NAME` by the name printed by the first command.

Then, open the OpenShift console:
 
* OpenShift Online - https://console.preview.openshift.com/console/
* MiniShift - https://192.168.64.12:8443/console/ (`developer/developer`)



