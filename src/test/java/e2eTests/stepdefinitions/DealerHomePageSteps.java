package e2eTests.stepdefinitions;

import Pages.dealerHome.MilesWebHomePage;
import net.thucydides.core.annotations.Step;

public class DealerHomePageSteps {

    MilesWebHomePage milesWebHomePage;

    @Step("The dealer select a new quotation")
    public void selectNewQuotation() {
        milesWebHomePage.getQuotationComponent().selectNewQuotation();
    }
}
