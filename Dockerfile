FROM maven:3.8.3-openjdk-17

WORKDIR /analyzeFXDeal

COPY /target/*.jar ./java.jar

EXPOSE 8080

CMD ["java", "-jar", "java.jar"]
