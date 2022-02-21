package Components.sale;

import Pages.ReusableViewElements;
import Utils.constance.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.constance.Elements.KINTO_ONE;
import static Utils.constance.Elements.KINTO_ONE_DECALAGE;

public class ProductComponent extends ReusableViewElements {

    public final By KINTO_ONE_Button= By.id("quote:qtemplate3_0");
    public final By PRODUCT_LIST = By.id("quote:qtemplate3_label");
    public final By KINTO_ONE_DECALAGE_Button = By.id("quote:qtemplate3_1");
//    public final By Kinto_One_decalage = By.id("quote:qtemplate3_label");
    public ProductComponent(WebDriver driver) {
        super(driver);
    }

    public void setProduct(String product) {
        waitABit(1000);
        element(PRODUCT_LIST).click();
        if(product.equalsIgnoreCase(KINTO_ONE_DECALAGE.getName())){
            element(KINTO_ONE_DECALAGE_Button).click();
            waitABit(2000);
        }else if(product.equalsIgnoreCase(KINTO_ONE.getName())){
            element(KINTO_ONE_DECALAGE_Button).click();
            waitABit(2000);
            element(PRODUCT_LIST).click();
            element(KINTO_ONE_Button).click();
        }
        waitABit(2000);
    }
}
