package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent{

    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath="(//span[text()='Setup'])[1]")
    private WebElement setupOne;

    @FindBy(xpath="(//span[text()='Parameters'])")
    private WebElement parameters;

    @FindBy(xpath="//span[text()='Document Types']")
    private WebElement documentType;

    @FindBy(xpath = "(//span[text()='Grade Levels'])[1]")private WebElement gradeLevels;

    @FindBy(xpath = "(//span[text()='Human Resources'])[1]")
    private WebElement humanResources;

    @FindBy(xpath = "(//span[text()='Setup'])[3]")
    private WebElement setupHumanResources;

    @FindBy(xpath = "(//span[text()='Position Categories'])[1]")
    private WebElement positionCategories;

    @FindBy(xpath = "(//span[text()='Attestations'])[1]")
    private WebElement attestations;

    @FindBy(xpath = "(//span[text()='Positions'])[1]")
    private WebElement positions;


    WebElement myElement;
    public void findAndClick(String strlement)
    {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement)
        {
            case "setupOne" : myElement=setupOne;break;
            case "parameters" : myElement=parameters;break;
            case "documentType" : myElement=documentType;break;
            case "gradeLevels" : myElement=gradeLevels;break;
            case "humanResources": myElement = humanResources; break;
            case "setupHumanResources": myElement = setupHumanResources; break;
            case "positionCategories": myElement = positionCategories; break;
            case "attestations": myElement = attestations; break;
            case "positions": myElement = positions; break;

        }

        clickFunction(myElement);
    }



}
