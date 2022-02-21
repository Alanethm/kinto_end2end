package Components.sale;

import Pages.ReusableViewElements;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


public class FinancesServicesComponent extends ReusableViewElements {

    private final String Delivery_Menu = "quote:retailfinance:dcc";
    private final String Delivery_Method = "quote:retailfinance:dcc_";
    private final String Relief_Vehicle_Field = "quote:retailfinance:lsc:1:pcs";
    private final By Relief_Vehicle_Yes_Choice = By.id("quote:retailfinance:lsc:1:pcs_1");
    private final By Relief_Vehicle_No_Choice = By.id("quote:retailfinance:lsc:1:pcs_0");
    private final String Tires_Vehicle_Field = "quote:retailfinance:lsc:3:pcs";
    private final String Tires_Type = "quote:retailfinance:lsc:3:pcs_";
    private final String Tires_Number_Input_Field_Start = "quote:retailfinance:lsc:3:qr:";
    private final String Tires_Number_Input_Field_End =":qinputs";
    private final String Calculate_Button = "quote:retailfinanceSummary:update";
    private final String Save_Quote = "quote:retailfinanceSummary:save";
    private final String TotalPrice_Value = "quote:retailfinanceSummary:pricewithfuelexclvat";
    private final By DOWN_PAYMENT = By.id("quote:retailfinanceSummary:upfront");
    private final By DOWN_PAYMENT_FR = By.id("quote:retailfinanceSummary:firsthigherpaymentinclvat");
    private final By DURATION  = By.id("quote:retailfinance:inputFinanceRetailDurationDistance:months");
    private final By DISTANCE  = By.id("quote:retailfinance:inputFinanceRetailDurationDistance:kms");
    private final By INSURANCE_LABEL = By.id("quote:retailfinance:lsc:9:pcs_label");
    private final By FUEL_CARD_ENI_LABEL = By.id("quote:retailfinance:lsc:8:pcs");
    private final By FUEL_CARD_ENI_YES = By.id("quote:retailfinance:lsc:8:pcs_0");
    private final By FUEL_CARD_EDENRED_LABEL = By.id("quote:retailfinance:lsc:11:pcs");
    private final By FUEL_CARD_EDENRED_YES = By.id("quote:retailfinance:lsc:11:pcs_0");
    private final By INSURANCE_TYPE1 = By.id("quote:retailfinance:lsc:9:pcs_0");
    private final By INSURANCE_TYPE2 = By.id("quote:retailfinance:lsc:9:pcs_1");
    private final By VAT_LEASE_PRICE = By.id("quote:retailfinanceSummary:leasepricevat");
    private final By VAT_SERVICE_PRICE = By.id("quote:retailfinanceSummary:servicesleasepricevat");
    private final By VAT_TOTAL_PRICE = By.id("quote:retailfinanceSummary:pricewithfuel");
    private final By SELECTIONS_TABLE = By.id("quote:selopt:tbody_element");
    private final By CREDIT_REQUEST = By.id("quote:retailfinanceSummary:order");
    private final By SEND_CREDIT_REQUEST = By.id("orderQuote:quote:j_idt772");
    private final By VEHICLE_NUMBER = By.id("quote:retailfinanceSummary:nr_of_vehicles_input");
    private final By SUBMIT = By.id("prospectdetail:submitbtn");
    private final By SUBMIT_2 = By.id("prospectdetail:submit-confirmButton");
    private final By COPY = By.id("quote:retailfinanceSummary:copy");

    public FinancesServicesComponent(WebDriver driver) {
        super(driver);
    }

    public void setDuration(int duration){
        waitUntilPageCompletelyRender();
        Actions actions = new Actions(getDriver());
        element(DURATION).click();
        waitABit(200);
        actions.doubleClick (element(DURATION)).perform();
        actions.sendKeys(String.valueOf(duration));
        actions.build().perform();

        waitABit(200);
        element(By.id("quote:tabView:tab1")).click();
    }

    public void setDistance(int distance){
        waitUntilPageCompletelyRender();
        //waitABit(2000);
        Actions actions = new Actions(getDriver());
        element(DISTANCE).click();
        waitABit(200);
        actions.doubleClick (element(DISTANCE)).perform();
        actions.sendKeys(String.valueOf(distance));
        actions.build().perform();
        element(By.id("quote:tabView:tab1")).click();
    }

    //TODO find a way to check the payment name
    public void selectPaymentMethod(int paymentIndex, String paymentName) {
        element(By.id(Delivery_Menu)).click();
        element(By.id(Delivery_Method +paymentIndex)).click();
        waitABit(2000);
        new Actions(getDriver()).sendKeys(Keys.ENTER).build().perform();
        waitABit(500);
    }

    /**
     *
     * @param choice 1 for true 0 for false
     */
    public void setReliefVehicle(boolean choice){
        waitABit(2000);
        element(By.id(Relief_Vehicle_Field)).click();
        if(choice){
            element(Relief_Vehicle_Yes_Choice).click();
        } else {
            element(Relief_Vehicle_No_Choice).click();
        }
        waitABit(2000);
    }

    //TODO find a way to check the Tires name
    public void selectTires(int tiresIndex, String tiresName){
        waitUntilPageCompletelyRender();
        element(By.id(Tires_Vehicle_Field)).click();
        element(By.id(Tires_Type+tiresIndex)).click();
    }

    public void setTiresNumber(int index, int tiresNumber){
        waitABit(2000);
        element(By.id(Tires_Number_Input_Field_Start+index+Tires_Number_Input_Field_End)).clear();
        element(By.id(Tires_Number_Input_Field_Start+index+Tires_Number_Input_Field_End)).sendKeys(String.valueOf(tiresNumber));
        element(By.id("quote:tabView:tab1")).click();

    }

    public void chooseService(String serviceName, String serviceChoice){
        waitUntilPageCompletelyRender();
        //waitABit(1000);
        String id ="";
        WebElementFacade element = element(By.id("quote:retailfinance:ps"));//Table
        List<WebElementFacade> table = element.thenFindAll(By.tagName("table"));
        for (int i = 1; i<table.size();i++) { // ignore the first element of the table
            List<WebElementFacade> trs = table.get(i).thenFindAll(By.tagName("tr"));
            for(WebElementFacade tr: trs) {
                String service = "";
                if(currentProperties.getCurrentCountry().equalsIgnoreCase("italy")){
                     service = "quote:retailfinance:lsc:" + (i-1) + ":j_idt3834";
                } else{
                    service = "quote:retailfinance:lsc:" + (i-1) + ":j_idt3223";
                }
                waitABit(3000);
                String td = tr.findElement(By.tagName("td")).findElement(By.id(service)).getText();
                if(td.equalsIgnoreCase(serviceName)){
                    waitABit(500);
                    String dropDownId = "quote:retailfinance:lsc:" + (i-1) + ":pcs";
                    element(By.id(dropDownId)).findElement(By.id("quote:retailfinance:lsc:" + (i-1) + ":pcs_label")).click();

                    waitABit(4000);
                    String dropDownValuesId = "quote:retailfinance:lsc:" + (i-1) + ":pcs_panel";
                    WebElementFacade choiceUl = element(By.id(dropDownValuesId));
                    List<WebElementFacade> choices = choiceUl.thenFindAll(By.cssSelector("[id*=pcs]"));
                    for(WebElementFacade li: choices){
                        String tit = li.getTextContent();
                        if(tit.equalsIgnoreCase(serviceChoice)){
                            waitABit(2000);
                            li.click();
                            waitABit(3000);
                            element(By.id("quote:tabView:tab1")).click();
                            return;
                        }
                    }
                    return;
                }

            }
        }
        fail("Unknown service or choice");
    }

    public void quoteCalculation(){
        waitUntilPageCompletelyRender();
       // waitABit(2000);
        if(currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
//            element(By.xpath("(//*[contains(text(), 'Calculate')]")).click();
            element(By.id(Calculate_Button)).click();
            //waitABit(3000);
            return;
        }
        scrollToPosition(0,0);
        element(By.id(Calculate_Button)).click();
       // waitABit(4000);
    }

    public void saveQuote(){
        waitUntilPageCompletelyRender();
        //waitABit(2000);
        element(By.id(Save_Quote)).click();
        waitUntilPageCompletelyRender();
        //waitABit(4000);
    }

    public String getTotalPrice(){
        String totalPrice = element(By.id(TotalPrice_Value)).getText();
        return totalPrice;
    }

    public void setDownPayment(String payment) {
       // waitABit(2000);
        waitUntilPageCompletelyRender();
        if(currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            element(DOWN_PAYMENT_FR).sendKeys(payment);
            //waitABit(2000);
            return;
        }
        element(DOWN_PAYMENT).sendKeys(payment);
    }

    public void setInsuranceType(String insuranceType){
       //waitABit(1000);
        waitUntilPageCompletelyRender();
        element(INSURANCE_LABEL).click();
        switch (insuranceType){
            case "Anti-Theft LoJack Abbonamento > 34 mesi": element(INSURANCE_TYPE2).click();
                break;
            case "Anti-Theft LoJack Abbonamento <= 34 mesi": element(INSURANCE_TYPE1).click();
                break;
            default: fail("Unknown insurance type found: "+insuranceType+" expected: Anti-Theft Lojack Abbonamento >34");
        }
        waitABit(500);
    }

    public void checkLeasePrice(String leasePrice) {
        waitABit(2000);
        waitUntilPageCompletelyRender();
        String price = element(By.id("quote:retailfinanceSummary:pricewithfuel")).getText();
        assertThat(price, is(leasePrice));
    }

    public void checkServicePrice(String servicePrice) {
        //waitABit(500);
//        replace("?","\u20ac")
        waitUntilPageCompletelyRender();
        String price = element(VAT_SERVICE_PRICE).getText();
        assertThat(price, is(servicePrice));
    }

    public void checkTotalPrice(String totalPrice) {
        //waitABit(500);
        waitUntilPageCompletelyRender();
        String price = element(VAT_TOTAL_PRICE).getText();
        assertThat(price, is(totalPrice));
        waitABit(500);
    }

    public void checkAccessoriesPrice(String accPrice) {
        String price= element("#quote\\:selopt\\:tbody_element > tr:nth-child(5) > td:nth-child(3) > span").getText();
        assertThat(price, is(accPrice));
    }

    public void checkOptionPrice(String optionPrice) {
        String price = element("#quote\\:selopt\\:tbody_element > tr:nth-child(3) > td:nth-child(3) > span").getText();
        assertThat(price, is(optionPrice));
    }

    public void checkPackPrice(String packPrice) {
        String price = element("#quote\\:selopt\\:tbody_element > tr:nth-child(4) > td:nth-child(3)").getText();
        assertThat(price, is(packPrice));
    }

    public void acceptFuelCardEni(String choice) {
        waitABit(500);
       // waitUntilPageCompletelyRender();
        element(FUEL_CARD_ENI_LABEL).click();
        switch (choice.toLowerCase()){
            case "yes": element(FUEL_CARD_ENI_YES).click();
                break;
            case "no":
                break;
            default: fail("Unknown choice: "+choice+ " choice should be yes or no");
        }
    }

    public void acceptFuelCardEdenRed(String choice) {
        waitABit(500);
        //waitUntilPageCompletelyRender();
        element(FUEL_CARD_EDENRED_LABEL).click();
        switch (choice.toLowerCase()){
            case "yes": element(FUEL_CARD_EDENRED_YES).click();
                break;
            case "no":
                break;
            default: fail("Unknown choice: "+choice+ " choice should be yes or no");
        }
    }

    public void checkPrice(String optionName, String expectedVATPrice) {
        waitABit(1500);
        //waitUntilPageCompletelyRender();
        List<WebElementFacade> anchors = element(SELECTIONS_TABLE).thenFindAll(By.tagName("tr"))
                .stream()
                .filter(a -> a.find(By.className("optionNameColumn")).getText().equalsIgnoreCase(optionName))
                .collect(Collectors.toList());
        String price = anchors.get(0).thenFindAll(By.className("optionPriceColumn")).get(1).getText();
        assertThat(price, is(expectedVATPrice));
        waitABit(2000);

    }

    public void clickOnCreditRequest() {
        waitABit(1000);
        element(CREDIT_REQUEST).click();
        waitABit(2000);
    }

    public void clickOnSendCreditRequest() {
        if(currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            element(By.id("orderQuote:quote:j_idt922")).click();
            waitABit(2000);
            return;
        }
        element(SEND_CREDIT_REQUEST).click();
        waitABit(2000);
    }

    public void setVehicleNumber(int number) {
        scrollToPosition(0,0);
        waitABit(3000);
        element(VEHICLE_NUMBER).clear();
        element(VEHICLE_NUMBER).sendKeys(String.valueOf(number));
        waitABit(500);
    }

    public void submit(){
        element(SUBMIT).click();
        waitABit(2000);
    }

    public void clickOnPrint() {
        element(By.id("stips:printbtn")).click();
        waitABit(1000);
        element(By.cssSelector("#printdocument > table > tbody > tr:nth-child(2) > td > div > a")).click();
        waitABit(100);
    }

    public void closeSummaryPanel() {
        waitABit(2000);
        element(By.cssSelector("#quote\\:retailfinanceSummary\\:rentalSummaryPanel > legend")).click();
    }

    public void closeVehiclePanel(){
        waitABit(1000);
        element(By.cssSelector("#quote\\:selectedVehiclePanel > legend")).click();
    }

    public void selectQuotationTemplate(String template) {// TODO refactor
        waitABit(1000);
        element(By.id("quote:retailfinanceSummary:finance_basedonlut_generalTC_label")).click();
        waitABit(500);
        if(template.toLowerCase().contains("kinto business")){
            element(By.id("quote:retailfinanceSummary:finance_basedonlut_generalTC_3")).click();
        }
    }

    public void acceptGDPRFromCreditRequest() {
        waitABit(2000);
        element(SUBMIT_2).click();
        waitABit(8500);
    }

    public void copy() {
        waitABit(500);
        element(COPY).click();
        waitABit(1000);
    }

    public void selectDuration(int duration) {
        waitABit(1000);
        element(By.id("quote:retailfinance:inputFinanceRetailDurationDistance:monthsList_label")).click();
        ListOfWebElementFacades all = findAll(By.cssSelector("[id^='quote:retailfinance:inputFinanceRetailDurationDistance:monthsList']"));
        for(WebElementFacade elm : all){
            if(elm.getText().equalsIgnoreCase(String.valueOf(duration))){
                elm.click();
            }
        }
        waitABit(500);
        new Actions(getDriver()).sendKeys(Keys.ENTER).build().perform();

    }

    public void selectDistance(int distance) {
        waitABit(1000);
        element(By.id("quote:retailfinance:inputFinanceRetailDurationDistance:kmsList_label")).click();
        ListOfWebElementFacades all = findAll(By.cssSelector("[id^='quote:retailfinance:inputFinanceRetailDurationDistance:kmsList']"));
        for(WebElementFacade elm : all){
            if(elm.getText().equalsIgnoreCase(String.valueOf(distance))){
                elm.click();
            }
        }
        waitABit(500);
        new Actions(getDriver()).sendKeys(Keys.ENTER).build().perform();
        waitABit(500);
    }
}
