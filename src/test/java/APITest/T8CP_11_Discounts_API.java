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
import static org.hamcrest.Matchers.*;

public class T8CP_11_Discounts_API {
    Cookies cookies;
    String discDescription;
    String discCode;
    String discPriority;
    String discID;
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
    public String getRandomDescription() {
        return RandomStringUtils.randomAlphabetic(8);
    }
    public String getRandomCode() {
        return RandomStringUtils.randomAlphabetic(3);
    }
    public String getRandomPriority() {
        return RandomStringUtils.randomNumeric(3);
    }

    @Test
    public void createDiscount(){
        discDescription=getRandomDescription();
        discCode=getRandomCode();
        discPriority=getRandomPriority();
        Discount discount=new Discount();
        discount.setDescription(discDescription);
        discount.setCode(discCode);
        discount.setPriority(discPriority);

        discID=
        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(discount)
                .log().body()
                .when()
                .post("school-service/api/discounts")

                .then()
                .log().body()
                .statusCode(201)
                .extract().jsonPath().getString("id")
        ;
    }

    @Test(dependsOnMethods = "createDiscount")
    public void updateDiscount(){

        discCode=getRandomCode();

        Discount discount=new Discount();
        discount.setDescription(discDescription);
        discount.setCode(discCode);
        discount.setPriority(discPriority);
        discount.setId(discID);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(discount)
                .log().body()

                .when()
                .put("school-service/api/discounts")

                .then()
                .log().body()
                .statusCode(200)
                .body("code",equalTo(discCode))

        ;
    }
    @Test(dependsOnMethods = "updateDiscount")
    public void deleteDiscount(){

        given()
                .cookies(cookies)
                .pathParam("DiscountID",discID)
                .log().uri()
                .when()
                .delete("school-service/api/discounts/{DiscountID}")

                .then()
                .log().body()
                .statusCode(200)

        ;

    }
    @Test(dependsOnMethods = "updateDiscount")
    public void deleteDiscountNegative(){

        given()
                .cookies(cookies)
                .pathParam("DiscountID",discID)
                .log().uri()
                .when()
                .delete("school-service/api/discounts/{DiscountID}")

                .then()
                .log().body()
                .statusCode(400)
                .body("message",equalTo("Discount not found"))

        ;

    }
}






class Discount{

    private String id;
    private String description;
    private String code;
    private String priority;

    public String getDescription() {
        return description;
    }

    public void setDescription(String desctiption) {
        this.description = desctiption;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}