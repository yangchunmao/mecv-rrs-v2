
FROM ycm/jdk7:v1.0
VOLUME /tmp
ADD mecv-user-0.0.1-SNAPSHOT.jar /opt/jar/
ENV JAVA_HOME /opt/jdk1.7.0_76
ENV PATH $PATH:$JAVA_HOME/bin
CMD [ "java", "-jar", "/opt/jar/mecv-user-0.0.1-SNAPSHOT.jar --server.port=8080" ]