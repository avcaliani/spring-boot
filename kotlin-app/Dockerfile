# ----------------------------------------------------
#  BUILD CONTAINER
# ----------------------------------------------------
FROM maven:3.6.0-jdk-8-alpine as builder

WORKDIR /builder
ADD . /builder
RUN mvn clean install package


# ----------------------------------------------------
#  APPLICATION CONTAINER
# ----------------------------------------------------
FROM openjdk:8-jre-alpine

ENV PORT 8080
ENV LOG_LEVEL ERROR

WORKDIR /app
COPY --from=builder /builder/target/*.jar ./app.jar

CMD [ \
    "java", \
    "-Xms512m", \
    "-Xmx1024m", \
    "-Dspring.profiles.active=deploy", \
    "-jar", \
    "/app/app.jar" \
]

EXPOSE ${PORT}
