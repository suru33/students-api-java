FROM openjdk:16-alpine
MAINTAINER suru33<33urus@gmail.com>

WORKDIR app

COPY build/libs/* /app/
COPY docker/entrypoint.sh .

ENTRYPOINT ["./entrypoint.sh"]