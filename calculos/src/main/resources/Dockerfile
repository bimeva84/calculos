FROM openjdk:8-jdk-alpine  
ADD calculos-0.0.1-SNAPSHOT.war calculos.war 
EXPOSE 8037 
RUN /bin/sh -c 'touch calculos.war' 
ENTRYPOINT ["java","-Xmx512m","-Xms128m", "-jar","calculos.war"]
