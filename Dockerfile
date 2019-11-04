FROM frolvlad/alpine-oraclejre8

MAINTAINER ayodeji.ilori@arca.network

WORKDIR /work

ADD target/demo-api-0.0.1-SNAPSHOT.jar /work/demo-api.jar

ARG JAVA_OPTS

ENV JAVA_OPTS -Xmx512m

# Expose Ports
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","/work/demo-api.jar"]



