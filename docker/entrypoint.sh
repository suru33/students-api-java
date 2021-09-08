#!/bin/sh

java -jar -Dspring.profiles.active=${ENV} /app/students-api-1.0.jar
