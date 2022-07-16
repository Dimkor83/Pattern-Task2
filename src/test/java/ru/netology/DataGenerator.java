package ru.netology;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Locale;

import static io.restassured.RestAssured.given;

public class DataGenerator {
    static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static void setUpAll(RegistrationInfo regUser) {
        given() //"дано"
                .spec(requestSpec) //указываем, какую спецификацию используем
                .body(regUser) //передаем в теле объект, который будет преобразован в JSON
                .when() //когда
                .post("/api/system/users") //путь, на который отправляем запрос относительно BaseUri
                .then() //ожидаем
                .statusCode(200); //код 200 - все ок
    }

    public static RegistrationInfo getUser(String status) {
        Faker faker = new Faker(new Locale("en"));
        RegistrationInfo user = new RegistrationInfo(faker.name().name(),
                faker.internet().password(),
                status);
        return user;
    }
}
