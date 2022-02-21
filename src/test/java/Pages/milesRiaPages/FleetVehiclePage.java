package Pages.milesRiaPages;

import Pages.ReusableViewElements;
import Pages.milesRiaTabs.TopBarTabs;
import org.openqa.selenium.WebDriver;

public class FleetVehiclePage extends ReusableViewElements {
    public FleetVehiclePage(WebDriver driver) {
        super(driver);
    }

    public TopBarTabs getTopBarTabs(){
        return new TopBarTabs(getDriver());
    }

}
