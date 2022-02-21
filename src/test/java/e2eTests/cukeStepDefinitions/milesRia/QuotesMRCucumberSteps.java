package e2eTests.cukeStepDefinitions.milesRia;

import Utils.constance.ContextMRMenu;
import Utils.constance.TabName;
import e2eTests.stepdefinitions.milesRia.QuotesMRSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static Utils.constance.ContextMRMenu.SUMMARY;

public class QuotesMRCucumberSteps {

    @Steps
    QuotesMRSteps quotesMRSteps;

    @When("he selects the credit score")
    public void he_selects_the_credit_score() {
        quotesMRSteps.selectCreditScore();
    }

    @And("he sets the status to {string} and the decision to {string}")
    public void set_Status_And_Decision(String status, String decision) {
        quotesMRSteps.setStatus(status);
        quotesMRSteps.setDecision(decision);
    }

    @And("he sets the status to {string}")
    public void setStatus(String status) {
        quotesMRSteps.setStatus(status);
    }

    @And("he sets the decision to {string}")
    public void setDecision(String decision) {
        quotesMRSteps.setDecision(decision);
    }

    @Then("he generates the contract")
    public void generateContract() {
        quotesMRSteps.clickOnContract();
    }

    @When("he selects the resulting contract")
    public void selectResultingContracts() {
        quotesMRSteps.selectResultingContracts();
    }

    @When("he selects stipulation")
    public void selectsStipulation() {
        quotesMRSteps.selectStipulation();
    }

    @When("he selects stipulation from credit applications")
    public void selectCAStipulation() {
        quotesMRSteps.selectCAStipulation();
//        openCAStipulation
    }

    @And("he activates stipulations")
    public void selectedStipulationActivation() {
        quotesMRSteps.activateStipulation();
    }

    @And("he generates a quote")
    public void heGenerateAQuote() {
        quotesMRSteps.clickOnCopy();
        quotesMRSteps.clickOnNewRequest();
    }

    @And("he saves the quoteID")
    public void getQuoteID() {
        quotesMRSteps.getQuoteId();
    }

    @Then("he closes the browser")
    public void heClosesTheBrowser() {
        quotesMRSteps.closeBrowser();
    }

    @And("he selects the credit application")
    public void heSelectsTheCreditApplication() {
        quotesMRSteps.selectsCreditApplication();
    }

    @Then("he selects overview")
    public void heSelectsOverview() {
        quotesMRSteps.clickOnGeneral();
    }

    @Then("he selects in LTC general")
    public void clickOnGeneral() {
        quotesMRSteps.clickOnLTCGeneral();
    }

    @Then("he selects summary")
    public void selectSummary() {
        quotesMRSteps.clickOnContextMenu(SUMMARY.getContextMenuByName());
    }

    @When("he opens the quote tab")
    public void openQuote() {
        quotesMRSteps.openTab(TabName.QUOTE.getTabName());
    }

    @Then("he clicks on stipulation")
    public void heClicksOnStipulation() {
        quotesMRSteps.clickOnStipulation();
    }

    @When("he selects create contract")
    public void heSelectsCreateContract() {
        quotesMRSteps.clickOnContract();
    }

    @And("he refresh")
    public void heRefresh() {
        quotesMRSteps.clickOnRefresh();
    }

    @And("from overview he sets the decision to {string}")
    public void fromOverviewHeSetsTheStatusToCompleted(String decision) {
        quotesMRSteps.overviewSetStatus(decision);
    }

    @And("he opens the financial menu")
    public void heOpensTheFinancialMenu() {
        quotesMRSteps.openFinancial();
    }

    @And("he selects stipulation from financial menu")
    public void heSelectsStipulationFromFinancialMenu() {
        quotesMRSteps.openFinancialStipulation();
    }

}
