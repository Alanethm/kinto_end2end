package Components.sale;

import Pages.ReusableViewElements;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class VehicleComponent extends ReusableViewElements {
    private final By TOYOTA = By.id("quote:makeList:1:j_idt705");
    private final By LEXUS = By.id("quote:makeList:0:j_idt705");
    private final By MODEL_TABLE = By.id("quote:modeltable");
    private final By VEHICLE_ROWS = By.xpath("//div[@class='veh-row']");
    private final By PRODUCT_TYPE = By.id("quote:qTemplateId");
    @FindBy(id = "quote:maketable")
    WebElement makeTable;

    public VehicleComponent(WebDriver driver) {
        super(driver);
    }


    public void selectCarManufacturer(String manufacturer) {
        waitABit(2000);
        waitUntilPageCompletelyRender();
        WebElement plusSign = makeTable.findElement(By.tagName("span"));
        try {
            Thread.sleep(3000);
            if(plusSign.getAttribute("class").contains("ui-icon-plusthick"))
            {
                makeTable.findElement(By.tagName("legend")).click();
            }

            Thread.sleep(3000);
            List<WebElement> anchors = makeTable.findElements(By.tagName("a"));
            Actions actions = new Actions(getDriver());
            for(int i=0; i<anchors.size(); i++) {
                WebElement img = anchors.get(i).findElement(By.tagName("img"));
                if(img.getAttribute("title").equalsIgnoreCase(manufacturer)) {
                    actions.moveToElement(anchors.get(i)).click().build().perform();
                    waitABit(2000);
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //waitABit(5000);
    }


    public void selectCarModelByText(String model){
        //waitABit(2000);
        waitUntilPageCompletelyRender();
        List<WebElementFacade> anchors = element(MODEL_TABLE).thenFindAll(By.tagName("a"))
                .stream()
                .filter(c -> c.find(By.tagName("span")).getText().equalsIgnoreCase(model))
                .collect(Collectors.toList());
//        assertFalse("The model: "+model+" is unknown or more than one car model was found", anchors.size()!=1);
        anchors.get(0).click();
        waitABit(2000);
    }

    public void selectCarTypeByText(String carType){
        //waitABit(2000);
        waitUntilPageCompletelyRender();
        List<WebElementFacade> anchors = findAll(VEHICLE_ROWS)
                .stream()
                .filter(c -> c.findElements(By.tagName("span")).get(1).getText().equalsIgnoreCase(carType))
                .collect(Collectors.toList());
        scrollToPosition(0,500);
        waitABit(750);
        assertFalse("The type: "+carType.toUpperCase()+" is unknown. Card Type " + anchors.get(0).getText().toUpperCase() + " was found", anchors.size()!=1); //TODO to be looking at by Fred to see if necessary to keep it
        anchors.get(0).click();
    }

    public void setCustomerType(String customerType) {
        //waitABit(3500);
        waitUntilPageCompletelyRender();
        WebElementFacade elementFacade = element(PRODUCT_TYPE);
        List<WebElement> anchors = elementFacade.findElements(By.tagName("div"))
                .stream()
                .filter(c -> c.findElement(By.tagName("span")).getText().equalsIgnoreCase(customerType))
                .collect(Collectors.toList());
        assertFalse("The product type: "+customerType+" is unknown", anchors.size()!=1);
        anchors.get(0).click();
        //waitABit(2000);
    }

    public void selectCarTypeAndTypeOfDoors(String carType, String typeOfDoors) {
        waitABit(2000);
        //waitUntilPageCompletelyRender();
        List<WebElementFacade> anchors = findAll(VEHICLE_ROWS)
                .stream()
                .filter(c -> c.findElements(By.tagName("span")).get(1).getText().equalsIgnoreCase(carType)
                        && c.findElement(By.cssSelector("[id$=vehicletypenrofdoors]")).getText().equalsIgnoreCase(typeOfDoors))
                .collect(Collectors.toList());
        //assertFalse("The type: "+carType.toUpperCase()+" is unknown. Card Type " + anchors.get(0).getText().toUpperCase() + " was found", anchors.size()!=1); //TODO to be looking at by Fred to see if necessary to keep it

        Actions actions = new Actions(getDriver());
        waitABit(1000);
        actions.moveToElement(anchors.get(0)).click().build().perform();
        //scrollToPosition(0,600);

        //anchors.get(0).click();
    }
}
