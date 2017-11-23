FROM java:8

RUN mkdir /opt/tomcat
RUN	curl -s http://apache-mirror.rbc.ru/pub/apache/tomcat/tomcat-8/v8.5.23/bin/apache-tomcat-8.5.23.tar.gz | tar --strip-components 1 -xzf - -C /opt/tomcat
RUN	wget -q http://central.maven.org/maven2/org/postgresql/postgresql/42.1.4/postgresql-42.1.4.jar -O /opt/tomcat/lib/postgresql-42.1.4.jar

EXPOSE 8080

WORKDIR /opt/tomcat
CMD ["./bin/catalina.sh", "run"]
