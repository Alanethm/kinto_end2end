package e2eTests.cukeStepDefinitions.milesWeb.sale;


import Pages.sale.SalePage;
import e2eTests.stepdefinitions.SalePageSteps;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SalePageCucumberSteps {

    @Steps
    SalePageSteps salePageSteps;

    SalePage salePage;

    @When("he selects a vehicle {string}")
    public void he_selects_a_vehicle(String manufacturer) {
//        salePageSteps.openMakeSelectionBox(); //Only use if the box is not activated
        salePageSteps.selectCarManufacturer(manufacturer);

    }

    @And("he selects a model {string}")
    public void he_selects_a_model(String model) {
        salePageSteps.selectCarModel(model);
    }

    @And("he selects the type {string}")
    public void he_selects_the_type(String type) {
        salePageSteps.selectCarType(type);
    }

    @And("he goes to the next page")
    public void he_go_to_the_next_page() {
        salePageSteps.clickOnNext();
    }

    @Then("he can select vehicle options")
    public void he_can_select_vehicle_options() {
        salePageSteps.optionsTabIsInFocus();
    }

    @Then("he chooses color {string} and upholstery {string}")
    public void he_chooses_color_and_upholstery(String colorName, String upholstery) {
        salePageSteps.setUpholstery(upholstery);
        salePageSteps.setCarColor(colorName);
    }

    @And("he selects an option from popUp Menu")
    public void he_selects_an_option() {
        salePageSteps.selectsOptionFromPopUp();
    }

    @And("he selects an option {string}")
    public void selectsOptionFromPopUp(String option) {
        salePageSteps.setOption(option);
    }

    @And("he selects the option pack {string}")
    public void selectOptionPack(String optionPack) {
        salePageSteps.selectOptionPack(optionPack);
    }

    @And("he selects the accessories {string}")
    public void setAccessories(String accessory) {
        salePageSteps.setAccessories(accessory);
    }

    @Then("he can create a new customer")
    public void gotToNewCustomerMenu() {
        salePageSteps.gotToNewCustomerMenu();
    }

    @Deprecated
    @Then("he searches the sole trader by name {string}")
    public void searchSoleTrader(String name) {
        salePageSteps.searchCustomerByName(name);
        salePageSteps.switchToSoleTrader();
        salePageSteps.selectCustomer(true);
    }

    @Deprecated
    @Then("he searches the Organization by name {string}")
    public void searchOrganization(String name) {
        salePageSteps.searchCustomerByName(name);
        salePageSteps.switchToOrganizationSearch();
        salePageSteps.selectCustomer(true);
    }



    @Deprecated
    @Then("he search the private customer by name {string}")
    public void searchPrivateCustomer(String name) {
        salePageSteps.searchCustomerByName(name);
        salePageSteps.setLegalEntityToPrivate();
        salePageSteps.selectCustomer(true);
    }

    @Then("he accepts the prospect agreement {string}, {string},{string}")
    public void he_accepts_the_prospect_agreement(String gdpr1, String gdpr2, String gdpr3) {
        salePageSteps.acceptProspectAgreement(gdpr1, gdpr2,gdpr3);

    }

    @When("he selects the pending quotes menu")
    public void he_select_The_Pending_Quotes_Menu() {
//        salePageSteps.clickOnTheBurgerMenu();
        salePageSteps.clickOnSale();
        salePageSteps.clickOnPendingQuotations();
    }

    @Then("he can duplicate a quote")
    public void he_can_duplicate_a_quote() {
        salePageSteps.selectQuote();//TODO maybe selects a distinct quote important if the tests are running in parallel
        salePageSteps.openQuoteActionsMenu();
        salePageSteps.copyQuote();
    }

    @And("he updates the duration {int}")
    public void he_Updates_The_Duration(int duration) {
        salePageSteps.setDuration(duration);
    }

    @And("he selects the duration {int}")
    public void heSelectsTheDurationDuration(int duration) {
        salePage.getFinancesServicesComponent().selectDuration(duration);
    }

    @And("he selects the distance {int}")
    public void heSelectsTheDistance(int distance) {
        salePage.getFinancesServicesComponent().selectDistance(distance);
    }

    @And("he updates the distance {int}")
    public void he_Updates_The_Distance(int distance) {
        salePageSteps.setDistance(distance);
    }

    @And("he selects the first {int} payment {string}")
    public void he_Selects_The_payment_method(int paymentIndex, String paymentName) {
        salePageSteps.selectPaymentMethod(paymentIndex, paymentName);
    }

    @And("he sets relief vehicle to {string}")
    public void he_Sets_Relief_Vehicle(String option) {
        salePageSteps.setReliefVehicle(option);
    }

    @And("he selects the tyre type {int} {string}")
    public void heSelectsTheTyreTypeFlexStandard(int tiresIndex, String tiresType) {
        salePageSteps.selectTireType(tiresIndex, tiresType);
    }

    @And("he adds at index {int} {string} tires")
    public void addTires(int index, String tiresNumber) {
        salePageSteps.addTires(index, Integer.parseInt(tiresNumber));
    }

    @Then("he calculates the quote")
    public void he_Calculates_The_Quote() {
        salePageSteps.calculateQuote();
    }

    @And("he saves it")
    public void saved_It() {
        salePageSteps.save();
    }

    @And("he logs out")
    public void logOut() {
        salePageSteps.topBarMenu();
//        salePageSteps.clickOnProfile();
        salePageSteps.clickOnLogOut();
    }

    @And("he gives a down payment of {string}")
    public void heGivesADownPaymentOfDownPayment(String payment) {
        salePage.getFinancesServicesComponent().setDownPayment(payment);
    }

    @And("he sets the insurance type {string}")
    public void heSetTheInsuranceTypeInsurance(String insurance) {
        salePage.getFinancesServicesComponent().setInsuranceType(insurance);
    }

    @And("he checks the lease price {string}")
    public void heCheckTheLeasePriceLeasePrice(String leasePrice) {
        salePage.getFinancesServicesComponent().checkLeasePrice(leasePrice);

    }

    @And("he checks the service price {string}")
    public void heCheckTheServicePriceServicePrice(String servicePrice) {
        salePage.getFinancesServicesComponent().checkServicePrice(servicePrice);
    }

    @And("he checks the total price {string}")
    public void heCheckTheTotalPriceTotalPrice(String totalPrice) {
        salePage.getFinancesServicesComponent().checkTotalPrice(totalPrice);
    }

    @And("he check the accessories price {string}")
    public void heCheckTheAccessoriesPriceAccessoriesPrice(String accPrice) {
        salePage.getFinancesServicesComponent().checkAccessoriesPrice(accPrice);
    }

    @And("he check the option price {string}")
    public void heCheckTheOptionPriceOptionPrice(String optionPrice) {
        salePage.getFinancesServicesComponent().checkOptionPrice(optionPrice);
    }

    @And("he check the option pack price {string}")
    public void heCheckTheOptionPackPriceOptionPackPrice(String packPrice) {
        salePage.getFinancesServicesComponent().checkPackPrice( packPrice);
    }

    @And("he accepts the Fuel card Eni {string}")
    public void heAcceptsTheFuelCardEni(String choice) {
        salePage.getFinancesServicesComponent().acceptFuelCardEni(choice);
    }

    @After
    public static void getFeatureFileNameFromScenarioId(io.cucumber.java.Scenario scenario) {
//        String featureName = "Feature ";
//        String rawFeatureName = scenario.getName();
//        System.out.println();
//        System.out.println("####");
//        System.out.println("####");
//        System.out.println("####");
//        System.out.println(rawFeatureName);
//        System.out.println("####");
//        System.out.println("####");
//        System.out.println("####");
    }  //TODO TO Remove

    @And("he accepts the Fuel Card Edenred {string}")
    public void heAcceptsTheFuelCardEdenRed(String choice) {
        salePage.getFinancesServicesComponent().acceptFuelCardEdenRed(choice);
    }

    @And("he checks the selected option price {string} {string}")
    public void heChecksTheSelectedOptionPrice(String optionName, String expectedVATPrice) {
        salePage.getFinancesServicesComponent().checkPrice(optionName, expectedVATPrice);
    }

    @And("he sets the product to {string}")
    public void heSetsTheProductType(String product) {
        salePage.getProductComponent().setProduct(product);
    }

    @Then("he sends the credit request")
    public void heSendTheCreditRequest() {
        salePage.getFinancesServicesComponent().clickOnCreditRequest();
    }

    @And("he sets the number of vehicle to {int}")
    public void heSetsTheNumberOfVehicleTo(int number) {
        salePage.getFinancesServicesComponent().setVehicleNumber(number);
    }

    @And("he prints the document")
    public void hePrintsTheDocument() {
        salePage.getFinancesServicesComponent().clickOnPrint();
    }

    @Then("he accepts the prospect agreement")
    public void heAcceptsTheProspectAgreement() {
        salePageSteps.acceptProspectAgreement();
    }

    @Then("he accepts all prospect agreement")
    public void heAcceptsAllProspectAgreement() {
        salePage.getCustomerComponent().selectAllProspectAgreement(5);
    }

    @Then("he sets the customer as {string}")
    public void heSetsTheCustomerAsPrivate(String customerType) {
        salePageSteps.selectCustomerType(customerType);
    }

    /*@And("he adds the service {string} {string}")
    public void addService(String serviceName, String value) {
        salePage.getFinancesServicesComponent().addService(serviceName, value);
    }*/

    @And("he clicks on the financial summary panel")
    public void heClosesTheFinancialSummaryPanel() {
        salePage.getFinancesServicesComponent().closeSummaryPanel();
    }

    @And("he clicks on the vehicle panel")
    public void heClosesTheVehiclePanel() {
        salePage.getFinancesServicesComponent().closeVehiclePanel();
    }

    @And("he clicks on option tab")
    public void heClicksOnOption() {
        salePage.clickOnOptionTab();
    }

    @And("he clicks on Finance tab")
    public void heClicksOnFinanceServicesTab() {
        salePage.clickOnFinanceTab();
    }

    @And("he scrolls down")
    public void heScrollsDown() {
        salePage.scrollToPosition(0,500);
    }

    @And("he scrolls up")
    public void heScrollsUp() {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        salePage.scrollToPosition(0,0);
    }

    @And("he scrolls down for credit request")
    public void heScrollsDownForCreditRequest() {
        salePage.scrollDownForCreditRequest();
    }

    @And("he selects the quotation template {string}")
    public void heSelectsTheQuotationTemplateQuotationTemplate(String template) {
        salePage.getFinancesServicesComponent().selectQuotationTemplate(template);
    }

    @Then("he accepts the prospect agreement from credit request")
    public void heAcceptsTheProspectAgreementFromCreditRequest() {
        salePage.getFinancesServicesComponent().acceptGDPRFromCreditRequest();
    }

    @And("he selects the type {string} and the type of doors {string}")
    public void heSelectsTheTypeCarTypeAndTheTypeOfDoorsTypeOfDoors(String carType, String typeOfDoors) {
        salePageSteps.selectCarTypeAndTypeOfDoors(carType, typeOfDoors);
    }

    @And("he selects an option {string} in the warning panel")
    public void heSelectsAnOptionOptionInTheWarningPanel(String option) {
        salePageSteps.selectsOptionInTheWarningPanel(option);
    }

    @And("he selects the customer by name {string} in the result List")
    public void heSearchesTheCustomerByNameCustomerNameInTheResultList(String customerName) {
        salePageSteps.selectCustomerInTheResultList(customerName);
    }

    @And("from the service {string} he chooses {string}")
    public void fromTheServiceServiceNameHeChoosesServiceChoice(String service, String serviceChoice) {
        salePage.getFinancesServicesComponent().chooseService(service, serviceChoice);
    }

    @And("he selects the customer type {string}")
    public void heSelectsTheCustomerType(String customerType) {
        salePage.getCustomerComponent().selectCustomerTypeWhenCreateNewAccount(customerType);
    }

    @And("he chooses the General TC {string}")
    public void heChoosesTheGeneralTC(String tc) {
        salePageSteps.chooseGeneralTC(tc);
    }

    @And("he clicks on credit request")
    public void heClicksOnCreditRequest() {
        salePage.getFinancesServicesComponent().clickOnSendCreditRequest();
    }

    @And("he submit")
    public void heSubmit() {
        salePage.getFinancesServicesComponent().submit();
    }

    @Then("he copy the quote")
    public void heCopyTheQuote() {
        salePage.getFinancesServicesComponent().copy();
    }

    @And("he selects a professional activity {string}")
    public void heSelectsAProfessionalActivityCoachbuilder(String activity) {
        salePage.selectActivity(activity);
    }

}
