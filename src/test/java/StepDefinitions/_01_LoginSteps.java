package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class _01_LoginSteps {
    DialogContent dc=new DialogContent();

    @Given("Navigate to Campus")
    public void navigateToCampus() {

        GWD.getDriver().get("https://test.mersys.io/");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Enter username and password and click Login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {


        dc.findAndSend("username", "turkeyts");
        dc.findAndSend("password", "TechnoStudy123");
        dc.findAndClick("loginButton");
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        dc.findAndContainsText("txtTechnoStudy","Techno Study");
        dc.findAndClick("acceptCookies");
    }



}
