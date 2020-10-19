FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE}  cloud-hystrix-payment-server8001-1.0.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar","/cloud-hystrix-payment-server8001-1.0.jar"]
