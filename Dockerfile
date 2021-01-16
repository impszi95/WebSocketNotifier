#
# Build stage
#
FROM maven:3.6.3-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM fabric8/java-alpine-openjdk11-jre
COPY --from=build /home/app/target/*.jar /usr/local/lib/demo.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]