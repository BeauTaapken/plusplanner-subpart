# Set WORKDIR
# WORKDIR /
# Open JDK:11
FROM openjdk:11
# copy WAR into image
# COPY spring-boot-app-0.0.1-SNAPSHOT.war /app.war
COPY plusplannerapi-0.0.1-SNAPSHOT.jar /target/plusplannerapi-0.0.1-SNAPSHOT.jar
# run application with this command line 
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "plusplannerapi-0.0.1-SNAPSHOT.jar"]
