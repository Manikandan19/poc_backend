FROM java:openjdk-8-jre

# add directly the war
ADD *.war /app.war

RUN sh -c 'touch /app.war'
VOLUME /tmp
EXPOSE 8002 5701/udp
CMD java -Djava.security.egd=file:/dev/./urandom -jar /app.war
