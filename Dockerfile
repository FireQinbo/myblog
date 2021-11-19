FROM java:8

MAINTAINER Mr.Qin <fire_qinbo@foxmail.com>

ENV TZ=Asia/Shanghai

EXPOSE 8090

ADD target/myblog.jar /docker/myblog_local/app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/docker/myblog_local/app.jar", "--server.port=8090"]
