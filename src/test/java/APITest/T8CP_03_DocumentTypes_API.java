package APITest;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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

public class T8CP_03_DocumentTypes_API {

    Cookies cookies;
    String documentID;

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
    public void addDocument()
    {
        String documentName=getRandomName();

        JsonArray list = new JsonArray();
        list.add("STUDENT_REGISTRATION");
        list.add("EXAMINATION");

        JsonObject obj = new JsonObject();
        obj.addProperty("active",true);
        obj.add("attachmentStages",list);
        obj.addProperty("description", "tanımlama");
        obj.addProperty("id", (String) null);
        obj.addProperty("name",documentName);
        obj.addProperty("required", true);
        obj.addProperty("schoolId","6390f3207a3bcb6a7ac977f9");
        obj.addProperty("translateName", (String) null);
        obj.addProperty("useCamera",false);

        Response documentBody=
        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(obj.toString())
                .log().body()

                .when()
                .post("school-service/api/attachments/create")

                .then()
                .log().body()
                .statusCode(201)
                .extract().response()
        ;
        documentID = documentBody.jsonPath().getString("id");
    }
    @Test(dependsOnMethods = "addDocument")
    public void updateDocument()
    {
        String documentName=getRandomName();

        JsonArray list = new JsonArray();
        list.add("CERTIFICATE");
        list.add("CONTRACT");

        JsonObject obj = new JsonObject();
        obj.addProperty("active",true);
        obj.add("attachmentStages",list);
        obj.addProperty("id", documentID);
        obj.addProperty("name",documentName);
        obj.addProperty("required", true);
        obj.addProperty("schoolId","6390f3207a3bcb6a7ac977f9");
        obj.addProperty("translateName", (String) null);
        obj.addProperty("useCamera",false);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(obj.toString())
                .log().body()

                .when()
                .put("school-service/api/attachments")

                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test(dependsOnMethods = "updateDocument")
    public void deleteDocument()
    {
        given()
                .cookies(cookies)
                .log().uri()

                .when()
                .delete("school-service/api/attachments/"+documentID)

                .then()
                .log().body()
                .statusCode(200)
        ;
    }

}

