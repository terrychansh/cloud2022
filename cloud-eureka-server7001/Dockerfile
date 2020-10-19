FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE}  cloud-eureka-server7001-1.0.jar
EXPOSE 7001
ENTRYPOINT ["java","-jar","/cloud-eureka-server7001-1.0.jar"]
