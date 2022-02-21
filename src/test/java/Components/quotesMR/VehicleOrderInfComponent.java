package Components.quotesMR;

import Pages.ReusableViewElements;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jetbrains.annotations.NotNull;
import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VehicleOrderInfComponent extends ReusableViewElements {
    public VehicleOrderInfComponent(WebDriver driver) {
        super(driver);
    }

    private final By RequestedDeliveryDate = By.name("A2727");
    private final By EstimatedDeliveryDate = By.name("A1066");
    private final By ActualDeliveryDate = By.name("A1338");
    private final By Supplier = By.name("R692");
    private final By VehicleOrder = By.name("A1370");

    public void setRequestDeliveryDate(String deliveryDate) {
        sendKeysAfterStaleness(RequestedDeliveryDate, true,deliveryDate );
    }

    public void setEstimatedDeliveryDate(String deliveryDate) {
        sendKeysAfterStaleness(EstimatedDeliveryDate, true, deliveryDate );
    }

    public void setActualDeliveryDate(String deliveryDate) {
        sendKeysAfterStaleness(ActualDeliveryDate, true, deliveryDate );
    }

    public void setSupplier(String supplierName) {
        waitABit(1000);
        WebElementFacade elementFacade = findAll(Supplier).get(1);
        elementFacade.click();
        Actions action = new Actions(getDriver());
        action.sendKeys(supplierName).build().perform();
        action.sendKeys(Keys.DOWN).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
    }
}
