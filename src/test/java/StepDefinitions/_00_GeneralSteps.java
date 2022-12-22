package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

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
}
