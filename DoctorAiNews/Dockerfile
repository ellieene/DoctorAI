FROM openjdk:21-jdk-slim

# Указываем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем собранный jar файл в контейнер
COPY target/DoctorAiNews-0.0.1-SNAPSHOT.jar app.jar

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]