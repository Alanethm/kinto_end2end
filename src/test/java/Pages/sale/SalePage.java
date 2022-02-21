package Pages.sale;

import Components.header.TopBarComponent;
import Components.sale.FinancesServicesComponent;
import Components.sale.*;
import Pages.ReusableViewElements;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class SalePage extends ReusableViewElements {

    private final By PRINT_DOCUMENT = By.id("stips:printbtn");
    private final By ACTIVITY_CB = By.id("quote:qTemplateId:1");

    public VehicleComponent getVehicleComponent() { return new VehicleComponent(getDriver()); }
    public OptionsComponent getOptionsComponent(){
        return new OptionsComponent(getDriver());
    }
    public CustomerComponent getCustomerComponent(){ return new CustomerComponent(getDriver()); }
    public ProductComponent getProductComponent(){ return new ProductComponent(getDriver()); }
    public QuotationSearchComponent getQuotationSearchComponent() { return new QuotationSearchComponent(getDriver()); }
    public FinancesServicesComponent getFinancesServicesComponent(){ return new FinancesServicesComponent(getDriver()); }
    public TopBarComponent getTopBarComponent(){return new TopBarComponent(getDriver()); }


    public SalePage(WebDriver driver) {
        super(driver);
    }


    public void printDocument() {
        element(PRINT_DOCUMENT).click();
        waitABit(1000);
    }

    public void clickOnOptionTab() {
        // It quote:j_idt642:j_idt649
        element(By.id("quote:j_idt645:j_idt652")).click();
        waitABit(4000);
    }

    public void clickOnFinanceTab() {
        waitABit(2000);
        //quote:j_idt529:j_idt536
        element(By.id("quote:j_idt532:j_idt539")).click();
        waitABit(4000);
    }

    public void scrollDownForCreditRequest() {
        waitABit(3000);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_MINUS);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_MINUS);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_ADD);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_ADD);
            robot.delay(1000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        scrollToPosition(0, 500);
    }

    public void chooseGeneralTc(String tc) {
        WebElement dropdown_tc = element(By.id("quote:retailfinanceSummary:finance_basedonlut_generalTC"));
        dropdown_tc.click();
        waitABit(2000);
        List<WebElement> lis = element(By.id("quote:retailfinanceSummary:finance_basedonlut_generalTC_panel")).findElements(By.tagName("li"));

        for(int i=0; i< lis.size(); i++) {
            if(lis.get(i).getText().equalsIgnoreCase(tc)){
                lis.get(i).click();
                waitABit(2000);
                return;
            }
        }
    }

    public void selectActivity(String activity) {
        waitABit(2000);
        switch (activity){
            case "coachbuilder" : element(By.cssSelector("#quote\\:qTemplateId > div:nth-child(2) > span")).click();
            waitABit(2000);
                break;
            default:
                Assert.fail(activity + " is unknown");
        }
    }
}
