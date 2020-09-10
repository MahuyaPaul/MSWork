FROM openjdk:8-jdk-alpine
#EXPOSE 8761
#ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8761,suspend=n"
ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,suspend=n"
# Copy executable jar file from the builder image
COPY target/eureka-naming-server-0.0.1-SNAPSHOT.jar app.jar
# Run executable jar file
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

