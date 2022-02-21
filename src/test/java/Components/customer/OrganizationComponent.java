package Components.customer;

import Pages.ReusableViewElements;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class OrganizationComponent extends ReusableViewElements {
    private final By STREET_NAME = By.id("quote:prospectdetail:prospectView:main:bpPrimaryAddress:address");
    private final By STREET_NUMBER = By.id("quote:prospectdetail:prospectView:main:bpPrimaryAddress:houseNumber");
    private final By ZIP_CODE = By.id("quote:prospectdetail:prospectView:main:bpPrimaryAddress:postalCode");
    private final By PHONE_NUMBER = By.id("quote:prospectdetail:prospectView:main:bpPrimaryAddress:phoneNrs:0:typedPhone_localNr");
    private final By CITY = By.id("quote:prospectdetail:prospectView:main:bpPrimaryAddress:city");
    private final By country = By.id("prospectdetail:prospectView:main:bpPrimaryAddress:country_label");
    private final By COMPANY = By.id("quote:prospectdetail:prospectView:main:primaryAddress:name");
    private final String legaly_entity = "prospectdetail:prospectView:main:legalentity_";
    private final By saveBtn = By.id("prospectdetail:saveButton");
    private final By TITLE = By.id("quote:prospectdetail:prospectView:main:primaryContact:common_contact");
    private final By TITLE_items = By.id("quote:prospectdetail:prospectView:main:primaryContact:common_contact_items");
    private final By TITLE_Dr = By.id("quote:prospectdetail:prospectView:main:primaryContact:common_contact_1");
    private final By TITLE_Mr = By.id("quote:prospectdetail:prospectView:main:primaryContact:common_contact_1");
    private final By SURNAME = By.id("quote:prospectdetail:prospectView:main:primaryContact:contact_lname");
    private final By LAST_NAME = By.id("quote:prospectdetail:prospectView:main:primaryContact:contact_fname");
    private final By Email = By.id("quote:prospectdetail:prospectView:main:primaryContact:contactemail");
    private final By BIRTH_DATE = By.id("quote:prospectdetail:prospectView:main:primaryContact:contact_date_of_birth2_input");
    private final By LEGAL_ENTITY = By.id("quote:prospectdetail:prospectView:main:legalentity_label");
    private final By ENTITY_SOCIETA_SIMPLICE = By.id("quote:prospectdetail:prospectView:main:legalentity_33");
    private final By IMPRESA_INDIVIDUALE = By.id("quote:prospectdetail:prospectView:main:legalentity_3");
    private final By SARL = By.id("quote:prospectdetail:prospectView:main:legalentity_7");
    private final By Fleet_Size = By.id("quote:prospectdetail:prospectView:main:primaryAddress:fleetSize");
    private final By ENTITY_PROF_LIB = By.id("quote:prospectdetail:prospectView:main:legalentity_4");

    public OrganizationComponent(WebDriver driver) {
        super(driver);
    }

    public void setLegal_entity(String legal_entity) {
        waitABit(3000);
        waitUntilPageCompletelyRender();
        element(LEGAL_ENTITY).click();
        waitABit(500);
        WebElement panel_dropdown = element(By.id("quote:prospectdetail:prospectView:main:legalentity_panel"));
        WebElement ul = panel_dropdown.findElement(By.id("quote:prospectdetail:prospectView:main:legalentity_items"));
        List<WebElement> lis = ul.findElements(By.tagName("li"));
        for(int i = 1; i < lis.size(); i++) {
            String legalEntityStr = lis.get(i).getText();
            String legalEntityStr_ = legalEntityStr;
            if(legalEntityStr.contains("'")){
                legalEntityStr_ = legalEntityStr.replace("'","");
            }
            if(legalEntityStr_.equalsIgnoreCase(legal_entity)) {
                lis.get(i).click();
                waitABit(2000);
                return;
            }
        }
        /*switch (legal_entity) {
            case "Societa  Semplice":
                element(ENTITY_SOCIETA_SIMPLICE).click();
                break;
            case "IMPRESA INDIVIDUALE":
                element(IMPRESA_INDIVIDUALE).click();
                break;
            case "SARL":
                element(SARL).click();
                break;
            case "PROF.LIB":
                element(ENTITY_PROF_LIB).click();
                break;
            default: fail("The entity: "+legal_entity+ " is unknown");
        }
        waitABit(1000);*/
    }

    public void verifiedSelectedEntity(String name, int position) {
        WebElement elt = element(By.id(legaly_entity + position));
        Assert.assertEquals("there are not equals", elt.getText(), name);
    }


    public void setFleetSize(String fleetSize) {
        element(Fleet_Size).sendKeys(fleetSize);
    }

    public void setCompany(String company_Name) {
        waitABit(2000);
        element(COMPANY).sendKeys(company_Name);
        scrollToPosition(0, 300);
        waitABit(1000);
    }

    public void setStreetName(String street_Name) {
        element(STREET_NAME).sendKeys(street_Name);
        waitABit(2000);
    }

    public void setStreetNumber(String number) {
        element(STREET_NUMBER).sendKeys(number);
        waitABit(2000);
    }

    public void setZipCode(String zip_code) {
        element(ZIP_CODE).sendKeys(zip_code);
        waitABit(2000);
    }

    public void setCity(String theCity) {
        element(CITY).sendKeys(theCity);
        waitABit(2000);
    }

    public void setPhoneNumber(String phone_Number) {
        waitABit(3000);
        element(PHONE_NUMBER).sendKeys(phone_Number);
        waitABit(2000);
    }

    public void setCountry(String theCountry) {
//        element(country).sendKeys(theCountry);
        waitABit(2000);
    }

    public void save() {
        element(saveBtn).click();
    }

    public void setTitleByText(String title){
        element(TITLE).click();
        WebElementFacade elementFacade = find(TITLE_items);
        List<WebElement> anchors = elementFacade.findElements(By.tagName("li"))
                .stream()
                .filter(c -> c.getAttribute("textContent").equalsIgnoreCase(title))
                .collect(Collectors.toList());
        String s = anchors.get(0).getAttribute("textContent");
        assertFalse("The title: "+title+" is unknown", anchors.size()!=1);
        anchors.get(0).click();
        waitABit(3000);
    }

    public void setTitle(String title) {
        element(TITLE).click();
        waitABit(500);
        switch (title) {
            case "Dr":
                element(TITLE_Dr).click();
                break;
            case "Mr":
                element(TITLE_Mr).click();
                break;
            default:
        }
        waitABit(1000);
    }

    public void setSurname(String surname) {
        waitABit(500);
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

    public void setBirthDate(String birthDate) {
        element(BIRTH_DATE).sendKeys(birthDate);
        waitABit(1000);
    }
}
