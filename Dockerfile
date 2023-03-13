#PRODUCT MICROSERVICE DOCKERFILE 
#base image for the Dockerfile
FROM openjdk:8-jdk-alpine
#ADD [SOURCE] [DESTINATION]
ADD target/productservice-0.0.1-SNAPSHOT.jar productservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar", "productservice-0.0.1-SNAPSHOT.jar"]
