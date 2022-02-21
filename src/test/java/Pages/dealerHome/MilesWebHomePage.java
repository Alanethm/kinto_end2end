package Pages.dealerHome;

import Components.QuotationComponent;
import Pages.ReusableViewElements;
import org.openqa.selenium.WebDriver;

public class MilesWebHomePage extends ReusableViewElements {

    public QuotationComponent getQuotationComponent(){
        return new QuotationComponent(getDriver());}

    public MilesWebHomePage(WebDriver driver) {
        super(driver);
    }
}
