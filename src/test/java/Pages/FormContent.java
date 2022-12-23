package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent{

    public FormContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[data-placeholder='Name'][aria-required='true']")
    private WebElement nameInput;



    WebElement myElement;
    public void findAndClick(String strlement) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "academicPeriod": myElement = nameInput;
                break;


        }

        clickFunction(myElement);
    }
    public void findAndSend(String strlement, String value) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "nameInput": myElement = nameInput;
                break;
        }
        sendKeysFunction(myElement, value);
    }
}
