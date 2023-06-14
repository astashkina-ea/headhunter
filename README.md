# Проект по автоматизации тестовых сценариев для сайта компании [hh.ru](https://auto.ru/)
HeadHunter — один из крупных сайтов по поиску работы и сотрудников в мире.
___

## Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Список проверок](#spiral_notepad-список-проверок)
___

## :computer: Используемый стек:

| <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Intelij_IDEA.svg" width="40" height="40"  alt="IDEA"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Java.svg" width="40" height="40"  alt="Java"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/JUnit5.svg" width="40" height="40"  alt="JUnit 5"/></a> |                      <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Gradle.svg" width="40" height="40"  alt="Gradle"/></a>                      | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Selenide.svg" width="40" height="40"  alt="Selenide"/></a> |
|:-------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------------------:|
|                                                           IDEA                                                            |                                                       Java                                                        |                                                         Junit5                                                         |                                                                        Gradle                                                                        |                                                                         Selenide                                                                          |

| <a href="https://www.jetbrains.com/idea/"><img src="media/logo//Selenoid.svg" width="40" height="40"  alt="Selenoid"/></a> |                <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Allure_Report.svg" width="40" height="40"  alt="Allure"/></a>                 | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/AllureTestOps.svg" width="40" height="40"  alt="Allure TestOps"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Jenkins.svg" width="40" height="40"  alt="Jenkins"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/GitHub.svg" width="40" height="40"  alt="Github"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Jira.svg" width="40" height="40"  alt="Jira"/></a> |
|:---------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------:|
|                                                                         Selenoid                                                                          |                                                                           Allure                                                                            |                                                              Allure TO                                                               |                                                         Jenkins                                                         |                                                        Github                                                         |                                                                       Jira                                                                        |

- Тесты в данном проекте написаны на языке <code>Java</code> с использованием фреймворка для тестирования <code>Selenide</code> в среде разработки <code>IDEA</code>
- В качестве сборщика был использован - <code>Gradle</code>
- <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования
- При прогоне тестов браузер запускается в <code>Selenoid</code>
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием <code>Allure-отчета</code> и отправкой результатов в <code>Telegram</code> при помощи бота
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>
___

## :spiral_notepad: Список проверок:

### Web-тесты:
:white_check_mark: Авторизация по почте и паролю  <br />
:white_check_mark: Отображение региона в результатах поиска вакансий при фильтрации по региону  (параметризованный тест)<br />
:white_check_mark: Отображение специализаций для категории (параметризованный тест)<br />
:white_check_mark: Проверка на странице результов поиска установленного чекбокса в блоке "График работы"  (параметризованный тест)<br />
:white_check_mark: Проверка открытия и закрытия модалки региона
___

## :arrow_forward: Локальный запуск автотестов

### На своем компьютере с параметрами сборки по умолчанию:
```
gradle clean test
```

### На своем компьютере с параметрами сборки из local.properties и credentials.properties:
```
gradle clean test -Denvironment='local'
```
### В selenoid с параметрами сборки из remote.properties и credentials.properties:
```
gradle clean test -Denvironment='remote'
```
### На своем компьютере/в selenoid с указанием необходимых параметров:
```
gradle clean
TASK
-DbaseUrl=BASE_URL
-Dbrowser=BROWSER
-DbrowserVersion=BROWSER_VERSION
-DbrowserSize=BROWSER_SIZE
-DremoteUrl=REMOTE_URL
-DloginAccount=LOGIN_ACCOUNT
-DpasswordAccount=PASSWORD_ACCOUNT
```
где:
>- TASK - название таски test или smoke
>- BASE_URL - адрес тестового стенда (по умолчанию https://hh.ru)
>- BROWSER - браузер, в котором будут выполняться тесты (по умолчанию chrome)
>- BROWSER_VERSION - версия браузера (по умолчанию 100.0)
>- BROWSER_SIZE - размер окна браузера (по умолчанию 1920x1080)
>- REMOTE_URL - адрес для удаленного запуска тестов
>- LOGIN_ACCOUNT - логин тестового аккаунта (по умолчанию в credentials.properties)
>- PASSWORD_ACCOUNT - пароль тествого аккаунта (по умолчанию в credentials.properties)
___

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> Запуск автотестов в Jenkins

### Для запуска автотестов в Jenkins необходимо:
1. Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/Students/job/C19-astashkina_ea-unit15_hw/">проект</a>
2. Выбрать пункт **Собрать с параметрами**
3. При необходимости изменить параметры, выбрав значения
4. Нажать **Собрать**

![This is an image](/media/screens/jenkins1.png)