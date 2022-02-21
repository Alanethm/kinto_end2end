package Components.customer;

import Pages.ReusableViewElements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SoleTraderComponent extends ReusableViewElements {
    private String name;

    public SoleTraderComponent(WebDriver driver) {
        super(driver);
    }
    private final String legaly_entity = "prospectdetail:prospectView:main:legalentity_label";
    private final By traderName = By.id("prospectdetail:prospectView:main:businessAddress:name");
    private final By streetName = By.id("prospectdetail:prospectView:main:prvtAddress:address");
    private final By streetNumber = By.id("prospectdetail:prospectView:main:prvtAddress:houseNumber");
    private final By zipCode = By.id("prospectdetail:prospectView:main:prvtAddress:postalCode");
    private final By city = By.id("prospectdetail:prospectView:main:prvtAddress:city");
    private final By country = By.id("prospectdetail:prospectView:main:prvtAddress:country_label");
    private final By phoneNumber = By.id("prospectdetail:prospectView:main:prvtAddress:phoneNrs:0:typedPhone_localNr");
    private final By saveBtn = By.id("prospectdetail:saveButton");
    private final By agreement_buton = By.id("prospectdetail:submit-confirmButton");
    private final By done = By.id("stips:donebtn");


    public void setTrader(String name) {
        this.name = name;
        element(traderName).sendKeys(name);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("scroll(0, 300);");
    }

    public void setStreetName(String street_Name){
        //scrollToElement(element(streetName));
        element(streetName).sendKeys(street_Name);
        waitABit(2000);
    }

    public void setStreetNumber(String number){
        element(streetNumber).sendKeys(number);
        waitABit(2000);
    }

    public void setZipCode(String zip_code){
        element(zipCode).sendKeys(zip_code);
        waitABit(2000);
    }

    public void setCity (String city_name){
        element(city).sendKeys(city_name);
        waitABit(2000);
    }

    public void setCountry(String theCountry){
        element(country).sendKeys(theCountry);
        waitABit(2000);
    }

    public void setPhoneNumber(String phone_Number){
        element(phoneNumber).sendKeys(phone_Number);
        waitABit(2000);
    }

    public void save() {
        element(saveBtn).click();
    }


    public void agree() {
        element(agreement_buton).click();
        waitABit(1000);
    }

    public void done() {
        element(done).click();
    }
}
