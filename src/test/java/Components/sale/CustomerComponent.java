package Components.sale;

import Pages.ReusableViewElements;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeEnabledException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class CustomerComponent extends ReusableViewElements {

    private final String searchButtonIT = "quote:j_idt969";
    private final String searchButtonFR = "quote:j_idt982";
    private final String organizationMenuButton = "//div[@id='prospectdata:prospectlegalEntityGroup']/div/span";
    private final String organization = "//button[@id='prospectdata:prospectlistTable:0:j_idt114']/span[2]";
    private final By MODIFY_CUSTOMER_NEW = By.id("quote:j_idt967");
    private final By MODIFY_CUSTOMER_NEW_FR = By.id("quote:j_idt958");
    private final By PROSPECT_DATA_TABLE = By.id("prospectdata:prospectlistTable_data");
    private final By PROSPECT_NAME = By.id("quote:prospectname");
    //    ex GDPR "//*[contains(text(),'Geo-Localization')]";
    private final String GDPR_start = "//*[contains(text(),'";
    private final String GDPR_end = "')]";
    private final By SAVE_BUTTON = By.xpath("//*[@id='quote:save-confirmButton']");

    public CustomerComponent(WebDriver driver) {
        super(driver);
    }

    public void searchCustomerByName(String customerName) {
        waitABit(2000);
        waitUntilPageCompletelyRender();
        element(PROSPECT_NAME).sendKeys(customerName);
        //waitUntilPageCompletelyRender();
        waitABit(1000);
        if (currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            element(By.id(searchButtonFR)).click();
        } else if (currentProperties.getCurrentCountry().equalsIgnoreCase("italy")){
            element(By.id(searchButtonIT)).click();
        }
        waitABit(4000);

    }

    public void switchToOrganizationSearch(){
        waitUntilPageCompletelyRender();
        getDriver().switchTo().frame(0);
        // element(By.xpath(organizationMenuButton)).click();
        //waitABit(5000);
    }
    public void switchToSoleTraderSearch(){
        waitUntilPageCompletelyRender();
        getDriver().switchTo().frame(0);
        findAll(By.xpath(organizationMenuButton)).get(1).click();
        // waitABit(5000);
    }

    public void selectIndividual(){
        waitUntilPageCompletelyRender();
//        getDriver().switchTo().frame(0);
        findAll(By.xpath(organizationMenuButton)).get(0).click();
        //waitABit(5000);
    }

    public void selectCustomer(boolean makeFrameSwitch){
        waitUntilPageCompletelyRender();

        getDriver().switchTo().frame(0);
        if(makeFrameSwitch) { // due to sole trader i want to make the frame switch only if needs
            if(currentProperties.getCurrentCountry().equalsIgnoreCase("italy")){
                element(By.xpath(organizationMenuButton)).click();
                waitABit(1000);
            }
        }
        List<WebElementFacade> anchor = element(PROSPECT_DATA_TABLE).thenFindAll(By.tagName("tr"));
        anchor.get(0).findElement(By.tagName("button")).click();
        getDriver().switchTo().defaultContent();

        //waitABit(3000);
    }

    public void acceptProspectAgreement(String ... agreements) {

        if(currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            waitUntilPageCompletelyRender();
            element(SAVE_BUTTON).waitUntilClickable().click();
            waitUntilPageCompletelyRender();
            // waitABit(4000);
            return;
        }else if(currentProperties.getCurrentCountry().equalsIgnoreCase("italy")){
            waitABit(2000);
            try {
                element(SAVE_BUTTON).waitUntilClickable().click();
            } catch (ElementShouldBeEnabledException e){
                element(By.id("prospectdetail:submit-confirmButton")).click();
            }
            waitABit(1000);
            return;
        }
        waitABit(1000);
    }

    public void clickOnNewCustomer() {
        waitUntilPageCompletelyRender();
        Actions act =new Actions(getDriver());
        if(currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            waitABit(2000);
            act.moveToElement(element(MODIFY_CUSTOMER_NEW_FR)).click().build().perform();
            //element(MODIFY_CUSTOMER_NEW_FR).click();
            waitABit(2000);
        }else {
            waitABit(1000);
            act.moveToElement(element(MODIFY_CUSTOMER_NEW)).click().build().perform();
            //element(MODIFY_CUSTOMER_NEW).click();
            waitABit(2000);
        }

    }

    public void setLegalEntityToPrivate() {
        element(By.id("prospectdata:prospectlegalEntity_label")).click();
        waitABit(500);
        element(By.id("prospectdata:prospectlegalEntity_1")).click();
        waitABit(4000);
    }

    public void selectCustomerInTheResultList(String customerName){
        //waitABit(2000);
        waitUntilPageCompletelyRender();
        WebElement iframe = element(By.id("quote:j_idt960_dlg")).waitUntilVisible()
                .findElement(By.tagName("iframe"));
        getDriver().switchTo().frame(iframe);
        WebElement table = element(By.id("prospectdata:prospectlistTable"));
        WebElement tableBody = table.findElement(By.id("prospectdata:prospectlistTable_data"));

        List<WebElement> trs =  tableBody.findElements(By.tagName("tr"));

        List<WebElement> customers = new LinkedList<>();

        for(WebElement tr : trs){
            List<WebElement> tds = tr.findElements(By.tagName("td"));
            for(WebElement td : tds) {
                if (td.getText().contains(customerName)) {
                    customers.add(tr);
                }
            }
        }
        customers.get(0).findElement(By.tagName("button")).click();
        getDriver().switchTo().defaultContent();
    }

    public void selectCustomerTypeWhenCreateNewAccount(String customerTyp){
        waitUntilPageCompletelyRender();
        WebElement customTyp = element(By.id("quote:prospectdetail:prospectView:main:legal")).findElement(By.className("ui-fieldset-content"))
                .findElement(By.id("quote:prospectdetail:prospectView:main:legalentitygroup"));
        List<WebElement> allCustomerType = customTyp.findElements(By.tagName("span"));
        for(int i = 0; i < allCustomerType.size(); i++){
            if(allCustomerType.get(i).getText().equalsIgnoreCase(customerTyp)){
                Actions act = new Actions(getDriver());
                act.moveToElement(allCustomerType.get(i)).click().build().perform();
                waitABit(2000);
                return;
            }
        }
    }


    public void selectAllProspectAgreement(int nbrOfAgreement) {

         if(currentProperties.getCurrentCountry().equalsIgnoreCase("italy")){
            waitUntilPageCompletelyRender();

             for (int i = 0; i<nbrOfAgreement; i++) {
                 String agreement = "//div[@id='quote:j_idt3946:"+ i +":j_idt3950']/div/span";
                 waitABit(200);
                 element(By.xpath(agreement)).click();
                 waitABit(200);
             }

             waitABit(2000);
                element(SAVE_BUTTON).waitUntilClickable().click();
        }
        waitABit(3000);
    }
}

