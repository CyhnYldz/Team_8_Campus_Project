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

public class T8CP_09_Bank_Account_API {

    Cookies cookies;
    String bankAccountID;

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
    public void addBankAccount()
    {
        Map<String,String> bankAccount = new HashMap<>();
        bankAccount.put("currency","TRY");
        bankAccount.put("integrationCode",getRandomCode());
        bankAccount.put("name",getRandomName());
        bankAccount.put("schoolId","6390f3207a3bcb6a7ac977f9");
        bankAccount.put("iban","TR"+getRandomCode());

        bankAccountID=
        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(bankAccount)
                .log().body()

                .when()
                .post("school-service/api/bank-accounts")

                .then()
                .log().body()
                .statusCode(201)
                .extract().path("id")
                ;
    }

    @Test(dependsOnMethods = "addBankAccount" )
    public void updateBankAccount()
    {
        Map<String,String> bankAccount = new HashMap<>();
        bankAccount.put("currency","USD");
        bankAccount.put("integrationCode",getRandomCode());
        bankAccount.put("name",getRandomName());
        bankAccount.put("schoolId","6390f3207a3bcb6a7ac977f9");
        bankAccount.put("iban","TR"+getRandomCode());
        bankAccount.put("id",bankAccountID);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(bankAccount)
                .log().body()

                .when()
                .put("school-service/api/bank-accounts")

                .then()
                .log().body()
                .statusCode(200)
                ;


    }
    @Test(dependsOnMethods = "updateBankAccount")
    public void deleteBankAccount()
    {
        given()
                .cookies(cookies)
                .log().uri()

                .when()
                .delete("school-service/api/bank-accounts/"+bankAccountID)

                .then()
                .log().body()
                .statusCode(200)
                ;
    }


}
