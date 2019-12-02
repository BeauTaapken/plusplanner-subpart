# Alpine Linux with OpenJDK JRE
FROM openjdk:11
# copy WAR into image
# COPY spring-boot-app-0.0.1-SNAPSHOT.war /app.war
COPY <artifact>.jar /<path>/<artifact>.jar
# run application with this command line 
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/app.war"]
