#!/bin/bash

# Запускаем Docker контейнеры
echo "🚀 Запускаем Docker контейнеры..."
docker-compose up --build db-chat -d
docker-compose up --build db-news -d
docker-compose up --build zookeeper -d
docker-compose up --build kafka -d

# Ждем, пока контейнеры запустятся
echo "⏳ Ожидание готовности контейнеров..."
sleep 10  # Даем время на запуск контейнеров

# Проверяем, что контейнеры готовы
for i in {1..10}; do
    if docker exec postgres-news pg_isready; then
        echo "✅ Контейнер postgres-news готов!"
        break
    fi
    echo "❌ Ожидание готовности контейнера postgres-news..."
    sleep 5
done

for i in {1..10}; do
    if docker exec postgres-chat pg_isready; then
        echo "✅ Контейнер postgres-chat готов!"
        break
    fi
    echo "❌ Ожидание готовности контейнера postgres-chat..."
    sleep 5
done

# Проверяем, что Kafka готов
for i in {1..10}; do
    if docker exec doctorai-kafka-1 /opt/kafka/bin/kafka-topics.sh --list --bootstrap-server localhost:9092; then
        echo "✅ Контейнер Kafka готов!"
        break
    fi
    echo "❌ Ожидание готовности контейнера Kafka..."
    sleep 5
done

# Список папок с Maven-проектами
PROJECTS=("DoctorAIChat" "DoctorAiNews" "Letter" "GigaChat")

# Проходим по каждой папке и выполняем mvn clean install
for PROJECT in "${PROJECTS[@]}"; do
    if [ -d "$PROJECT" ]; then
        echo "➡ Заходим в $PROJECT"
        cd "$PROJECT" || exit 1
    
        echo "🚀 Выполняем mvn clean package..."
        mvn clean package
    
        echo "✅ Готово: $PROJECT"
        cd ..
    else
        echo "❌ Папка $PROJECT не найдена"
    fi
    echo "---------------------------"
done

# Сборка остальных контейнеров
echo "🚀 Сборка остальных контейнеров..."
docker-compose up --build chat -d
docker-compose up --build news -d
docker-compose up --build gigachat -d
docker-compose up --build letter -d

echo "🎉 Все сборки завершены!"
