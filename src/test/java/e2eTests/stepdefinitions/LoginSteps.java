package e2eTests.stepdefinitions;

import Pages.home.HomePage;
import net.thucydides.core.annotations.Step;

public class LoginSteps {

    HomePage homePage;

    @Step("The dealer fills the username: {0} into the userAccount field")
    public void setUsername(String username) {
        homePage.getLoginComponent().setUsername(username);
    }

    @Step("The dealer fills the password: {0} into the password field")
    public void setPassword(String pwd) {
        homePage.getLoginComponent().setPassword(pwd);
    }

    @Step("The dealer submit the login credentials")
    public void clickOnLoginButton() {
        homePage.getLoginComponent().submitLoginCredential();
    }


    @Step("The dealer fills the username: {0} into the userAccount field")
    public void setUsernameMilesRia(String username) {
        homePage.getLoginComponent().setUsernameMilesRia(username);
    }

    @Step("The dealer fills the password: {0} into the password field")
    public void setPasswordMilesRia(String pwd) {
        homePage.getLoginComponent().setPasswordMilesRia(pwd);
    }

    @Step("The dealer submit the login credentials")
    public void clickOnLogonButtonMilesRia() {
        homePage.getLoginComponent().submitLoginCredentialMilesRia();
    }
}
