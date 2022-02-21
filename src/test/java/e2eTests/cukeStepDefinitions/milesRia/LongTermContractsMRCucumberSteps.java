package e2eTests.cukeStepDefinitions.milesRia;

import Utils.constance.ContextMRMenu;
import Utils.constance.TabName;
import Utils.generatedTestData.TestData;
import Utils.generatedTestData.VinGeneratorUtils;
import e2eTests.stepdefinitions.milesRia.LongTermContractsMRSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;

import static Utils.constance.TabName.FLEET_VEHICLE;
import static Utils.constance.TabName.LONG_TERM_CONTRACTS;

public class LongTermContractsMRCucumberSteps extends TestData {

    @Steps
    LongTermContractsMRSteps longTermContractsMRSteps;

    @Then("he can see the generated long term contract")
    public void heCanSeeTheGeneratedLongTermContract() {
    }

    @And("he creates a vehicle Order")
    public void create_Vehicle_Order() {
        longTermContractsMRSteps.clickOnVehicle();
    }
    @And("he clicks on the vehicle order link")
    public void click_On_Vehicle_Order_Link() {
        longTermContractsMRSteps.clickOnVehicleOrderByLink();
    }

    @When("he opens the long term contract")
    public void heOpenTheLongTermContract() {
        longTermContractsMRSteps.openLTCTab(LONG_TERM_CONTRACTS.getTabName()); //TODO refactor creer un context Italy des le d?but des Tests
    }

    @Then("he selects the vehicle usage")
    public void heSelectTheVehicleUsage() {
        longTermContractsMRSteps.clickOnVehicleUsages();
    }

    @And("he registers the vehicle plates")
    public void heRegisteredTheVehiclePlates() {
        longTermContractsMRSteps.clickOnRegistrationAndDocuments();
        longTermContractsMRSteps.setVINNr(VinGeneratorUtils.getRandomVin());
        longTermContractsMRSteps.registeredLicencePlate();
        longTermContractsMRSteps.setRegistrationDate(getActualDate());
    }

    @And("he opens the vehicle")
    public void heOpenTheVehicle() {
        longTermContractsMRSteps.openVehicle();
    }

    @And("he calculates")
    public void heCalculate() {
        longTermContractsMRSteps.clickOnCalculate();
    }

    @And("he selects the {string} as delivery")
    public void heSelectTheExpressDeliveryAsDelivery(String delivery) {
        longTermContractsMRSteps.clickOnDelivery();
        longTermContractsMRSteps.selectTheDelivery(delivery); //TODO IMPLEMENT
    }

    @And("he sets the distance")
    public void heSetTheDistance() {
        longTermContractsMRSteps.setDistance(getDistance(1));
    }

    @Then("he delivers")
    public void heDeliver() {
        longTermContractsMRSteps.clickOnDeliver();
    }

    @Then("he opens the workflow and he selects the contract initiation")
    public void heOpensTheWorkflowAndHeSelectsTheContractInitiation() {
        longTermContractsMRSteps.clickOnContractInitiation();
    }
    @Then("he opens the workflow and he selects the contract Activation")
    public void heOpensTheWorkflowAndHeSelectsTheContractActivation() {
        longTermContractsMRSteps.clickOnContractInitiation();
    }

    @And("he reevaluates the contract and closes the tab")
    public void heReevaluatesTheContractAndCloseTheTab() {
        longTermContractsMRSteps.reevaluatesContractAndCloseTheTab();
    }

    @And("he checks the status {string}")
    public void heChecksTheStatus(String status) {
        longTermContractsMRSteps.checkTheStatus(status);
    }

    @Then("he creates a new document")
    public void heCreatesANewDocument() {
        longTermContractsMRSteps.openNewDocument();
    }

    @Then("he selects the document {string}")
    public void selectDocument(String docName) {
        longTermContractsMRSteps.selectDocument(docName);
    }

    @And("he goes to the next step")
    public void goToNextStep() {
        longTermContractsMRSteps.goToNextStep();
    }

    @And("he clears the email input field And sets the email Address To with :{string}")
    public void clearAndSetEmailAddress(String email) {
        longTermContractsMRSteps.clearAndSetEmailField(email);
    }

    @Then("he sends the email")
    public void heSendsTheEmail() {
        longTermContractsMRSteps.sendEmail();
    }

    @And("he sets the email Address To with: {string}")
    public void sendEmailWithoutClearing(String email) {
        longTermContractsMRSteps.sendEmailWithoutClearing(email);
    }

    @And("he opens the vehicle order")
    public void heOpenTheVehicleOrder() {
        longTermContractsMRSteps.openVehicleOrder();
    }
}
