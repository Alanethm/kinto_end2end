package Components.quotesMR;

import Pages.ReusableViewElements;
import Utils.generatedTestData.TestData;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class VehicleUsagesMRComponent extends ReusableViewElements {
    public VehicleUsagesMRComponent(WebDriver driver) {
        super(driver);
    }

    private final By VehicleUsages = By.xpath("//div[@id='id_menu_5_valueCell6']/div");
    private final By Registration_And_Documents = By.xpath("//div[@id='id_menu_5_valueCell7']/div");
    private final By Registration_And_Documents_fr = By.xpath("//div[@id='id_menu_7_valueCell7']/div");
    private final String ADD_LICENCE_PLATE = "//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/16/add.png')]";
    private final By VinNumber = By.name("A917");

    public void clickOnVehicleUsages() {
//        id_menu_4_valueCell6
        if(currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            By VehicleUsagesFr = By.xpath("//div[@id='id_menu_7_valueCell6']/div");
            waitABit(3000);
            scrollToElement(element(VehicleUsagesFr));
            element(VehicleUsagesFr).click();
            return;
        }
        waitABit(3000);
        scrollToElement(element(VehicleUsages));
        element(VehicleUsages).click();
    }

    public void clickOnRegistrationAndDocuments() {
        if(currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            waitABit(2000);
            element(Registration_And_Documents_fr).click();
            waitABit(1000);
            return;
        }
        waitABit(2000);
        element(Registration_And_Documents).click();
        waitABit(1000);
    }

    public void registeredLicencePlate(){
        String licenceNumber = "";
        if(currentProperties.getCurrentCountry().equalsIgnoreCase("France")){
            licenceNumber = TestData.getLicenceNumberFrance();
        }else if (currentProperties.getCurrentCountry().equalsIgnoreCase("Italy")){
            licenceNumber = TestData.getLicenceNumberITALY();
        }
        Actions actions = new Actions(getDriver());
        List<WebElementFacade> all = findAll(ADD_LICENCE_PLATE);
        all.get(9).click();
        waitABit(2000);
        actions.sendKeys(Keys.TAB).build().perform();
        waitABit(1000);
        actions.sendKeys(Keys.TAB).build().perform();
        waitABit(1000);
        actions.sendKeys(licenceNumber).build().perform();
        waitABit(1000);
        actions.sendKeys(Keys.TAB).build().perform();
        waitABit(1000);
    }

    public void setRegistrationDate(String futureDate) {
        Actions actions = new Actions(getDriver());
        waitABit(1000);
        actions.sendKeys(futureDate).build().perform();
        waitABit(1000); //TODO Refactor
        actions.sendKeys(Keys.TAB).build().perform();
        waitABit(2000);
    }

    public void setVINNr(String vinNr) {
        waitABit(1000);
        sendKeysAfterStaleness(VinNumber, false, vinNr);
        waitABit(1000);
    }
}
