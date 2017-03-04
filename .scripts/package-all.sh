#!/usr/bin/env bash


function check {
  if [ $? -eq 0 ]; then
      echo "Build success - OK"
  else
      echo "Build success - KO !!!!"
      exit 1
  fi
}

echo "Checking hello-vertx"
cd hello-vertx
mvn clean package > build.txt
check
cd ..

# Microservices

cd microservices

echo "Checking HTTP"
cd hello-microservice-http
mvn clean package > build.txt
check
cd ..

echo "Checking HTTP Consumer"
cd hello-consumer-microservice-http
mvn clean package > build.txt
check
cd ..

echo "Checking Message"
cd hello-microservice-message
mvn clean package > build.txt
check
cd ..

echo "Checking Message Consumer"
cd hello-consumer-microservice-message
mvn clean package > build.txt
check
cd ..

echo "Checking Message Faulty"
cd hello-microservice-faulty
mvn clean package > build.txt
check
cd ..

echo "Checking Message Consumer Timeout"
cd hello-consumer-microservice-timeout
mvn clean package > build.txt
check
cd ..

cd ..

# Openshift
cd openshift
echo "Checking hello-microservice-consumer-openshift"
cd hello-microservice-consumer-openshift
mvn clean package > build.txt
check
cd ..

echo "Checking hello-microservice-openshift"
cd hello-microservice-openshift
mvn clean package > build.txt
check
cd ..

echo "Checking hello-microservice-consumer-openshift-circuit-breaker"
cd hello-microservice-consumer-openshift-circuit-breaker
mvn clean package > build.txt
check
cd ..

echo "Checking hello-microservice-openshift-health-checks"
cd hello-microservice-openshift-health-checks
mvn clean package > build.txt
check
cd ..

cd ..

echo "Checking RX"
cd reactive-programming
mvn clean package > build.txt
check
cd ..

# Packaging
cd packaging-examples
echo "Checking ant build"
cd ant
ant > build.txt
check
cd ..

echo "Checking gradle build"
cd gradle
./gradlew shadowJar > build.txt
check
cd ..

echo "Checking shade plugin build"
cd maven-shade-plugin
./mvnw clean package > build.txt
check
cd ..

echo "Checking vmp build"
cd vertx-maven-plugin
./mvnw clean package > build.txt
check
cd ..

echo "DONE"
find . -name "build.txt" -exec rm -Rf {} \;




