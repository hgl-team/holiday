FROM openjdk:11-slim
USER root
RUN mkdir /opt/application
COPY target/holiday.war /opt/application/holiday.war

# Fix Timezone
RUN rm -rf /etc/localtime
RUN ln -s /usr/share/zoneinfo/America/Bogota /etc/localtime

RUN mkdir /usr/share/ca-certificates/lujociclas
COPY ca.lujociclas.com.crt /opt/application/ca.lujociclas.com.crt
COPY domain.lujociclas.com.crt /opt/application/domain.lujociclas.com.crt
COPY ca.lujociclas.com.crt /usr/share/ca-certificates/lujociclas/ca.lujociclas.com.crt
COPY domain.lujociclas.com.crt /usr/share/ca-certificates/lujociclas/domain.lujociclas.com.crt

RUN echo 'lujociclas/ca.lujociclas.com.crt' >> /etc/ca-certificates.conf
RUN echo 'lujociclas/domain.lujociclas.com.crt' >> /etc/ca-certificates.conf
RUN update-ca-certificates
RUN keytool -importcert -trustcacerts -file /opt/application/ca.lujociclas.com.crt -alias ca.lujociclas.com -cacerts -storepass changeit -noprompt
RUN keytool -importcert -trustcacerts -file /opt/application/domain.lujociclas.com.crt -alias domain.lujociclas.com -cacerts -storepass changeit -noprompt

RUN addgroup spring && adduser --ingroup spring spring
USER spring:spring
EXPOSE @servlet.port@/tcp
EXPOSE @servlet.port@/udp
ENTRYPOINT ["java", "-jar", "/opt/application/holiday.war"]
