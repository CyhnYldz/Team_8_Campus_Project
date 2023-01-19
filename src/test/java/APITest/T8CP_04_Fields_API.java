package APITest;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class T8CP_04_Fields {

    Cookies cookies;
    String fieldID;

    @BeforeClass
    public void loginCampus()
    {
        baseURI = "https://test.mersys.io/";
        // Diğer testler çalışmadan önce login olup cookies im alınması gerekiyor
        // bu yüzden before class annotation ı ekledik

        Map<String,String> credential = new HashMap<>();
        credential.put("username","turkeyts");
        credential.put("password","TechnoStudy123");
        credential.put("rememberMe","true");

        cookies =
                given()
                        .contentType(ContentType.JSON)
                        .body(credential)

                        .when()
                        .post("auth/login")

                        .then()
                        .statusCode(200)
                        .extract().response().detailedCookies()
        ;
    }

    public String getRandomName()
    {
        return RandomStringUtils.randomAlphabetic(8);
    }
    public String getRandomCode() { return RandomStringUtils.randomAlphabetic(3); }

    @Test
    public void addField()
    {
        Field field = new Field();
        field.setName(getRandomName());
        field.setCode(getRandomCode());


        Response response=
        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(field)
                .log().body()

                .when()
                .post("school-service/api/entity-field")

                .then()
                .log().body()
                .statusCode(201)
                .extract().response()
                ;

        fieldID = response.jsonPath().getString("id");
    }

    @Test(dependsOnMethods = "addField")
    public void updateField()
    {
        Field field = new Field();
        field.setName(getRandomName());
        field.setCode(getRandomCode());
        field.setId(fieldID);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(field)
                .log().body()

                .when()
                .put("school-service/api/entity-field")

                .then()
                .log().body()
                .statusCode(200)
        ;

    }

    @Test(dependsOnMethods = "updateField")
    public void deleteField()
    {
        given()
                .cookies(cookies)
                .log().uri()

                .when()
                .delete("school-service/api/entity-field/"+fieldID)

                .then()
                .log().body()
                .statusCode(204)
        ;
    }








}
class Field
{
    private String code;
    private String name;
    private String schoolId = "6390f3207a3bcb6a7ac977f9";
    private String type = "TEXTAREA";
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}
