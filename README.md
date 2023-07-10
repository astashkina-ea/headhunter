# Проект по автоматизации тестовых сценариев для сайта компании [hh.ru](https://hh.ru/)
HeadHunter — один из крупных сайтов по поиску работы и сотрудников в мире.

___

## Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Список проверок](#spiral_notepad-список-проверок)
- [Локальный запуск автотестов](#arrow_forward-локальный-запуск-автотестов)
- [Запуск автотестов в Jenkins](#-запуск-автотестов-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео с запуском тестов](#-видео-с-запуском-тестов)

___

## :computer: Используемый стек

| <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Intelij_IDEA.svg" width="40" height="40"  alt="IDEA"/></a> | <a href="https://www.java.com/"><img src="media/logo/Java.svg" width="40" height="40"  alt="Java"/></a> | <a href="https://junit.org/"><img src="media/logo/JUnit5.svg" width="40" height="40"  alt="JUnit 5"/></a> |                      <a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="40" height="40"  alt="Gradle"/></a>                      | <a href="https://selenide.org/"><img src="media/logo/Selenide.svg" width="40" height="40"  alt="Selenide"/></a> | <a href="https://rest-assured.io/"><img src="media/logo/RestAssured.svg" width="40" height="40"  alt="Selenide"/></a> |
|:-------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------:|
|                                                           IDEA                                                            |                                                       Java                                                        |                                                         Junit5                                                         |                                                                        Gradle                                                                        |                                                                         Selenide                                                                          |                                                     Rest-assured                                                      |

| <a href="https://www.jetbrains.com/idea/"><img src="media/logo//Selenoid.svg" width="40" height="40"  alt="Selenoid"/></a> |                <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Allure_Report.svg" width="40" height="40"  alt="Allure"/></a>                 | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/AllureTestOps.svg" width="40" height="40"  alt="Allure TestOps"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Jenkins.svg" width="40" height="40"  alt="Jenkins"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/GitHub.svg" width="40" height="40"  alt="Github"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Jira.svg" width="40" height="40"  alt="Jira"/></a> |
|:---------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------:|
|                                                                         Selenoid                                                                          |                                                                           Allure                                                                            |                                                              Allure TO                                                               |                                                         Jenkins                                                         |                                                        Github                                                         |                                                                       Jira                                                                        |

- Тесты в данном проекте написаны на языке <code>Java</code> и разработаны в среде разработки <code>IDEA</code>
- Для UI тестов при написании использовалcя фреймворка для тестирования <code>Selenide</code> 
- При прогоне тестов браузер запускается в <code>Selenoid</code>
- Для API тестов при написании использовалась библиотеке для тестирования <code>Rest-assured</code>
- В качестве сборщика был использован <code>Gradle</code>
- <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием <code>Allure-отчета</code> и отправкой результатов в <code>Telegram</code> при помощи бота
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>

___

## :spiral_notepad: Список проверок

### Web-тесты
:white_check_mark: Авторизация по почте и паролю  <br />
:white_check_mark: Переход на страницу регистрации  <br />
:white_check_mark: Отображение региона в результатах поиска вакансий при фильтрации по региону (параметризованный тест)<br />
:white_check_mark: Отображение специализаций для категории (параметризованный тест)<br />
:white_check_mark: Проверка на странице результов поиска установленного чекбокса в блоке "График работы" (параметризованный тест)<br />
:white_check_mark: Отображение на странице фильтрации чекбоксов для блока "Тип занятости" (c зависимостью от API запроса)<br />
:white_check_mark: Проверка на странице результов поиска установленного чекбокса в блоке "Тип занятости" (параметризованный тест)<br />


### Api-тесты
:white_check_mark: Отсутствие доступа на отклик на определенную вакансию неавторизованным пользователем <br />
:white_check_mark: Отсутствие доступа на удаление вакансии из списка отобранных неавторизованным пользователем <br />
:white_check_mark: Поиск вакансий по рандомной занятости <br />
:white_check_mark: Поиск вакансий по региону (параметризованный тест)<br />
:white_check_mark: Проверка возвращаемых параметров в методе GET /employers<br />

___

## :arrow_forward: Локальный запуск автотестов

### Web-тесты на локальном бразуере с параметрами сборки по умолчанию

```
gradle clean web
```

### Web-тесты на локальном браузере с параметрами сборки из local.properties

```
gradle clean web -Denvironment='local'
```

### Web-тесты на локальном/удаленном браузере с указанием необходимых параметров сборки

```
gradle clean
web
-DbaseUrl=BASE_URL
-Dbrowser=BROWSER
-DbrowserVersion=BROWSER_VERSION
-DbrowserSize=BROWSER_SIZE
-DremoteUrl=REMOTE_URL
-DloginAccount=LOGIN_ACCOUNT
-DpasswordAccount=PASSWORD_ACCOUNT
```

где:
>- <code>BASE_URL</code> - адрес тестового стенда (по умолчанию https://hh.ru)
>- <code>BROWSER</code> - браузер, в котором будут выполняться тесты (по умолчанию chrome)
>- <code>BROWSER_VERSION</code> - версия браузера (по умолчанию 100.0)
>- <code>BROWSER_SIZE</code> - размер окна браузера (по умолчанию 1920x1080)
>- <code>REMOTE_URL</code> - адрес для удаленного запуска тестов
>- <code>LOGIN_ACCOUNT</code> - логин тестового аккаунта (по умолчанию в credentials.properties)
>- <code>PASSWORD_ACCOUNT</code> - пароль тествого аккаунта (по умолчанию в credentials.properties)

### Api-тесты с параметрами сборки по умолчанию

```
gradle clean api 
```

### Api-тесты с указанием необходимых параметров сборки

```
gradle clean
TASK
-DbaseApiUrl=BASE_API_URL
```

где:
>- <code>BASE_API_URL</code> - адрес тестового стенда (по умолчанию https://api.hh.ru)

### Запуск всех тестов

```
gradle clean test
```

___

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> Запуск автотестов в Jenkins

### Для запуска автотестов в <code>Jenkins</code> необходимо
1. Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/C19-astashkina_ea-project/">проект</a>
2. Выбрать пункт **Собрать с параметрами**
3. При необходимости изменить параметры, выбрав значения
4. Нажать **Собрать**

![This is an image](/media/screens/jenkins_0.png)

После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся
значок <img width="2%" title="Allure Report" src="media/logo/Allure_Report.svg"><code>Allure
Report</code>, кликнув по которому, откроется страница с сформированным html-отчетом, 
и значок <img width="2%" title="Allure TestOps" src="media/logo/AllureTestOps.svg"><code>Allure TestOps</code>, кликнув по которому, откроется система управления тестами.

![This is an image](/media/screens/jenkins_1.png)

---

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> Пример Allure-отчета

### Пример отчёта выполнения одного из автотестов

Содержит в себе:
- Шаги теста
- Скриншот страницы на последнем шаге
- Page Source
- Логи браузерной консоли
- Видео прогона автотестов

#### Web-тесты

![This is an image](/media/screens/Allure_Report_2_1.png)

#### Api-тесты

![This is an image](/media/screens/Allure_Report_2_2.png)

----

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/AllureTestOps.svg"> Интеграция с Allure TestOps

### Dashboard с общими результатами тестирования

![This is an image](/media/screens/Allure_TestOps_1.png)

### Пример отчёта выполнения одного из автотестов
Содержит в себе:
- Шаги теста
- Скриншот страницы на последнем шаге
- Page Source
- Логи браузерной консоли
- Видео прогона автотестов

#### Web-тесты

![This is an image](/media/screens/Allure_TestOps_2_1.png)

#### Api-тесты

![This is an image](/media/screens/Allure_TestOps_2_2.png)

___

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logo/Jira.svg"> Интеграция с Jira

### Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>. В задаче отображаются прикреплённые к ней тест-кейсы и также прикреплены результаты запусков/прохождения тестов

![This is an image](/media/screens/Jira_1.png)

___

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram

### После завершения сборки, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом

#### Web-тесты

![This is an image](/media/screens/Telegram_1.png)

#### Api-тесты

![This is an image](/media/screens/Telegram_2.png)

___

## <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Видео с запуском тестов

### Для всех тестов записано видео с прохождением тестов

![This is an gif](/media/screens/selenoid_1.gif)

---