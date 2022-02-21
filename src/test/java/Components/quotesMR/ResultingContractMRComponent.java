package Components.quotesMR;

import Pages.ReusableViewElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class ResultingContractMRComponent extends ReusableViewElements {

    private final By resultingContract = By.xpath("//div[@id='id_menu_2_valueCell8']/div");
    private final By contractId = By.cssSelector("a.silkClickableLink");
    private final By financial = By.xpath("//div[@id='id_menu_2_valueCell5']/div");
    private final By stipulation = By.xpath("//div[@id='id_menu_2_valueCell13']/div");
    private final By CA_Stipulation = By.id("id_menu_3_valueCell3");
    private final By activate = By.xpath("//img[contains(@src,'" + currentProperties.getCurrentCountryIP() + "milesria/resource/skins/MRI/images/Sofico/16/status_next.png?')]");
    private final By general = By.xpath("//div[@id='id_menu_3_valueCell0']/div");


    public ResultingContractMRComponent(WebDriver driver) {
        super(driver);
    }

    public void selectContract() {
        scrollToElement(element(resultingContract));
        waitABit(3500);
        element(resultingContract).click();
        waitABit(5000);
        element(contractId).click();
        waitABit(20000);
    }

    public void openFinancial(){
        waitABit(1500);
        if(currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            By financialFr = By.xpath("//div[@id='id_menu_4_valueCell5']/div");
            scrollToElement(element(financialFr));
            element(financialFr).click();
            waitABit(750);
            return;
        }
        scrollToElement(element(financial));
        element(financial).click();
        waitABit(750);
    }
    public void openStipulation(){
        By stipulationsFR = By.xpath("//div[@id='id_menu_3_valueCell14']/div");
        if(currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            scrollToElement(element(stipulationsFR));
            element(stipulationsFR).click();
            waitABit(3000);
            return;
        }
        scrollToElement(element(stipulation));
        element(stipulation).click();
        waitABit(3000);
    }

    public void openCAStipulation(){
        waitABit(1000);
        element(CA_Stipulation).click();
        waitABit(3000);
    }

    public void selectAllStipulation(){
        element(By.className("checkboxPartial")).click();
        waitABit(2000);
    }

    public void backToGeneral() {
        waitABit(1500);
        element(general).click();
        waitABit(1000);
    }

    public void clickOnLTCGeneral(){
        By general = By.xpath("//div[@id='id_menu_3_valueCell0']/div");
        waitABit(1500);
        scrollToElement(element(general));
        element(general).click();
        waitABit(1000);
    }

    public void activateStipulation() {
        waitABit(2000);
       findAll(activate).get(0).click();
        waitABit(3000);
    }

    public void openFinancialStipulation() {
        waitABit(2000);
        By stipulation = By.id("id_menu_4_valueCell14");
        scrollToElement(element(stipulation));
        element(stipulation).click();
        waitABit(750);
    }
}
