FROM openjdk:8
# 个人信息
MAINTAINER zhongyj "1126834403@qq.com"

VOLUME /dimples/logs/myblog/tmp
ADD ./../../../target/dimples-blog.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]