package Components.header;

import Pages.ReusableViewElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopBarComponent extends ReusableViewElements {

    private final String Top_Bar_Menu = "topbar-menu-button";
    private final String Burger_Menu = "menu-button";
    private final String SaleButton = "j_idt56_0";
    private final String Pending_Quotations = "j_idt56_0_0";
    private final String Profile_Button = "Profile";
    private final String Logout_Button = "//span[contains(.,'Log out')]";
    private final String customer = "j_idt53_3";
    private final String newCustomer = "j_idt53_3_1";

    public TopBarComponent(WebDriver driver) {
        super(driver);
    }

    public void clickOnTheBurgerMenu() {
        waitABit(2000);
        element(By.id(Burger_Menu)).click();
    }

    public void clickOnSale() {
        element(net.serenitybdd.core.annotations.findby.By.id(SaleButton)).click();
    }

    public void clickOnPendingQuotations() {
        element(By.id(Pending_Quotations)).click();
    }

    public void clickOnMenu_Customer(){
        waitABit(2000);
        element(By.id(customer)).click();
    }

    public void clickOnSubMenu_NewCustomer(){
        waitABit(2000);
        element(By.id(newCustomer)).click();
    }

    public void openTopBar(){
        waitABit(500);
        WebElement topBarRight = element(By.className("topbar-right"));
        topBarRight.findElement(By.className("fa-user")).click();
        waitABit(2000);
       // element("/html/body/div[1]/div[1]/div[2]/ul/li[2]/a/i").click();
 //       element(By.id(Top_Bar_Menu)).click();
    }

    public void clickOnProfile(){
        waitABit(500);
        element(By.linkText(Profile_Button)).click();
    }

    public void clickOnLogOut(){
        waitABit(1000);
        element(By.xpath(Logout_Button)).click();
    }
}
