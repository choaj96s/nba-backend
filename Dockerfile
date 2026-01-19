# ---- Build stage ----
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Gradle Wrapper + 설정 파일 먼저 복사 (캐시 최적화)
COPY gradlew .
COPY gradle ./gradle
COPY build.gradle settings.gradle gradle.properties ./

# 실행 권한 부여 (Linux 환경에서 중요)
RUN chmod +x gradlew

# 의존성 캐시 (선택 사항이지만 속도 향상에 매우 도움)
RUN ./gradlew dependencies --no-daemon || true

# 소스 코드 복사 후 빌드
COPY src ./src
RUN ./gradlew bootJar --no-daemon


# ---- Run stage ----
FROM eclipse-temurin:21-jre

WORKDIR /app

# build stage에서 만든 jar만 복사
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
