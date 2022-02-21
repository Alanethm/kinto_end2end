package Components.quotesMR;

import Pages.ReusableViewElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PurchaseInvoiceMRComponent extends ReusableViewElements {
    public PurchaseInvoiceMRComponent(WebDriver driver) {
        super(driver);
    }

    private final String INVOICE_NUMBER = "//td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/input";
//    name="A1430"
    private final String NEXT_BUTTONS = "//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/24/status_next.png?')]";
    private final String VALIDATE = "//div/div[5]/div/div[2]/div/div[1]/div/div/div/table/tbody/tr/td";
    private final String ALLOCATE = "//div/div[5]/div/div[2]/div/div[2]/div/div/div/table/tbody/tr/td";
    private final String APPROVE = "//div/div[5]/div/div[2]/div/div[3]/div/div/div/table/tbody/tr/td";
    private final String POST = "//div/div[5]/div/div[2]/div/div[4]/div/div/div/table/tbody/tr/td";

    public void setInvoiceNumber(String invoiceNumber){
        waitABit(4000);
        By xpath = By.xpath(INVOICE_NUMBER);
        sendKeysAfterStaleness(xpath, false, invoiceNumber);
    }

    public void processValidate() {
        waitABit(1000);
        doValidate();
        doAllocate();
        doApprove();
        //post();
    }

    public void doValidate() {
        findAll(NEXT_BUTTONS).get(0).click();
        waitABit(2000);
    }
    public void doAllocate() {
        findAll(NEXT_BUTTONS).get(1).click();
        waitABit(2000);
    }
    public void doApprove() {
        findAll(NEXT_BUTTONS).get(1).click();
        waitABit(2000);
    }
    public void post(){
        findAll(POST).get(2).click();
    }

    public void setPaymentMethod(String paymentMethod) {

        waitABit(8000);
        By name = By.name("A122");
        scrollToElement(element(name));
        sendKeysAfterStaleness(name, false, paymentMethod);
        waitABit(1000);
    }
}
