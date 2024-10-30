FROM gradle:latest AS cache
RUN mkdir -p /home/gradle/cache_home
ENV GRADLE_USER_HOME /home/gradle/cache_home
COPY build.gradle.* gradle.properties /home/gradle/app/
WORKDIR /home/gradle/app
RUN gradle clean build -i --stacktrace