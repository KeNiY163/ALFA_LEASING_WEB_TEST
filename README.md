
---
### **Проект по автоматизации для каталога сайта alfaleasing.ru**

<p align="center">
<img src="media/logos/alfaLogo.png" alt="ALFA_LEASING" width="1000" height="300">
</p>
<p>ГК «Альфа-Лизинг» — крупнейшая в России негосударственная лизинговая компания, входит в топ-5 отечественных лизинговых компаний по размеру портфеля.<br><br> Каждый день в течение 25 лет компания создаем лизинговые продукты, чтобы каждый предприниматель мог получить автомобиль в любой точке РФ, быстро оформить любой транспорт для бизнеса и зарабатывать с первого дня лизингового договора</p>

---
## :notebook: Содержание:

- [Стек технологий](#computer-стек-технологий)
- [Тестовые сценарии](#clipboard-тестовые-сценарии)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Команда для запуска](#rocket-команда-для-запуска)
- [Allure отчет](#-allure-отчет)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram чат с ботом](#-уведомления-в-telegram-чат-с-ботом)
- [Видео запуска тестов в Selenoid](#-видео-запуска-тестов-в-selenoid)

---
## :computer: Стек технологий

<p align="left">
<a href="https://www.jetbrains.com/idea/"><img src="media/logos/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA" title="IntelliJ IDEA"/></a>
<a href="https://www.java.com/"><img src="media/logos/Java.svg" width="50" height="50" alt="Java" title="Java"/></a>
<a href="https://github.com/"><img src="media/logos/GitHub.svg" width="50" height="50" alt="Github" title="GitHub"/></a>
<a href="https://junit.org/junit5/"><img src="media/logos/JUnit5.svg" width="50" height="50" alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="media/logos/Gradle.svg" width="50" height="50" alt="Gradle" title="Gradle"/></a>
<a href="https://selenide.org/"><img src="media/logos/Selenide.svg" width="50" height="50" alt="Selenide" title="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="media/logos/Selenoid.svg" width="50" height="50" alt="Selenoid" title="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="media/logos/Allure_Report.svg" width="50" height="50" alt="Allure" title="Allure"/></a>
<a href="https://qameta.io/"><img src="media/logos/Allure_TO.svg" width="50" height="50" alt="Allure TestOps" title="Allure TestOps"/></a>
<a href="https://www.jenkins.io/"><img src="media/logos/Jenkins.svg" width="50" height="50" alt="Jenkins" title="Jenkins"/></a>
<a href="https://www.atlassian.com/ru/software/jira"><img src="media/logos/Jira.svg" width="50" height="50" alt="Jira" title="Jira"/></a>
<a href="https://www.telegram.org/"><img src="media/logos/Telegram.svg" width="50" height="50"/></a>
</p>

---
## :clipboard: Тестовые сценарии

1. [Главная страница](https://alfaleasing.ru/catalog/)
   - :heavy_check_mark:_Проверка HEADER и FOOTER (элементы и ссылки)_
   - :heavy_check_mark:_Проверка элементов на главной странице_
   - :heavy_check_mark:_Проверка блока фильтров(заполненые и пустые)_
   - :heavy_check_mark:_Проверка блока с логотипами марок_
   - :heavy_check_mark:_Проверка блока перелинковки по маркам авто_
   - :heavy_check_mark:_Проверка блока перелинковки по городам_
   - :heavy_check_mark:_Проверка маркетингового баннера (API проверка появления нужного баннера)_
   - :heavy_check_mark:_Проверка переходов на страницу поисковой выдачи из всех блоков, указанных выше_
2. [Страница поисковой выдачи](https://alfaleasing.ru/catalog/search/)
   - :heavy_check_mark:_Проверка HEADER и FOOTER (элементы и ссылки)_
   - :heavy_check_mark:_Проверка элементов на странице поисковой выдачи_
   - :heavy_check_mark:_Проверки блока фильтров: комбинации всех фильтров_
   - :heavy_check_mark:_Проверка добавления нескольких марок_
   - :heavy_check_mark:_Проверка блока перелиноки по марке автомобиля_
   - :heavy_check_mark:_Проверка появления баннера "Из других городов"_
   - :heavy_check_mark:_Проверка карточек офферов на наличие данных из выбранных фильтров_

---
### <img src="media/logos/Jenkins.svg" width="50" height="50"/> Сборка в [Jenkins]()
<p align="center">
<img src="psv/screenshots/JenkinsScreenshot.png" alt="Jenkins Build" width="1000" height="300">
</p>

____
### Параметры сборки проекта

| Параметр        | Назначение                           |
|-----------------|--------------------------------------|
| BROWSER         | Браузер для запуска                  |
| BROWSER_VERSION | Версия браузера                      |
| BROWSER_SIZE    | Разрешение экрана                    |
| TASK            | Выбор конкретных тестов для запуска  |
| ENVIRONMENT     | Рабочее окружение                    |
| COMMENT         | Комментарий                          |

### Запуск параметризованных автотестов в **Jenkins**

<p align="center">
<img src="psv/screenshots/JenkinsScreenshot2.png" alt="Jenkins Launch" width="1000" height="400">
</p>

## :rocket: Команда для запуска

```bash
clean
${TASK}
-Dbrowser=${BROWSER}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserVersion=${BROWSER_VERSION}
-DbaseUrl=${BASE_URL}
-DremoteUrl=${REMOTE_URL}
```

---
## <img src="media/logos/Allure_Report.svg" width="50" height="50"/> [Allure]() отчет

### Главная страница отчета

<p align="center">
<img src="psv/screenshots/Screenshot2.png" alt="Allure report" width="1000" height="350">
</p>

### Тест-кейсы

<p align="center">
<img src="psv/screenshots/Screenshot1.png" alt="Test Case" width="1000" height="350">
</p>

### Содержание тест-кейсов

- :heavy_check_mark: Подробное описание шагов
- :heavy_check_mark: Тег
- :heavy_check_mark: Критичность теста
- :heavy_check_mark: Автор
- :heavy_check_mark: Ссылка на раздел сайта (для каждый тестов свой раздел)
- :heavy_check_mark: Последний скриншот для каждого теста
- :heavy_check_mark: HTML разметка страницы
- :heavy_check_mark: Логи браузера
- :heavy_check_mark: Видео с прохождением теста

### Графики

<p align="center">
<img src="psv/screenshots/Screenshot3.png" alt="Allure-graph" width="1000" height="400">
</p>

---
## <img src="media/logos/Allure_TO.svg" width="50" height="50"/> Интеграция с [Allure TestOps]()

### Dashboards
<p align="center">
<img src="psv/screenshots/Screenshot5.png" alt="TestOps dashboard" width="1000" height="400">
</p>

### Ручные и автоматизированные тест-кейсы
<p align="center">
<img src="psv/screenshots/Screenshot4.png" alt="TestOps dashboard" width="1000" height="400">
</p>

### Запуск автоматизированных тестов в **TestOps**
<p align="center">
<img src="psv/screenshots/Screenshot6.png" alt="TestOps launch" width="1000" height="400">
</p>

---
## <img src="media/logos/Jira.svg" width="50" height="50"/> Интеграция с [Jira]()

### Задача в Jira

<p align="center">
<img src="psv/screenshots/Screenshot7.png" alt="TestOps launch" width="1000" height="400">
</p>

#### Содержание задачи

- :heavy_check_mark: Цель
- :heavy_check_mark: Задачи для выполнения
- :heavy_check_mark: Тест-кейсы из Allure TestOps
- :heavy_check_mark: Результат прогона тестов в Allure TestOps

---

## <img src="media/logos/Telegram.svg" width="50" height="50"/> Уведомления в Telegram чат с ботом

### Уведомление из переписки с чат ботом

<p align="center">
<img src="psv/screenshots/Screenshot8.png" alt="TestOps launch" width="500" height="400">
</p>


#### Содержание уведомления в Telegram

- :heavy_check_mark: Окружение
- :heavy_check_mark: Комментарий
- :heavy_check_mark: Длительность прохождения тестов
- :heavy_check_mark: Общее количество сценариев
- :heavy_check_mark: Процент прохождения тестов
- :heavy_check_mark: Ссылка на Allure отчет

---

## <img src="media/logos/Selenoid.svg" height="50"/> Видео запуска тестов в Selenoid

<p align="center">
<img src="psv/videos/video.gif" alt="TestOps launch" width="800" height="400">
</p>

---
