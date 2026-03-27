FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY build/libs/my-app-0.0.1-SNAPSHOT.jar app.jar
# 외부에서 주입되는 application.yml 참조
COPY application.yml ./application.yml
EXPOSE 9090
ENTRYPOINT [ "java", "-jar", "app.jar" ]