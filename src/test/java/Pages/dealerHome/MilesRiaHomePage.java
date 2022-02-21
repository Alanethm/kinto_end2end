package Pages.dealerHome;

import Components.MilesRiaTopHeaderComponent;
import Components.QuotationComponent;
import Pages.ReusableViewElements;
import org.openqa.selenium.WebDriver;

public class MilesRiaHomePage extends ReusableViewElements {

    public MilesRiaHomePage(WebDriver driver) {
        super(driver);
    }
    public MilesRiaTopHeaderComponent getMilesRiaTopHeaderComponent(){
        return new MilesRiaTopHeaderComponent(getDriver());
    }
    public QuotationComponent getQuotationComponent(){
        return new QuotationComponent(getDriver());}

    public void searchItem() {
    }
}
