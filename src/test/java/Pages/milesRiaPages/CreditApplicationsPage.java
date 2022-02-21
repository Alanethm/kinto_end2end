package Pages.milesRiaPages;

import Pages.ReusableViewElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreditApplicationsPage extends ReusableViewElements {

    private final By Complete  = By.xpath("//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/16/worklist_complete.png')]");
    private final By OK  = By.xpath("//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/16/ok.png')]");

    public CreditApplicationsPage(WebDriver driver) {
        super(driver);
    }

    public void selectComplete() {
        waitABit(3000);
        element(Complete).click();
    }

    public void clickOnOK(){
        waitABit(3000);
        element(OK).click();
        waitABit(5000);
    }

    public void selectCompleteLTC() {
        waitABit(1500);
        findAll(Complete).get(1).click();
    }
}
