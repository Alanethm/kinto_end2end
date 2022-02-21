package e2eTests.stepdefinitions.milesRia;

import Pages.dealerHome.MilesRiaHomePage;
import net.thucydides.core.annotations.Step;

public class HomePageMRSteps {

    MilesRiaHomePage milesRiaHomePage;

    @Step("The dealer select quotes in quick access")
    public void selectItemInQuickAccess(String menuName) {
        milesRiaHomePage.getMilesRiaTopHeaderComponent().setQuickAccessMenu(menuName);
    }

    @Step("The dealer search the quoteId: {0}")
    public void searchItem(String item) {
        milesRiaHomePage.getMilesRiaTopHeaderComponent().searchQuote(item);
    }

    public void searchItem() {
        milesRiaHomePage.getMilesRiaTopHeaderComponent().searchItem();
    }
}
