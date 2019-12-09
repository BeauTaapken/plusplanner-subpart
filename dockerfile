
FROM openjdk:11-jdk
VOLUME /tmp
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "plusplannerapi-0.0.1-SNAPSHOT.jar"]