package e2eTests.stepdefinitions.milesRia;

import Pages.home.HomePage;
import Pages.milesRiaPages.LongTermContractsPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class LongTermContractsMRSteps {

    LongTermContractsPage longTermContractsPage;
    HomePage homePage;

    @Step("The dealer click on vehicle")
    public void clickOnVehicle() {
        longTermContractsPage.getVehicleMRComponent().clickOnVehicle();
    }

    @Step("The dealer go to the Long terms contract tab")
    public void openMRTab() {
        homePage.openMRTabPerIndex(2);
    }

    @Step("The dealer Open the vehicle")
    public void openVehicle() {
        longTermContractsPage.getTopBarTabs().clickOnOpenVehicle();
    }
    @Step("The dealer Open the vehicle")
    public void openVehicleOrder() {
        longTermContractsPage.getTopBarTabs().clickOnVehicleOrder();
    }

    @Step("The dealer open the vehicle usage menu")
    public void clickOnVehicleUsages() {
        longTermContractsPage.getVehicleUsagesMRComponent().clickOnVehicleUsages();
    }

    @Step("The dealer open the registration document")
    public void clickOnRegistrationAndDocuments() {
        longTermContractsPage.getVehicleUsagesMRComponent().clickOnRegistrationAndDocuments();
    }

    @Step("The dealer set the registration number")
    public void registeredLicencePlate() {
        longTermContractsPage.getVehicleUsagesMRComponent().registeredLicencePlate();
    }

    @Step("The dealer set the registration date")
    public void setRegistrationDate(String futureDate) {
        longTermContractsPage.getVehicleUsagesMRComponent().setRegistrationDate(futureDate);
    }

    @Step("The dealer set the chassis Number as {0}")
    public void setVINNr(String vinNr) {
        longTermContractsPage.getVehicleUsagesMRComponent().setVINNr(vinNr);
    }

    @Step("The dealer click on calculate")
    public void clickOnCalculate() {
        longTermContractsPage.clickOnCalculate();
    }

    @Step("The dealer selects {0} as delivery")
    public void selectTheDelivery(String delivery) {
        longTermContractsPage.selectTheDelivery(delivery);
    }

    @Step("The dealer click on delivery")
    public void clickOnDelivery() {
        longTermContractsPage.clickOnDelivery();
    }

    @Step("The dealer set the distance to: {0}")
    public void setDistance(String distance) {
        longTermContractsPage.setDistance(distance);
    }

    @Step("The dealer click on deliver")
    public void clickOnDeliver() {
        longTermContractsPage.clickOnDeliver();
    }

    public void clickOnContractInitiation() {
        longTermContractsPage.clickOnContractInitiation();
    }

    public void reevaluatesContractAndCloseTheTab() {
        longTermContractsPage.clickOnReevaluate();
    }

    public void clickOnVehicleOrderByLink() {
        longTermContractsPage.getVehicleMRComponent().clickOnVehicleOrderByLink();
    }

    public void checkTheStatus(String status) {
        longTermContractsPage.checkStatus(status);
    }

    public void openNewDocument() {
        longTermContractsPage.openNewDocument();
    }

    public void goToNextStep() {
        longTermContractsPage.goToNextStep();
    }

    public void selectDocument(String docName) {
        longTermContractsPage.selectDocument(docName);
    }


    public void clearAndSetEmailField(String email) {
        longTermContractsPage.clearAndSetEmailField(email);
    }

    public void sendEmail() {
        longTermContractsPage.sendEmail();
    }

    public void sendEmailWithoutClearing(String email) {
        longTermContractsPage.sendEmailWithoutClearing(email);
    }

    public void openLTCTab(String tabName) {
        longTermContractsPage.openMRTabPerName(tabName);
    }
}
