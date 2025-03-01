#!/bin/bash

# Список папок с Maven-проектами
PROJECTS=("DoctorAIChat" "DoctorAiNews" "Letter")

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

echo "🎉 Все сборки завершены!"
