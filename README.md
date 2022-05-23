# Автоматизированные тесты для
https://reqres.in/
-----

### Технологии используемые в проекте
![Intelij_IDEA](images/icons/Intelij_IDEA.png)![Java](images/icons/Java.png)![Selenide](images/icons/Selenide.png)![Selenoid](images/icons/Selenoid.png)![Gradle](images/icons/Gradle.png)![JUnit5](images/icons/JUnit5.png)![Allure Report](images/icons/Allure_Report.png)![AllureTestOps](images/icons/AllureTestOps.png)![Jenkins](images/icons/Jenkins.png)![Telegram](images/icons/Telegram.png)
![Rest Assured](images/icons/rest-assured.png)![Lombok](images/icons/lombok.png)
* [Java](https://www.oracle.com/java/) - для написания тестов
* [Gradle](https://gradle.org) - для сборки проекта
* [JUnit 5](https://junit.org/junit5/) - для запуска тестов
* [Selenide](https://selenide.org) - для тестирования UI
* [Rest-Assured](https://rest-assured.io) - для тестирования API
* [Jenkins](https://www.jenkins.io/) - для обеспечения процесса непрерывной интеграции
* [Selenoid](https://aerokube.com/selenoid/) - для запуска UI тестов в [Docker containers](https://www.docker.com/resources/what-container)
* [Allure TestOps](https://docs.qameta.io/allure-testops/) и [Allure Report](http://allure.qatools.ru) - для управления тестами, анализа их прохождения и оформления отчетности
* [Telegram Bot](https://core.telegram.org/bots) - для оповещения о прохождении тестов
---

#### Список проверок, реализованных в автотестах
- [x] Вызов пользователя
- [x] Возвращение ошибки при отсутствии пароля
- [x] Вызов списка пользователей
- [x] Создание пользователя
- [x] Изменение данных пользователя
- [x] Удаление пользователя
- [x] Успешная регистрация пользователя
- [x] Проверка email в списке пользователей (Groovy)


## <img width="4%" title="Jenkins" src="images/icons/Jenkins.png"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/011_tmolonushenko_reqresin/)

---
![Jenkins](images/Allure_Report_reqresin1.png)


## <img width="4%" title="Allure Report" src="images/icons/Allure_Report.png"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/011_tmolonushenko_sotoFoto/allure/)

----

![Allure Report](images/Allure_Report2.png)
### Список тестов c описанием тестов
![Allure Report](images/Allure_Report3.png)

### Графики
![Allure Report](images/Allure_Report4.png)


### <img width="4%" title="Allure Report" src="images/icons/AllureTestOps.png"> Проект интегрирован с Allure TestOps

---

## Тест-кейсы с историей запусков
![Allure TestOps](images/AllureTestOps2.png)

## Дашборд
![Allure TestOps](images/AllureTestOps3.png)

---
## <img width="4%" title="Allure Report" src="images/icons/Telegram.png"> Уведомление в Telegram
![Telegram Bot](images/telegram2.png)


---





