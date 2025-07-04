# JavaWebInfo

Создание web-интерфейса для проекта _**Info SQL**_ на языке Java.
Web-приложение разрабатывается с использованием Spring MVC-фреймворка и серверном рендеринге в ответ на запросы.

## Part 1. Приложение

### Приложение поддерживает

- Осуществление CRUD-операций (В стадии разработки)

### Логическое представление модели базы данных

![Logical view of database model](/materials/database.png)

## Part 2. Инструкция по запуску

### Запуск через IntelliJ IDEA

1. Клонировать репозиторий с github
2. Открыть проект в IntelliJ IDEA
3. Запустить PostgreSQL на Вашем ПК
4. Открыть файл `application.properties` и изменить следующие параметры: `spring.datasource.url`, `spring.datasource.username` и `spring.datasource.password`, если Вы используете другие параметры для подключения к БД.
5. Запустить приложение в IntelliJ IDEA
6. Открыть браузер и ввести в адресную строку `http://localhost:8080/`

### Запуск через Docker

1. Запустить Docker
2. Клонировать репозиторий с github
3. В терминале перейти в папку `JavaWebInfo/`, где находится файл `docker-compose.yml` и `Makefile`
4. Для создания образов и запуска контейнеров выполнить следующую команду в терминале:

    ```bash
    make docker-build-up
    ```

5. После запуска контейнеров открыть браузер и ввести в адресную строку `http://localhost:80`
6. Для остановки контейнеров выполнить следующую команду в терминале:

    ```bash
    make docker-down
    ```

7. Для повторного запуска контейнеров выполнить следующую команду в терминале:

    ```bash
    make docker-up
    ```
   
8. Для остановки контейнеров и удаления образов выполнить следующую команду в терминале:

   ```bash
    make docker-clean
    ```
