package Components;

import Pages.ReusableViewElements;
import Utils.constance.MenuName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utils.constance.MenuName.LONG_TERM_CONTRACTS;
import static Utils.constance.MenuName.QUOTES;


public class MilesRiaTopHeaderComponent extends ReusableViewElements {
    public MilesRiaTopHeaderComponent(WebDriver driver) {
        super(driver);
    }

    private final By quickNavigation = By.id("sofid_id_quicknavigation_field");

    public void setQuickAccessMenu(String menuName) {
        waitABit(4000);
        element(quickNavigation).sendKeys(menuName);
        waitABit(250);
        if(LONG_TERM_CONTRACTS.getName().equalsIgnoreCase("Long")){
            try {
                element(By.cssSelector(".cell:nth-child(3) > div")).click();
            }catch (StaleElementReferenceException ste){
                element(By.cssSelector(".cell:nth-child(3) > div")).click();
            }

        } else if(QUOTES.getName().equalsIgnoreCase("Quotes")){
            element(By.cssSelector("tr:nth-child(1) > .cell:nth-child(3) > div")).click();
        }
        waitABit(1000);
    }

    public void searchQuote(String item) {
        element(quickNavigation).sendKeys(item);
        waitABit(2000); //
        element(quickNavigation).sendKeys(Keys.ENTER);
        waitABit(6000);
    }

    public void searchItem() {
        element(quickNavigation).sendKeys(quoteID);
        waitABit(2000); //
        element(quickNavigation).sendKeys(Keys.ENTER);
        waitABit(6000);
    }
}
