FROM eclipse-temurin:17-jre-alpine

RUN apk update

RUN apk upgrade

WORKDIR /app

COPY tax-prep-app/target/tax-prep-app-0.0.1-SNAPSHOT.jar /app/taxprepapp.jar

EXPOSE 8080

CMD ["java", "-jar", "taxprepapp.jar"]