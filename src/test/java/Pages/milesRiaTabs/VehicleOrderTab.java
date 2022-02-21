package Pages.milesRiaTabs;

import Components.quotesMR.VehicleOrderInfComponent;
import Pages.ReusableViewElements;
import org.openqa.selenium.WebDriver;

public class VehicleOrderTab extends ReusableViewElements {

    public VehicleOrderInfComponent getVehicleOrderInfComponent(){
        return new VehicleOrderInfComponent(getDriver());
    }

    public VehicleOrderTab(WebDriver driver) {
        super(driver);
    }
}
