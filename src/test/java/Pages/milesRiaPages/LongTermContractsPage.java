package Pages.milesRiaPages;

import Components.quotesMR.VehicleMRComponent;
import Components.quotesMR.VehicleUsagesMRComponent;
import Pages.ReusableViewElements;
import Pages.milesRiaTabs.TopBarTabs;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class LongTermContractsPage extends ReusableViewElements {

    private final By Calculate = By.xpath("//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/16/calculate.png')]");
    private final String ActionIcon = "//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/16/action.png')]";
    private final String OK = "//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/16/ok.png')]";
    private final By DiSTANCE = By.name("A1339");
    private final String DELIVER = "//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/16/action.png')]";
    private final By CONTRACT_INITIATION = By.id("grid_WorkList_Activities_Tree_2_valueCell0");
    private final By CONTRACT_INITIATION_FR = By.id("grid_WorkList_Activities_Tree_3_valueCell0");
    private final By NEW_DOCUMENT = By.xpath("//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/24/document.png')]");
    private final By CLOSE = By.className("buttonRounded");
    private final String location_text_Italy = "Via Verdi  1\n" +
            "20018 SEDRIANO\n" +
            "MILANO Italy";
    private final String location_text_France= "8 rue de la liberté\n" +
            "95000 CERGY ";
    private final By REQUESTED_LOCATION =  By.name("A2725");
    private final By Vehicle_Receipt_By = By.name("R678");
    private final By Status = By.name("A953");
    private final String DOCUMENT_START = "grid_DocumentTemplate_1_valueCell"; //1 - 9
    private final By NEXT = By.xpath("//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/24/right.png')]");
    private final By SEND_EMAIL = By.xpath("//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/16/send.png')]");
    private final By BACK = By.xpath("//img[contains(@src,'"+currentProperties.getCurrentCountryIP()+"milesria/resource/skins/MRI/images/Sofico/16/left.png')] ");

    public VehicleMRComponent getVehicleMRComponent(){
        return new VehicleMRComponent(getDriver());
    }
    public TopBarTabs getTopBarTabs(){
        return new TopBarTabs(getDriver());
    }
    public LongTermContractsPage(WebDriver driver) {
        super(driver);
    }
    public VehicleUsagesMRComponent getVehicleUsagesMRComponent(){
        return new VehicleUsagesMRComponent(getDriver());
    }

    public void clickOnCalculate() {
        waitABit(1000);
        element(Calculate).click();
        waitABit(8000);
    }

    public void selectTheDelivery(String delivery) { //TODO implement  delivery choice the default is Express
        waitABit(1000);
        element(OK).click();
        waitABit(1000);
        waitABit(1000);
    }

    public void clickOnDelivery() {
        waitABit(7000);
        findAll(ActionIcon).get(15).click();
        waitABit(1000);
    }

    public void setDistance(String distance) {
        waitABit(2000);
        sendKeysAfterStaleness(DiSTANCE, false, distance);
    }

    public void clickOnDeliver(){
        waitABit(2000);
        //setRequestLocation();
        //if (currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
         //   setVehicleReceipt("Bernardo, Jean Luc");
        //} else {
        //    setVehicleReceipt("Matteucci, Simone");
        //}
        waitABit(5000);
        int size = findAll(DELIVER).size();
        if(currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            findAll(DELIVER).get(19).click();
        }else{
            findAll(DELIVER).get(7).click();
        }
        waitABit(3000);
        //element(OK).click();
        waitABit(10000);
    }

    public void clickOnContractInitiation() {
        waitABit(2000);
        if(currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            element(CONTRACT_INITIATION_FR).click();
            waitABit(2000);
            return;
        }
        element(CONTRACT_INITIATION).click();
        waitABit(2000);
    }

    public void clickOnReevaluate() {
        List<WebElementFacade> skinlessButtons = findAll(By.className("skinlessButton"));
        skinlessButtons.get(4).click();
        waitABit(3000);

        //close Tab
        List<WebElementFacade> closeButton = findAll(CLOSE);
        closeButton.get(0).click();
        waitABit(1000);
    }

    public void setRequestLocation(){
        if (currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            sendKeysAfterStaleness(REQUESTED_LOCATION, true, location_text_France);
        }else if (currentProperties.getCurrentCountry().equalsIgnoreCase("Italy")){
            sendKeysAfterStaleness(REQUESTED_LOCATION, true, location_text_Italy);
        }
        waitABit(1000);
    }

    public void setVehicleReceipt(String name){
        sendKeysAfterStaleness(Vehicle_Receipt_By, false, name);
        waitABit(1000);
    }

    public void checkStatus(String expectedStatus) {
        waitABit(4000);
        String  actualStatus= element(Status).getAttribute("value");
        Assert.assertEquals("Status do not match", expectedStatus.toLowerCase(), actualStatus.toLowerCase());
    }

    public void openNewDocument() {
        waitABit(1000);
        element(NEW_DOCUMENT).click();
    }

    public void selectDocument(String docName) {
        element(By.xpath("//*[contains(text(),'"+docName+"')]")).click();
    }

    public void goToNextStep() {
        waitABit(500);
        element(NEXT).click();
        waitABit(3000);
    }

    public void clearAndSetEmailField(String email) {
        waitABit(3000);
        Actions action = new Actions(getDriver());
        action.sendKeys(Keys.TAB).build().perform();
        waitABit(500);
        action.sendKeys(Keys.BACK_SPACE).build().perform();
//        element(By.className("silkMultipleValue_closeButton")).click();
        waitABit(500);
        element(By.cssSelector("[id^='id__toLinks_'] > div:nth-child(2) > input")).sendKeys(email);
    }

    public void sendEmail() {
        waitABit(1000);
        element(SEND_EMAIL).click();
        waitABit(15000);
    }

    public void sendEmailWithoutClearing(String email) {
        waitABit(3000);
        element(By.cssSelector("[id^='id__toLinks_'] > div:nth-child(2) > input")).sendKeys(email);
    }
}
