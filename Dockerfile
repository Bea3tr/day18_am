FROM openjdk:23-jdk-oracle AS builder

ARG COMPILE_DIR=/compiledir

WORKDIR ${COMPILE_DIR}

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

RUN ./mvnw package -Dmaven.test.skip=true

ENV SERVER_PORT=4000
EXPOSE ${SERVER_PORT}

# Not needed as app will run in 2nd stage
# ENTRYPOINT java -jar target/day18_am-0.0.1-SNAPSHOT.jar

## Second stage
FROM openjdk:23-jdk-oracle

ARG WORKDIR=/app
WORKDIR ${WORKDIR}

COPY --from=builder /compiledir/target/day18_am-0.0.1-SNAPSHOT.jar day18_am.jar

ENV SERVER_PORT=4000
EXPOSE ${SERVER_PORT}

ENTRYPOINT java -jar day18_am.jar
