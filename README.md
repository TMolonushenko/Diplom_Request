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
- [x] Выполнение поиска. Проверка, что открылась соответствующая страница
- [x] Наличие требуемых заголовков в верхнем меню страницы
- [x] Лог консоли браузера на странице входа в Систему не содержит ошибок
- [x] выполнение регистрации. Проверка успешного прохождения регистрации.
- [x] Добавление в корзину первого товара на странице и проверка счетчика в корзине.

---
# Запуск тестов
---
Для локального запуска команда
```
gradle clean test -Dthreads=4

```
Где `threads` - количество потоков параллельного запуска тестов.

### <img width="4%" title="Jenkins" src="images/icons/Jenkins.png"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/011_tmolonushenko_sotoFoto/)

---

```
clean
test
-Dbrowser=${BROWSER}  
-DbrowserVersion=${BROWSER_VERSION} 
-DbrowserSize=${BROWSER_SIZE}  
-DremoteDriverUrl=https://user1:1234@${REMOTE_DRIVER_URL}/wd/hub/ 
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/ 
-Dthreads=${THREADS} 

```

- [x] Dbrowser - браузер, в котором будут выполняться тесты (по умолчанию chrome)
- [x] DbrowserVersion - версия браузера (по умолчанию 100.0)
- [x] DbrowserSize - размер окна браузера (по умолчанию 1920x1080)
- [x] DremoteDriverUrl - логин, пароль и адрес удаленного сервера, где будут выполняться тесты (по умолчанию https://[selenoidUser]:[selenoidPwd]@selenoid.autotests.cloud/wd/hub/)
- [x] DvideoStorage - хранилище видео выполненных тестов (по умолчанию https://selenoid.autotests.cloud/video/)
- [x] Dthreads - количество потоков выполняющихся тестов (по умолчанию 5)

Для запуска сборки необходимо указать значения параметров и нажать кнопку `Собрать`
![Jenkins](images/jenkins_sborkaP.jpg)

## <img width="4%" title="Allure Report" src="images/icons/Allure_Report.png"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/011_tmolonushenko_sotoFoto/allure/)

----

![Allure Report](images/Allure_ReportOver.png)
###Список тестов c описанием шагов и визуализацией результатов
![Allure Report](images/Allure_ReportTest.png)


### <img width="4%" title="Allure Report" src="images/icons/Selenoid.png" Видео-отчет о прохождении теста из Selenoid:
![videoTest](https://user-images.githubusercontent.com/99205386/169517259-81fc365a-66ed-4c00-9d8d-f882f221c379.gif)

### <img width="4%" title="Allure Report" src="images/icons/AllureTestOps.png"> Проект интегрирован с Allure TestOps

---

## Тест-кейсы с историей запусков
![Allure TestOps](images/AllureTestOps2.png)

## Дашборд
![Allure TestOps](images/AllureTestOps3.png)

---
## <img width="4%" title="Allure Report" src="images/icons/Telegram.png"> Уведомление в Telegram
![Telegram Bot](images/telegram1.png)


---





