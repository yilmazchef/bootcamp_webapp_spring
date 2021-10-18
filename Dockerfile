FROM openjdk:11
MAINTAINER Yilmaz Mustafa <yilmaz@mail.be>
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bootcamp-backend.jar
ENTRYPOINT ["java","-jar","/bootcamp-backend.jar"]