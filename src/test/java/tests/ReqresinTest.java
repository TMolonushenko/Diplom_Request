package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static listener.CustomAllureListener.withCustomTemplates;
import static org.hamcrest.Matchers.is;

public class ReqresinTest {

    @Owner("tmolonushenko")
    @DisplayName("Вход в систему")
    @Test
    void successfulLogin() {
        /*
        request: https://reqres.in/api/login
        data:
        {
            "email": "eve.holt@reqres.in",
            "password": "cityslicka"
        }
        response:
        {
            "token": "QpwL5tke4Pnpja7X4"
        }
         */


        String authorizedData = "{\"email\": \"eve.holt@reqres.in\", " +
                "\"password\": \"cityslicka\"}";

        given()
                .filter(withCustomTemplates())
                .body(authorizedData)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Owner("tmolonushenko")
    @DisplayName("Вход в систему без пароля")
    @Test
    void missingPasswordLogin() {
        /*
        request: https://reqres.in/api/login
        data:
        {
            "email": "eve.holt@reqres.in"
        }
        response:
        {
            "error": "Missing password"
        }
         */
        // Пропущенный пароль

        String authorizedData = "{\"email\": \"eve.holt@reqres.in\"}";

        given()
                .filter(withCustomTemplates())
                .body(authorizedData)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(400)
                .body("error", is("Missing password"));
    }
}
