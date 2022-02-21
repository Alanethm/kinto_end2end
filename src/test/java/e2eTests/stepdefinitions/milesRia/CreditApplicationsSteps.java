package e2eTests.stepdefinitions.milesRia;

import Pages.milesRiaPages.CreditApplicationsPage;
import net.thucydides.core.annotations.Step;

public class CreditApplicationsSteps {

    CreditApplicationsPage creditApplicationsPage;


    @Step()
    public void selectComplete() {
        creditApplicationsPage.selectComplete();
    }

    @Step()
    public void selectCompleteLTC() {
        creditApplicationsPage.selectCompleteLTC();
    }

    @Step()
    public void clickOnOK() {
        creditApplicationsPage.clickOnOK();
    }
}
