FROM openjdk:19-jdk-alpine
VOLUME /tmp
ADD ./target/sprint-boot-servicio-item-0.0.1-SNAPSHOT.jar  servicio-items.jar
EXPOSE 8002
ENTRYPOINT ["java", "-jar","/servicio-items.jar"]