FROM openjdk:11
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/BookApp.jar
ADD ${JAR_FILE} BookApp.jar
ENTRYPOINT ["java","-jar","/BookApp.jar"]
#mvn clean install -DskipTests