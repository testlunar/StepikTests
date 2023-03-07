# Проект по UI тестам для сайта [Stepik.org](https://stepik.org/catalog)

<p align="center">
<img title="Stepik" name="Stepik" src="media/logo/stepik_logo.svg">
</p>

##  Содержание:

- [Технологии и инструменты](#technologist-технологии-и-инструменты)
- [Запуск тестов](#-запуск-тестов)
- [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
- [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Пример запуска теста в Browserstack](#-пример-запуска-теста-в-Browserstack)

##  Технологии и инструменты

<p align="left">
<a href="https://selenide.org/"><img src="media/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA" title="IntelliJ IDEA"/></a>
<a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50" alt="Java" title="Java"/></a>
<a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50" alt="Gradle" title="Gradle"/></a>
<a href="https://junit.org/junit5/"><img src="media/logo/JUnit5.svg" width="50" height="50" alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50" alt="Github" title="GitHub"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="media/logo/Allure_Report.svg" width="50" height="50" alt="Allure" title="Allure"/></a>
<a href="https://qameta.io/"><img src="media/logo/Allure_TO.svg" width="50" height="50" alt="Allure_TO" title="Allure_TO"></a>
<a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50" alt="Jenkins" title="Jenkins"/></a>
<a href="https://aerokube.com/selenoid/"><img src="media/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://web.telegram.org/"><img src="media/logo/Telegram.svg" width="50" height="50" alt="Telegram" title="Telegram"></a>
</p>

## Тест кейсы

- [x] Проверка релевантности поиска курса по слову
- [x] Поиск курса по нерелевантному названию курса и проверка,что курс не найден
- [x] Проверка,что количество найденных при поиске курсов на одной странице равно 20
- [x] Поиск курса с параметрами и проверка соответствия результата
- [x] Проверка текста ошибки при неверном логине или пароле

# Запуск тестов

Для локального запуска тестов:
```shell
gradle clean test -Denv=local 
```

Для удаленного запуска тестов:
```shell
gradle clean test -Denv=remote 
```

Получение отчёта:
```bash
allure serve build/allure-results
```

## <img width="4%" title="Jenkins" src="media/logo/Jenkins.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/diploma_project_mobile/)

###Сборка проекта:
- Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/stepikTesting/">проект</a>

<p align="center">
  <img src="media/screen/stepik_parametres.png" alt="Jenkins" width="800">
</p>

- Выбрать пункт **Собрать с параметрами**

- В случае необходимости изменить параметры, выбрав значения из выпадающих списков

- Нажать **Собрать**

- Результат запуска сборки можно посмотреть в отчёте Allure
<p align="center">
  <img src="media/screen/stepik_jenkins.png" alt="Jenkins" width="800">
</p>

## <img width="4%" title="Allure Report" src="media/logo/Allure_Report.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/diploma_project_mobile/1/allure/)

<p align="center">
  <img src="media/screen/stepik_allure.png" alt="allure-report_1" width="900">
</p>

<p align="center">
  <img src="media/screen/stepik_allure2.png" alt="allure-report_2" width="900">
</p>


## <img width="4%" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram
После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прохождении тестов.

<p align="center">
<img title="Telegram Notifications" src="media/screen/stepik_telegram.png">

## <img src="media/logo/Selenoid.svg" width="25" height="25"  alt="Selenoid"/></a> Видео прохождения тестов

К каждому тесту в отчете прилагается видео.

<p align="center">
<img src="/media/video/stepik1.gif" alt="video"/></a>
</p>

[Вернуться к началу ⬆](#Wikipedia)