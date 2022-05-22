package tests;

import io.qameta.allure.Owner;
import models.UserData;
import models.lombok.LombokUserData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static listener.CustomAllureListener.withCustomTemplates;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.Specs.*;


public class UserTest {

    @Owner("tmolonushenko")
    @DisplayName("Вызов пользователя (Spec)")
    @Test
    void singUser() {
        given()
                .filter(withCustomTemplates())
                .spec(request)
                .when()
                .get("users/2")
                .then()
                .spec(responseSpec)
                .log().body();

    }

    @Owner("tmolonushenko")
    @DisplayName("Вызов списка пользователей (Spec)")
    @Test
    void listTest() {
        given()
                .filter(withCustomTemplates())
                .spec(request)
                .when()
                .get("users/?page=2")
                .then()
                .log().body();

    }

    @Owner("tmolonushenko")
    @DisplayName("Вызов пользователя (Spec/Model)")
    @Test
    void singleUserWithModel() {

        UserData data =
                given()
                        .filter(withCustomTemplates())
                        .spec(request)
                        .when()
                        .get("/users/2")
                        .then()
                        .spec(responseSpec)
                        .log().body()
                        .extract().as(UserData.class);
        assertEquals(2, data.getData().getId());
        //  assertThat(data.getData().getId()).isEqualTo(2);
    }

    @Owner("tmolonushenko")
    @DisplayName("Вызов пользователя (Spec/Lombok)")
    @Test
    void SingleUserWithLombokModel() {
        LombokUserData data =
                given()
                        .filter(withCustomTemplates())
                        .spec(request)
                        .when()
                        .get("/users/2")
                        .then()
                        .spec(responseSpec)
                        .log().body()
                        .extract().as(LombokUserData.class);

        assertEquals(2, data.getUser().getId());
    }

    @Owner("tmolonushenko")
    @DisplayName("Проверка email в списке пользователей (Groovy)")
    @Test
    public void CheckEmailUsingGroovy() {
        given()
                .filter(withCustomTemplates())
                .spec(request)
                .when()
                .get("/users")
                .then()
                .log().body()
                .body("data.findAll{it.email=~/.*?@reqres.in/}.email.flatten()",
                        hasItem("eve.holt@reqres.in"));

    }
}
