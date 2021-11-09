FROM openjdk:11
VOLUME /tmp
EXPOSE 8021
ADD ./target/repot-0.0.1-SNAPSHOT.jar repot.jar
ENTRYPOINT ["java","-jar","/repot.jar"]