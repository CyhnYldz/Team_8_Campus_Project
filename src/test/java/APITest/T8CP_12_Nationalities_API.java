package APITest;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class T8CP_12_Nationalities_API {
    Cookies cookies;
    String nationalityID;
    String nationalityName;
    @BeforeClass
    public void loginCampus() {
        baseURI = "https://test.mersys.io/";

        Map<String, String> credential = new HashMap<>();
        credential.put("username", "turkeyts");
        credential.put("password", "TechnoStudy123");
        credential.put("rememberMe", "true");

        cookies=
                given()
                        .contentType(ContentType.JSON)
                        .body(credential)
                        .when()
                        .post("auth/login")

                        .then()
                        //.log().body()
                        .statusCode(200)
                        .extract().response().getDetailedCookies()
        ;

    }
    public String getRandomName() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    @Test
    public void createNationality(){
        nationalityName=getRandomName();
        Nationalities nationality=new Nationalities();
        nationality.setName(nationalityName);

        nationalityID=
        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(nationality)
                .log().body()

                .when()
                .post("school-service/api/nationality")

                .then()
                .log().body()
                .statusCode(201)
                .extract().jsonPath().getString("id")
        ;
    }

    @Test(dependsOnMethods = "createNationality")
    public void updateNationality(){
        nationalityName=getRandomName();
        Nationalities nationality=new Nationalities();
        nationality.setName(nationalityName);
        nationality.setId(nationalityID);

                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(nationality)
                        .log().body()

                        .when()
                        .put("school-service/api/nationality")

                        .then()
                        .log().body()
                        .statusCode(200)
        ;
    }

    @Test(dependsOnMethods = "updateNationality")
    public void deleteNationality(){
        given()
                .cookies(cookies)
                .pathParam("NationalityID",nationalityID)

                .when()
                .delete("school-service/api/nationality/{NationalityID}")

                .then()
                .log().body()
                .statusCode(200)
        ;
    }
    @Test(dependsOnMethods = "updateNationality")
    public void deleteNationalityNegative(){
        given()
                .cookies(cookies)
                .pathParam("NationalityID",nationalityID)

                .when()
                .delete("school-service/api/nationality/{NationalityID}")

                .then()
                .log().body()
                .statusCode(400)
                .body("message",equalTo("Nationality not  found"))
        ;
    }

}

class Nationalities{
    String id;
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
