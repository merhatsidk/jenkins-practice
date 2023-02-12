FROM openjdk:8
EXPOSE 8080
ADD target/devops-integeration.jar devops-integeration.jar
ENTRYPOINT ["java","-jar","/devops-integeration.jar"]