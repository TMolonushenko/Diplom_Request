package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static listener.CustomAllureListener.withCustomTemplates;
import static org.hamcrest.Matchers.*;

public class RestAPIHWTest {

    @Owner("tmolonushenko")
    @DisplayName("Вызов пользователя")
    @Test
    void singleUserTest() {

        given()
                .filter(withCustomTemplates())
                .when()
                .contentType(JSON)
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.email", equalTo("janet.weaver@reqres.in"));
    }

    @Owner("tmolonushenko")
    @DisplayName("Негативный тест на вызов пользователя")
    @Test
    void singleUserNotFoundTest() {
        given()
                .filter(withCustomTemplates())
                .get("https://reqres.in/api/users/23")
                .then()
                .statusCode(404);
    }

    @Owner("tmolonushenko")
    @DisplayName("Вызов списка пользователей")
    @Test
    void listTest() {
        given()
                .filter(withCustomTemplates())
                .param("id", 2)
                .get("https://reqres.in/api/unknown")
                .then()
                .statusCode(200)
                .body("data.name", is("fuchsia rose"));
    }

    @Owner("tmolonushenko")
    @DisplayName("Создание пользователя")
    @Test
    void createTest() {
        String authDataCreate = "{\"name\": \"lama\",\n" +
                "    \"job\": \"QA\"\n" +
                "}";

        given()
                .filter(withCustomTemplates())
                .body(authDataCreate)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name", is("lama"));

    }


    @Owner("tmolonushenko")
    @DisplayName("Изменение данных пользователя")
    @Test
    void upDateTest() {
        String upData = "{\"name\": \"lama\",\n" +
                "    \"job\": \"QA\"\n" +
                "}";
        given()
                .filter(withCustomTemplates())
                .body(upData)
                .param("name", "lama")
                .param("job", "QA")
                .param("updatedAt", "2022-04-08T09:32:51.115Z")
                .contentType(JSON)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("job", is("QA"));
    }

    @Owner("tmolonushenko")
    @DisplayName("Удаление пользователя")
    @Test
    void deleteTest() {
        given()
                .filter(withCustomTemplates())
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204);

    }


    @Owner("tmolonushenko")
    @DisplayName("Успешная регистрация пользователя")
    @Test
    void registerSuccessfulTest() {
        String inputData = "{\"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        given()
                .filter(withCustomTemplates())
                .body(inputData)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(200)
                .body("token", is(notNullValue()));
    }


}
