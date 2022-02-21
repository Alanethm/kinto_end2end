package e2eTests.cukeStepDefinitions.menu;

import Components.header.TopBarComponent;
import io.cucumber.java.en.When;

public class MenuSteps {
    TopBarComponent header;

    @When("he click on the menu on new customer")
    public void heClickOnTheMenuOnNewCustomer() {
        header.clickOnTheBurgerMenu();
        header.clickOnMenu_Customer();
        header.clickOnSubMenu_NewCustomer();
    }
}
