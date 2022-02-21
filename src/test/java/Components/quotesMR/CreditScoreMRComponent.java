package Components.quotesMR;

import Pages.ReusableViewElements;
import Utils.CurrentProperties;
import net.serenitybdd.core.SerenitySystemProperties;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class CreditScoreMRComponent extends ReusableViewElements {

    private final By creditScore = By.id("id_menu_2_valueCell4");
    private final By statusTextField = By.name("A3211");
    private final By decisionTextField = By.name("A3214");
    private final By contract = By.xpath("//img[contains(@src,'" + currentProperties.getCurrentCountryIP() + "milesria/resource/skins/MRI/images/Sofico/24/status_end.png?')]");

    public CreditScoreMRComponent(WebDriver driver) {
        super(driver);
    }

    public String selectCreditScore() {

        scrollToElement(element(creditScore));
        waitABit(3000);
        if (currentProperties.getCurrentCountry().equalsIgnoreCase("france")) {
            element(creditScore).click();
            waitABit(5000);
        }
        return element(creditScore).getText();
    }

    public void overviewSetStatus(String status) {
        waitABit(5000);
        Boolean staleElement = true;
        while (staleElement) {
            try {
                Actions action = new Actions(getDriver());
                action.sendKeys(Keys.TAB);
                action.sendKeys(Keys.TAB);
                action.perform();
                waitABit(400);
                action.sendKeys(Keys.DELETE);
                action.perform();
                waitABit(200);
                action.sendKeys(status);
                action.perform();
                action.sendKeys(Keys.ENTER);
                action.perform();
                action.release();
                waitABit(200);
//                element(statusTextField).clear();
//                waitABit(500);
//                element(statusTextField).sendKeys(status);
//                element(statusTextField).sendKeys(Keys.ENTER);
                staleElement = false;

            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
    }

    public void setStatus(String status) {
        //TODO Refactor possible endless loop
        Boolean staleElement = true;
        while (staleElement) {
            try {
                element(statusTextField).clear();
                waitABit(500);
                element(statusTextField).sendKeys(status);
                element(statusTextField).sendKeys(Keys.ENTER);
                staleElement = false;

            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
    }

    public void setDecision(String decision) {
        waitABit(6500);
        element(decisionTextField).click();
        element(decisionTextField).sendKeys(decision);
//        Actions actions = new Actions(getDriver());
//        actions.sendKeys(Keys.TAB);
//        actions.build().perform();
//        actions.sendKeys(decision);
//        actions.build().perform();
//
//        if (currentProperties.getCurrentCountry().equalsIgnoreCase("italy")) {
//            element(decisionTextField).click();
//            element(decisionTextField).sendKeys(decision);
//            actions.moveToElement(element(decisionTextField));
//            actions.sendKeys(Keys.ENTER);
//            actions.build().perform();
//            Boolean staleElement = true;
//            while (staleElement) {
//                try {
////                element(decisionTextField).clear();
//                    actions.sendKeys(decision);
//                    actions.build().perform();
////                element(decisionTextField).sendKeys(decision);
////                element(decisionTextField).sendKeys(Keys.ENTER);
//                    staleElement = false;
//
//                } catch (StaleElementReferenceException e) {
//                    staleElement = true;
//                }
//            }
//        }
//
    }

    public void clickOnContract() {
        waitABit(1000);
        element(By.name("R1305")).click();
        waitABit(2000);
        element(contract).click();
        waitABit(7000);
    }
}
