# Build stage

FROM maven:3-amazoncorretto-21 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

# Package stage
FROM eclipse-temurin:21-jre-alpine
COPY --from=build /home/app/target/javalin-animal-app.jar /usr/local/lib/javalin-animal-app.jar
EXPOSE 7000
ENTRYPOINT ["java","-jar","/usr/local/lib/javalin-animal-app.jar"]