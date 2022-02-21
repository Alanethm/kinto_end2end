package e2eTests.cukeStepDefinitions.milesWeb.dealerHomePage;

import Utils.generatedTestData.TestData;
import e2eTests.stepdefinitions.DealerHomePageSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DealerHomePageCucumberSteps extends TestData {

    @Steps
    DealerHomePageSteps dealerHomePageSteps;

    @Then("he can see the dealer home page")
    public void he_can_see_the_dealer_home_page() {
//        TODO implement
    }

    @When("he selects a new quotation")
    public void he_selects_a_new_quotation() {
        dealerHomePageSteps.selectNewQuotation();
    }
}
