package e2eTests.cukeStepDefinitions.milesWeb.login;


import Pages.home.HomePage;
import Utils.generatedTestData.TestData;
import e2eTests.stepdefinitions.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import utils.UserPropertiesManager;

public class loginCucumberSteps extends TestData{

//    private ThreadLocal<String> countryThreadLocal = new ThreadLocal<>();

    @Steps
    LoginSteps loginSteps;

    HomePage homePage;


    @Given("The dealer open the MilesWeb portal Dealer home page")
    public void theDealerOpenTheMilesWebPortalDealerHomePage() {
        homePage.open(); //TODO this method used the default url please refactor it
    }

    @And("he logs in")
    public void doLogin() {
        loginSteps.setUsername(UserPropertiesManager.getUserProperty().getProperty("user.username"));
        loginSteps.setPassword(UserPropertiesManager.getUserProperty().getProperty("user.password"));
        loginSteps.clickOnLoginButton();
    }


    @Given("The dealer has opened the MilesWeb backoffice {string}")
    public void theDealerOpenTheMilesWebBackoffice(String country) {
        homePage.openMilesWebMainPageURL(country);
    }

    @Given("The dealer has opened the MilesRia backoffice {string}")
    public void openMilesRiaBackoffice(String country) {
        homePage.openMilesRiaMainPageURL(country);
    }

    @And("he logs in MilesRia")
    public void heLoginInMilesRia() {
        loginSteps.setUsernameMilesRia(UserPropertiesManager.getUserProperty().getProperty("user.username"));
        loginSteps.setPasswordMilesRia(UserPropertiesManager.getUserProperty().getProperty("user.password"));
        loginSteps.clickOnLogonButtonMilesRia();
    }
}
