package Components.quotesMR;

import Pages.ReusableViewElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VehicleMRComponent extends ReusableViewElements {
    public VehicleMRComponent(WebDriver driver) {
        super(driver);
    }

    private final String vehicleImg = "//img[contains(@src,'"+ currentProperties.getCurrentCountryIP() +"milesria/resource/skins/MRI/images/Sofico/24/order.png')]";
    private final String vehicleOrderLinks = "a.silkClickableLink";

    public void clickOnVehicle() {
        waitABit(5000);
        findAll(vehicleImg).get(0).click();
        waitABit(5000);
    }

    public void clickOnVehicleOrderByLink() {
        waitABit(5000);
        findAll(By.cssSelector(vehicleOrderLinks)).get(2).click();
        waitABit(5000);
    }
}
