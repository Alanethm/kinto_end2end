package e2eTests.cukeStepDefinitions.milesRia;

import e2eTests.stepdefinitions.milesRia.HomePageMRSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

import static Utils.constance.MenuName.LONG_TERM_CONTRACTS;
import static Utils.constance.MenuName.QUOTES;

public class HomePageMRCucumberSteps {

    @Steps
    HomePageMRSteps homePageMRSteps;


    @Given("he searches a quote {string}")
    public void he_search_a_quote(String quoteId) {
        homePageMRSteps.selectItemInQuickAccess(QUOTES.getName());
        homePageMRSteps.searchItem(quoteId);
    }

    @And("he searches a long term contract {string}")
    public void heSearchALongTermContractQuoteID(String ltc) {
        homePageMRSteps.selectItemInQuickAccess(LONG_TERM_CONTRACTS.getName());
        homePageMRSteps.searchItem(ltc);
    }

    @And("he searches for the saved quote")
    public void heSearchTheSavedQuote() {
        homePageMRSteps.selectItemInQuickAccess(QUOTES.getName());
        homePageMRSteps.searchItem();
    }
}
