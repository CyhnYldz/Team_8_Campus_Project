package APITest;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class T8CP_10_GradeLevels_API {
    Cookies cookies;
    String gradeID;
    String gradeName;
    String gradeShortName;
    String gradeOrder;
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
    public String getRandomShortName() {
        return RandomStringUtils.randomAlphabetic(3);
    }
    public String getRandomOrder(){ return RandomStringUtils.randomNumeric(3);}

    @Test
    public void createGradeLevel(){

        gradeName=getRandomName();
        gradeShortName=getRandomShortName();
        gradeOrder=getRandomOrder();

        GradeLevels gradeLevel=new GradeLevels();
        gradeLevel.setName(gradeName);
        gradeLevel.setShortName(gradeShortName);
        gradeLevel.setOrder(gradeOrder);

        gradeID=
        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(gradeLevel)
                .log().body()

                .when()
                .post("school-service/api/grade-levels")

                .then()
                .log().body()
                .statusCode(201)
                .extract().jsonPath().getString("id")
        ;
    }
    @Test(dependsOnMethods = "createGradeLevel")
    public void updateGradeLevel(){

        gradeShortName=getRandomShortName();
        GradeLevels gradeLevel=new GradeLevels();
        gradeLevel.setId(gradeID);
        gradeLevel.setName(gradeName);
        gradeLevel.setShortName(gradeShortName);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(gradeLevel)
                .log().body()

                .when()
                .put("school-service/api/grade-levels")

                .then()
                .log().body()
                .statusCode(200)
                .body( "shortName",equalTo(gradeShortName))
        ;
    }
    @Test(dependsOnMethods = "updateGradeLevel")
    public void deleteGradeLevel(){

        given()
                .cookies(cookies)
                .pathParam("GradeID",gradeID)
                .log().uri()
                .when()
                .delete("school-service/api/grade-levels/{GradeID}")


                .then()
                .log().body()
                .statusCode(200)

        ;
    }
    @Test(dependsOnMethods = "deleteGradeLevel")
    public void deleteGradeLevelNegative(){

        given()
                .cookies(cookies)
                .pathParam("GradeID",gradeID)
                .log().uri()
                .when()
                .delete("school-service/api/grade-levels/{GradeID}")


                .then()
                .log().body()
                .statusCode(400)
                .body("message",equalTo("Grade Level not found."))
        ;
    }






}
class GradeLevels{

    private String id;
    private String name;
    private String shortName;
    private String  order;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
