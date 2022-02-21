package Pages.milesRiaTabs;

import Components.quotesMR.PurchaseInvoiceMRComponent;
import Pages.ReusableViewElements;
import org.openqa.selenium.WebDriver;

public class PurchaseInvoicesTab extends ReusableViewElements {
    public PurchaseInvoicesTab(WebDriver driver) {
        super(driver);
    }

    public PurchaseInvoiceMRComponent getPurchaseInvoiceMRComponent(){
        return new PurchaseInvoiceMRComponent(getDriver());
    }
}
