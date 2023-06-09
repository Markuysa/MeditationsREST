FROM maven:3.6.2-jdk-11

# Соберем и запустим приложение в этой директории
WORKDIR /app

# Для сборки проекта Maven нужны исходные тексты программы
# и непосредственно файл сборки pom.xml
COPY pom.xml ./
COPY src/ ./src/

# Компиляция, сбока и упаковка приложения в архив JAR
RUN mvn package

# Запуск приложения виртуальной машиной Java из базового образа
CMD ["java", "-jar", "/app/target/meditations-rest-1.0.0.jar"]