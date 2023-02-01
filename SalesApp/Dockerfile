FROM openjdk:11
VOLUME /tmp
EXPOSE 8082
ARG JAR_FILE=target/sales-app.jar
ADD ${JAR_FILE} sales-app.jar
ENTRYPOINT ["java","-jar","/sales-app.jar"]