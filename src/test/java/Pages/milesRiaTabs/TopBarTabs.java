package Pages.milesRiaTabs;

import Pages.ReusableViewElements;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;

import java.util.List;


public class TopBarTabs extends ReusableViewElements {

    private final String SAVE = "//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/24/save.png')]";
    private final String NEXT_BUTTONS = "//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/24/status_next.png?')]";
    private final String NEW_INVOICE = "//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/16/invoice.png?')]";
    private String OPEN_VEHICLE = "//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/24/vehicle.png')]";
    private String OPEN_VEHICLE_Order = "//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/24/order.png?')]";
    private final String CONTRACT = "//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/24/status_end.png?')]";
    private final String CREATE_CONTRACT= "//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+ "milesria/resource/skins/MRI/images/Sofico/24/action.png?')]";
    private final String CLOSE= "//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+ "milesria/resource/skins/MRI/images/Sofico/16/close.png?')]";

    public TopBarTabs(WebDriver driver) {
        super(driver);
    }

    public void clickOnOpenVehicle(){
        waitABit(1500);
        element(OPEN_VEHICLE).click();
        waitABit(16000);
    }

    public void clickOnVehicleOrder(){
        Actions actions =new Actions(getDriver());
        actions.sendKeys(Keys.TAB);
        actions.perform();
        actions.sendKeys(Keys.TAB);
        actions.perform();
        actions.sendKeys(Keys.TAB);
        actions.perform();
        actions.sendKeys(Keys.TAB);
        actions.perform();
        actions.release();
        List<WebElementFacade> all = findAll(OPEN_VEHICLE_Order);
        all.get(0).click();
        waitABit(4000);
    }

    public void clickOnSaved() {
        waitABit(2000);
        try {
            element(SAVE).click();
        }catch(ElementNotInteractableException enie){
            findAll(SAVE).get(1).click();
            waitABit(1000);
        }
    }

    public void clickOnValidate(){
        waitABit(4000);
        List<WebElementFacade> getAllNextButton = findAll(NEXT_BUTTONS);
        getAllNextButton.get(0).click();
        waitABit(7000);
    }

    public void clickOnApprove() {
        waitABit(2000);
        List<WebElementFacade> getAllNextButton = findAll(NEXT_BUTTONS);
        getAllNextButton.get(0).waitUntilClickable().click();
        waitABit(5000);
    }

    public void clickOnContract(){
        waitABit(2000);
        List<WebElementFacade> getAllNextButton = findAll(CONTRACT);
        getAllNextButton.get(1).click();
        waitABit(5000);
    }

    public void closeMessage(){
        element(CLOSE).click();
        waitABit(1000);
    }

    public void clickOnCreateContract(){
        waitABit(2000);
        List<WebElementFacade> getAllNextButton = findAll(CREATE_CONTRACT);
        getAllNextButton.get(2).click();
        waitABit(25000);
    }

    public void clickOnNewInvoice(){
        waitABit(1000);
        if(currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            findAll(NEW_INVOICE).get(0).click();
            waitABit(6000);
            return;
        }
        element(NEW_INVOICE).click();
    }

    public void clicksApproveVO() {
        waitABit(2000);
        List<WebElementFacade> getAllNextButton = findAll(NEXT_BUTTONS);
        getAllNextButton.get(1).waitUntilClickable().click();
        waitABit(3000);
    }
}
