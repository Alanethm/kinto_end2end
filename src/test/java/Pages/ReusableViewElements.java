package Pages;


import Utils.CurrentProperties;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static Utils.constance.Country.FRANCE;
import static Utils.constance.Country.ITALY;

public class ReusableViewElements extends PageObject {

    private final String nextButtonId = "quote:navigationButton_next";
    public ReusableViewElements(WebDriver driver) {
        super(driver);
    }
    public static CurrentProperties currentProperties;
    public static String quoteID;
    protected WebDriverWait webDriverWait= new WebDriverWait(getDriver(), 5);

    public void openURL(String pageURL){
        getDriver().get(pageURL);
        waitABit(1000);
    }

    public void openMRTabPerIndex(int tabIndex){
        String country =  currentProperties.getCurrentCountry();
        switch (country.toUpperCase()){
            case "ITALY": openURL(ITALY.getMilesRiaURL()+"#tab_"+tabIndex);
                break;
            case "FRANCE" : openURL(FRANCE.getMilesRiaURL()+"#tab_"+tabIndex);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + country.toUpperCase());
        }
    }

    public void openMilesWebMainPageURL(String country){
        // important to set the active country property at the beginning
        currentProperties = new CurrentProperties(country);
        switch (country.toUpperCase()){
            case "ITALY": openURL(ITALY.getMilesWebURL());
                break;
            case "FRANCE": openURL(FRANCE.getMilesWebURL());
                // important to set the active country property at the beginning
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + country.toUpperCase());
        }
        waitABit(1000);
    }

    public void openMilesRiaMainPageURL(String country){
        // important to set the active country property at the beginning
        currentProperties = new CurrentProperties(country);
        switch (country.toUpperCase()){
            case "ITALY": openURL(ITALY.getMilesRiaURL());
                break;
            case "FRANCE": openURL(FRANCE.getMilesRiaURL());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + country.toUpperCase());
        }
        waitABit(1000);
    }

    public void clickOnNext() {
        waitABit(3000);
        waitUntilPageCompletelyRender();
        Actions act = new Actions(getDriver());
        act.moveToElement(element(By.id(nextButtonId))).click().build().perform();
        //element(By.id(nextButtonId)).click();
        waitUntilPageCompletelyRender();
        //waitABit(6000);
    }

    public void waitUntilPageCompletelyRender(){
        waitABit(1000);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("busy_save_dialog_modal")));
       // ((JavascriptExecutor) getDriver()).executeScript("document.getElementById('busy_dialog').style.display='block';");
           // waitForCondition().until(ExpectedConditions.invisibilityOf(element(By.id("busy_dialog"))));
    }

    public ExpectedCondition<Boolean> clickUntilElementIsStale(WebElement toClick){
        return driver -> {
            try {
                if(webDriverWait.withTimeout(Duration.ofSeconds(4))
                        .until(ExpectedConditions.stalenessOf(toClick))){
                    return true;
                }
            } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e){
            }
            try {
                toClick.click();
            } catch (StaleElementReferenceException e){

            }return false;
        };
    }

    public void sendKeysAfterStaleness(By elementBy, boolean cleartext, CharSequence... charSequences) {
        Boolean staleElement = true;
        long startTime = System.currentTimeMillis();
        while(staleElement && (System.currentTimeMillis()-startTime)< 5000){
            try{
                if(cleartext) element(elementBy).clear();
                waitABit(1000);
                element(elementBy).sendKeys(charSequences);
                staleElement = false;

            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
    }
    public void sendKeysAfterStaleness(WebElementFacade we, boolean cleartext, CharSequence... charSequences) {
        Boolean staleElement = true;
        long startTime = System.currentTimeMillis();
        while(staleElement && (System.currentTimeMillis()-startTime)< 5000){
            try{
                if(cleartext) we.clear();
                we.sendKeys(charSequences);
                staleElement = false;

            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
    }

    public void typeAfterStaleness(By elementBy, CharSequence... charSequences) {
        Boolean staleElement = true;
        while(staleElement){
            try{
                element(elementBy).type(charSequences);
                staleElement = false;

            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
    }

    /**
     *
     * @param elementToReach
     */
    public void scrollToElement(WebElement elementToReach) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        long startTime = System.currentTimeMillis();
        Boolean staleElement = true;
        while(staleElement && (System.currentTimeMillis()-startTime)< 5000){
            try{
                js.executeScript("arguments[0].scrollIntoView();",  elementToReach);
                staleElement = false;

            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
    }

    /**
     *
     * @param from position x
     * @param to to position y
     */
    public void scrollToPosition(int from, int to) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("scroll("+from+", "+to+");");
    }

    /**
     * This method select a date in the future
     *
     * @param numBerOfDaysInTheFuture
     * @return Actual date plus a number of day to reach the future date
     */
    public String getFutureDate(int numBerOfDaysInTheFuture) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, numBerOfDaysInTheFuture);
        DateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy" );
        return formatter.format(calendar.getTime());
    }

    public void waitAndClickElementUsingJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
            js.executeScript("arguments[0].click();", element);
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement staleElement = element;
            Boolean elementPresent = webDriverWait.until(ExpectedConditions.elementToBeClickable(staleElement)).isEnabled();
            if (elementPresent == true) {
                js.executeScript("arguments[0].click();", elementPresent);
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to JS click on the WebElement, Exception: " + e.getMessage());
        }
    }

    public void getQuoteID() {
        String text = element(By.cssSelector("td.tabButtonBottomSelected > div")).getText();
        quoteID= text.replaceAll("Quote ", "");
    }

    public void closeBrowser() {
        getDriver().close();
    }

    public void openMRTabPerName(String tabName) {
        List<WebElementFacade> tabs = findAll(By.className("tabButtonBottom"));
        for (WebElementFacade tab: tabs) {
            String text = tab.getText();
            if(text.contains(tabName)){
                if(text.contains(ReusableViewElements.quoteID)){
                    tab.click();
                    break;
                }
                tab.click();
                waitABit(2000);
            }
        }

    }

    public void clickOnContextMenu(By contextMenuByName) {
        scrollToElement(element(contextMenuByName));
        element(contextMenuByName).click();
        waitABit(1000);
    }

    public String getActiveTabName(){
        WebDriverWait t = new WebDriverWait(getDriver(), 3);
        WebElement navigatorTab = element(By.id("quote:tabNavigator"));
        t.until(ExpectedConditions.visibilityOf(navigatorTab));

        String activeTabName = navigatorTab.findElement(By.className("ui-state-focus")).findElement(By.className("tabLink")).getText();
        return activeTabName;
    }

}
