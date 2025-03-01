FROM openjdk:21-jdk-slim
WORKDIR /app

# Устанавливаем ca-certificates (иначе keytool не сможет работать)
RUN apt-get update && apt-get install -y ca-certificates && rm -rf /var/lib/apt/lists/*

# Копируем сертификат в контейнер
COPY src/main/resources/russian_trusted_root_ca.cer /tmp/

# Добавляем сертификат в Java Keystore
RUN keytool -import -trustcacerts -alias russian_trusted_ca \
    -file /tmp/russian_trusted_root_ca.cer \
    -cacerts \
    -storepass changeit -noprompt

# Копируем JAR-файл
COPY target/*.jar app.jar

# Запускаем приложение
CMD ["java", "-jar", "app.jar"]