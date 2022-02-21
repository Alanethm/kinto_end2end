package Components.customer;

import Pages.ReusableViewElements;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class IndividualComponent extends ReusableViewElements {


    private final By STREET_NAME = By.id("quote:prospectdetail:prospectView:main:prvtAddress:address");
    private final By STREET_NUMBER = By.id("quote:prospectdetail:prospectView:main:prvtAddress:houseNumber");
    private final By ZIP_CODE = By.id("quote:prospectdetail:prospectView:main:prvtAddress:postalCode");
    private final By PHONE_NUMBER = By.id ("quote:prospectdetail:prospectView:main:prvtAddress:phoneNrs:0:typedPhone_localNr");
    private final By CITY = By.id("quote:prospectdetail:prospectView:main:prvtAddress:city");
    private final By country = By.id ("prospectdetail:prospectView:main:bpPrimaryAddress:country_label");
    private final By saveBtn = By.id("prospectdetail:saveButton");
    private final By TITLE = By.id("quote:prospectdetail:prospectView:main:common_contact_prvt_label");
    private final By TITLE_ITEMS = By.id("quote:prospectdetail:prospectView:main:common_contact_prvt_items");
    private final By TITLE_Dr = By.id("quote:prospectdetail:prospectView:main:common_contact_prvt_1");
    private final By TITLE_Mr = By.id("quote:prospectdetail:prospectView:main:common_contact_prvt_1");
    private final By TITLE_Mrs = By.id("quote:prospectdetail:prospectView:main:common_contact_prvt_2");
    private final By TITLE_Miss = By.id("quote:prospectdetail:prospectView:main:common_contact_prvt_2");
    private final By ESTABLISHMENT_DATE = By.id("quote:prospectdetail:prospectView:main:businessAddress:establishmentdate_input");
    private final By SURNAME = By.id("quote:prospectdetail:prospectView:main:contact_lname_prvt");
    private final By LAST_NAME = By.id("quote:prospectdetail:prospectView:main:contact_fname_prvt");
    private final By Email = By.id("quote:prospectdetail:prospectView:main:contactemail_prvt");
    private final By COMPANY = By.id("quote:prospectdetail:prospectView:main:businessAddress:name");


    public IndividualComponent(WebDriver driver) {
        super(driver);
    }


    public void setCompany(String company_Name){
        element(COMPANY).sendKeys(company_Name);
        scrollToPosition(0, 300);
    }

    public void setStreetName(String street_Name){
        element(STREET_NAME).sendKeys(street_Name);
        waitABit(1000);
    }

    public void setEstablishmentDate(String date){
        element(ESTABLISHMENT_DATE).sendKeys(date);
        waitABit(1000);
    }

    public void setStreetNumber(String number){
        element(STREET_NUMBER).sendKeys(number);
        waitABit(1000);
    }

    public void setZipCode(String zip_code){
        element(ZIP_CODE).sendKeys(zip_code);
        waitABit(1000);
    }

    public void setCity (String theCity){
        element(CITY).sendKeys(theCity);
        waitABit(3000);
    }

    public void setPhoneNumber(String phone_Number){
        waitABit(4000);
        element(PHONE_NUMBER).sendKeys(phone_Number);
        waitABit(1000);
    }

    public void save() {
        element(saveBtn).click();
    }

    public void setTitleByText(String title){
        waitUntilPageCompletelyRender();
        element(TITLE).click();
        WebElementFacade elementFacade = find(TITLE_ITEMS);
        List<WebElement> anchors = elementFacade.findElements(By.tagName("li"))
                .stream()
                .filter(c -> c.getAttribute("textContent").equalsIgnoreCase(title))
                .collect(Collectors.toList());
        String s = anchors.get(0).getAttribute("textContent");
        assertFalse("The title: "+title+" is unknown", anchors.size()!=1);
        anchors.get(0).click();
        waitABit(1000);
    }

    public void setTitle(String title) { //TODO select by text

        element(TITLE).click();
        waitABit(500);
        switch (title){
            case "Dr" : element(TITLE_Dr).click();
                break;
            case "Mr" : element(TITLE_Mr).click();
                break;
            case "Mrs" : element(TITLE_Mrs).click();
                break;
            default: fail("Unknown Title: "+title);
        }
        waitABit(1000);
    }

    public void setSurname(String surname) {
        waitABit(2000);
        element(SURNAME).sendKeys(surname);
        waitABit(1000);
    }

    public void setName(String firstName) {
        element(LAST_NAME).sendKeys(firstName);
        waitABit(1000);
    }

    public void setEmail(String email) {
        element(Email).sendKeys(email);
        waitABit(1000);
    }
}
