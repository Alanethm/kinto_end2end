package e2eTests.cukeStepDefinitions.milesRia;

import e2eTests.stepdefinitions.milesRia.GlobalMrSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class GlobalMRCucumberSteps {

    @Steps
    GlobalMrSteps globalMrSteps;


    @Then("he saves")
    public void heSaved() {
        globalMrSteps.clickOnSaved();
    }

    @And("he validates")
    public void heValidate() {
        globalMrSteps.clickOnValidate();
    }

    @And("he approves")
    public void heApprove() {
        globalMrSteps.clickOnApprove();
    }

    @And("he clicks approves from vehicle order")
    public void clicksApproveVO() {
        globalMrSteps.clicksApproveVO();
    }

    @And("he creates an invoice from the vehicle order")
    public void heCreateAnInvoiceFromTheVehicleOrder() {
        globalMrSteps.clickOnNewInvoice();
    }

    @And("he clicks on contract")
    public void heClicksOnContract() {
        globalMrSteps.clickOnContract();
    }

    @And("he closes the message")
    public void closeMessage(){
        globalMrSteps.closeMessage();
    }

    @And("he clicks on create contract")
    public void heClicksOnCreateContract() {
        globalMrSteps.clickOnCreateContract();
    }


}
