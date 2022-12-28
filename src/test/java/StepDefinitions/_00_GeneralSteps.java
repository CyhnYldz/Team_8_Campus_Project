package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import Pages.LeftNav;
import Pages.Parent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class _00_GeneralSteps {

    LeftNav ln = new LeftNav();

    DialogContent dc = new DialogContent();

    FormContent fc = new FormContent();

    @And("Click on the element in left nav")
    public void clickOnTheElementInLeftNav(DataTable elemanlar) {
        List<String> listElemanlar= elemanlar.asList(String.class);

        for(String strButtonName : listElemanlar) {
            //System.out.println("eleman = " + eleman);
            ln.findAndClick(strButtonName);
        }
    }

    @And("Click on the element in the Dialog Content")
    public void clickOnTheElementInTheDialogContent(DataTable elemanlar) {
        List<String> listElemanlar= elemanlar.asList(String.class);

        for(String strButtonName : listElemanlar)
            dc.findAndClick(strButtonName);
    }

    @And("User sending the keys in Form Content")
    public void userSendingTheKeysInFormContent(DataTable elemanlar) {
        List<List<String>> listElemanlar= elemanlar.asLists(String.class);

        for(int i=0;i< listElemanlar.size() ; i++ )
            fc.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1) );
       }

    @And("User sending the keys in Dialog Content")
    public void userSendingTheKeysInDialogContent(DataTable elemanlar) {
        List<List<String>> listElemanlar= elemanlar.asLists(String.class);

        for(int i=0;i< listElemanlar.size() ; i++ )
            dc.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1) );
    }

    @And("Click on the element in the Form Content")
    public void clickOnTheElementInTheFormContent(DataTable elemanlar) {
        List<String> listElemanlar= elemanlar.asList(String.class);

        for(String strButtonName : listElemanlar)
            fc.findAndClick(strButtonName);
    }
    @And("User delete item from Dialog")
    public void userDeleteItemFromDialog(DataTable elemanlar) {
        List<String> listElemanlar= elemanlar.asList(String.class);

        for(String strButtonName : listElemanlar)
            dc.findAndDelete(strButtonName);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage","success");
    }

    @When("User Edit The {string} {string}")
    public void userEditThe(String searchText, String searchText2) {

        dc.findAndEdit(searchText, searchText2);

    }

    @When("User Delete The {string}")
    public void userDeleteThe(String searchText) {

        dc.findAndDelete(searchText);
    }


    @And("Find and Edit on the {string} element in the GradeLevel Content")
    public void findAndEditOnTheElementInTheGradeLevelContent(String name) {

        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
        List<WebElement> liste=GWD.getDriver().findElements(By.xpath("(//tbody[@role='rowgroup']//tr//td)"));
        String editPath="(//*[@data-icon='pen-to-square'])";
        for(int i=0;i< liste.size() ; i++ ) {
            if (liste.get(i).getText().equalsIgnoreCase(name)){
                editPath=editPath.concat("["+((i/7)+1)+"]");

                WebElement edit= GWD.getDriver().findElement(By.xpath(editPath));
                edit.click();

            }
        }
    }

    @And("Find and Delete on the {string} element in the GradeLevel Content")
    public void findAndDeleteOnTheElementInTheGradeLevelContent(String name) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
        List<WebElement> liste=GWD.getDriver().findElements(By.xpath("(//tbody[@role='rowgroup']//tr//td)"));
        String editPath="(//*[@data-icon='trash-can'])";
        for(int i=0;i< liste.size() ; i++ ) {
            if (liste.get(i).getText().equalsIgnoreCase(name)){
                editPath=editPath.concat("["+((i/7)+1)+"]");

                WebElement edit= GWD.getDriver().findElement(By.xpath(editPath));
                edit.click();
            }
        }
    }

    @Then("Wait until results are ready")
    public void waitUntilResultsAreReady() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));

    }

    @And("User press ESC button on keyboard")
    public void userPressESCButtonOnKeyboard() {
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).perform();
    }
}
