package e2eTests.cukeStepDefinitions.milesRia;

import e2eTests.stepdefinitions.milesRia.CreditApplicationsSteps;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class CreditApplicationsCucumberSteps {
    @Steps
    CreditApplicationsSteps creditApplicationsSteps;

    @And("he clicks on complete")
    public void heClicksOnComplete() {
        creditApplicationsSteps.selectComplete();
        heClicksOnOK();
    }

    @And("he clicks on ok")
    public void heClicksOnOK() {
        creditApplicationsSteps.clickOnOK();
    }

    @And("he clicks on complete from ltc")
    public void heClicksOnCompleteFromLtc() {
        creditApplicationsSteps.selectCompleteLTC();
        heClicksOnOK();
    }
}
