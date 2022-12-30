package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DialogContent extends Parent {

    //ihityacınız olan locatorların mükerrer olmaması için sonlarına ad ve soyadlarınızın baş harflerini yazın -> loginButtonCY gibi

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "input[formcontrolname='username']")
    private WebElement username;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(css = "span[class='mat-tooltip-trigger logo-text']")
    private WebElement txtTechnoStudy;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "(//ms-delete-button//button)[1]")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[text()=' Delete ']")
    private WebElement deleteDialogBtn;

    @FindBy(xpath = "(//td[@role='cell'])[2]")
    private WebElement searchResultCell;

    @FindBy(xpath = "//mat-slide-toggle[@formcontrolname='active']")
    private WebElement toggleBar;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    //dynamic-view[@class='ng-star-inserted']
    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(css = "button[class='consent-give']")
    private WebElement acceptCookies;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//mat-form-field//input[@data-placeholder='Name']")
    private WebElement searchInput;
    @FindBy(xpath = "//mat-form-field//input[@data-placeholder='Description']")
    private WebElement searchInputDescription;

    @FindBy(xpath = "(//*[@data-icon='pen-to-square'])[1]")
    private WebElement gradeLevelEdit;

    @FindBy(xpath = "(//tbody[@role='rowgroup']//tr//td)")
    private List<WebElement> gradeLevelList;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='order']//input")
    private WebElement GrLvlOrder;


    @FindBy(xpath = "(//ms-edit-button//button)[1]")
    private WebElement editButton;


    @FindBy(xpath = "//ms-text-field[@formcontrolname='description']//input")
    private WebElement description;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement integrationCode;
    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priority;

    @FindBy(xpath = "(//span[text()='Stage'])[3]")
    private WebElement stage;
    @FindBy(xpath = "//span[text()=' Student Registration ']/preceding-sibling::mat-pseudo-checkbox")
    private WebElement studentRegistration;

    @FindBy(xpath = "//span[text()=' Examination ']/preceding-sibling::mat-pseudo-checkbox")
    private WebElement examination;

    @FindBy(xpath = "//span[text()='Text']")
    private WebElement fieldType;

    @FindBy(css = "svg[data-icon='plus']")
    private WebElement addButtonFields;

    @FindBy(xpath = "//span[text()=' Integer ']")
    private WebElement integer;

    @FindBy(css = "[data-placeholder='IBAN']")
    private WebElement IBAN;

    @FindBy(xpath = "(//span[text()='Currency'])[3]")
    private WebElement currency;

    @FindBy(xpath = "//span[text()=' TRY ']")
    private WebElement TRY;

    @FindBy(css = "[data-placeholder='Integration Code']")
    private WebElement iCodeInBankAccount;




    @FindBy(xpath = "//div[@role='listbox']//span[text()=' Classroom ']")
    private WebElement listclassroomComboBox;
    @FindBy(xpath = "//span[text()=' Laboratory ']")
    private WebElement laboratoryComboBox;
    @FindBy(xpath = "//span[text()='Classroom']")
    private WebElement classroomComboBox;


    @FindBy(xpath = "//span[text()=' Other ']") private WebElement otherComboBox;
    @FindBy(xpath = "//ms-integer-field[@formcontrolname='capacity']//input") private WebElement capacityInput;
    @FindBy(xpath = "(//div[@role='tab'])[1]") private WebElement schoolDepartment;
    @FindBy(xpath = "(//div[@role='tab'])[2]//div/span") private WebElement section;
    @FindBy(xpath = "(//div[@role='tab'])[3]//div/span") private WebElement constants;
    @FindBy(xpath = "(//span[@class='mat-button-wrapper']/span)[1]") private WebElement schoolDepartmentSectionSaveButton;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='key']//input") private WebElement keyInput;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='value']//input") private WebElement valueInput;



    WebElement myElement;

    public void findAndSend(String strlement, String value) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "username":
                myElement = username;
                break;
            case "password":
                myElement = password;
                break;
            case "nameInput":
                myElement = nameInput;
                break;
            case "codeInput":
                myElement = codeInput;
                break;

            case "searchInput":
                myElement = searchInput;
                break;
            case "shortName":
                myElement = shortName;
                break;
            case "GrLvlOrder":
                myElement = GrLvlOrder;
                break;
            case "description":
                myElement = description;
                break;
            case "integrationCode":
                myElement = integrationCode;
                break;
            case "priority":
                myElement = priority;
                break;
                case "searchInputDescription":
                myElement = searchInputDescription;
                break;
            case "capacityInput": myElement = capacityInput;break;
            case "keyInput": myElement = keyInput;break;
            case "valueInput": myElement = valueInput;break;
            case "IBAN": myElement = IBAN;break;
            case "iCodeInBankAccount": myElement = iCodeInBankAccount;break;


        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strlement) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "loginButton":
                myElement = loginButton;
                break;
            case "addButton":
                myElement = addButton;
                break;
            case "saveButton":
                myElement = saveButton;
                break;
            case "acceptCookies":
                myElement = acceptCookies;
                break;
            case "searchButton":
                myElement = searchButton;
                break;
            case "deleteButton":
                myElement = deleteButton;
                break;
            case "deleteDialogBtn":
                myElement = deleteDialogBtn;
                break;
            case "toggleBar":
                myElement = toggleBar;
                break;
            case "gradeLevelEdit":
                myElement = gradeLevelEdit;
                break;
            case "editButton":
                myElement = editButton;
                break;
            case "classroomComboBox": myElement = classroomComboBox;break;
            case "listclassroomComboBox": myElement = listclassroomComboBox;break;
            case "laboratoryComboBox": myElement = laboratoryComboBox;break;
            case "otherComboBox": myElement = otherComboBox;break;
            case "schoolDepartment": myElement = schoolDepartment;break;
            case "section": myElement = section;break;
            case "constants": myElement = constants;break;
            case "schoolDepartmentSectionSaveButton": myElement = schoolDepartmentSectionSaveButton;break;
            case "fieldType": myElement = fieldType;break;
            case "addButtonFields": myElement = addButtonFields;break;
            case "integer": myElement = integer;break;
            case "currency": myElement = currency;break;
            case "TRY": myElement = TRY;break;
            case "stage":
                myElement = stage;
                break;
            case "studentRegistration":
                myElement = studentRegistration;
                break;
            case "examination":
                myElement = examination;
                break;

        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strlement, String text) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "txtTechnoStudy":
                myElement = txtTechnoStudy;
                break;
            case "successMessage":
                myElement = successMessage;
                break;
            case "alreadyExist":
                myElement = alreadyExist;
                break;
            case "searchResultCell":
                myElement = searchResultCell;
                break;


        }

        verifyContainsTextFunction(myElement, text);
    }

    public void findAndDelete(String searchText) {

        findAndSend("searchInput", searchText);  // aranacak kelimeyi kutucuğa gönder
        findAndClick("searchButton"); // arama butonuna bas

        //wait.until(ExpectedConditions.stalenessOf(deleteButton)); stale zamanını yakalayamadım
        //wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//tbody[@role='rowgroup']//tr"),5));

        // findAndContainsText("searchResultCell", searchText); // arama sonuçlarının ilkinde aranan kelime gözükene kadar bekle.

        waitUntilLoading(); // progressbar ın çocukları 0 olana kadar bekle

        findAndClick("deleteButton"); // silme butonua bas, çöp kutusu
        findAndClick("deleteDialogBtn"); // dilogdaki silme butonuna bas

    }

    public void findAndEdit(String searchText, String searchText2) {

        findAndSend("searchInput", searchText);
        findAndClick("searchButton");

        waitUntilLoading();

        findAndClick("editButton");
        findAndSend("nameInput", searchText2);

    }


}
