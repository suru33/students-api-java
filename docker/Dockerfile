FROM openjdk:16-alpine
WORKDIR app
COPY build/libs/* /app/
COPY docker/entrypoint.sh .
ENTRYPOINT ["./entrypoint.sh"]