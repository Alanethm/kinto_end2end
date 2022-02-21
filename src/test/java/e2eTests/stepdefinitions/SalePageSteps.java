package e2eTests.stepdefinitions;

import Pages.sale.SalePage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class SalePageSteps {

    SalePage salePage;

    @Step("The dealer select the vehicle manufacturer: {0}")
    public void selectCarManufacturer(String manufacturer) {
        salePage.getVehicleComponent().selectCarManufacturer(manufacturer);
    }

    @Step("The dealer selects '{0}' as model")
    public void selectCarModel(String model) {
        salePage.getVehicleComponent().selectCarModelByText(model);
    }

    @Step("The dealer selects '{0}' as type")
    public void selectCarType(String type) { salePage.getVehicleComponent().selectCarTypeByText(type);
    }

    @Step("The dealer clicks on next")
    public void clickOnNext() {
        salePage.clickOnNext();
    }

    @Step("The dealer selects the car color: {0}")
    public void setCarColor(String colorName) {
        salePage.getOptionsComponent().setCarColorByText(colorName);
    }

    @Step("The dealer selects the car upholstery: {0}")
    public void setUpholstery(String upholstery) {
        salePage.getOptionsComponent().setCarUpholsteryByText(upholstery);
    }

    public void selectOptionPack(String optionPack) {
        salePage.getOptionsComponent().selectOptionPackByText(optionPack);
    }

    public void setAccessories(String accessory) {
        salePage.getOptionsComponent().setAccessoriesByText(accessory);
    }

    @Step("The dealer validates the option: {0} from pop menu")
    public void selectsOptionFromPopUp() {
        salePage.getOptionsComponent().selectsOptionFromPopUp();
    }

    @Step("The dealer selects the option: {0}")
    public void setOption(String option) {
        salePage.getOptionsComponent().setOptionByText(option);
    }

    @Step("The dealer set the customer name: {0} into the search field and click on search ")
    public void searchCustomerByName(String customerName) {
        salePage.getCustomerComponent().searchCustomerByName(customerName);
    }

    @Step("The dealer switch to organization search menu")
    public void switchToOrganizationSearch(){
        salePage.getCustomerComponent().switchToOrganizationSearch();
    }

    @Step("The dealer select a customer")
    public void selectCustomer(boolean makeSwitch){
        salePage.getCustomerComponent().selectCustomer(makeSwitch);
    }

    public void acceptProspectAgreement(String ... agreements) {
        salePage.getCustomerComponent().acceptProspectAgreement(agreements);
    }

    @Step("The dealer click on the burger menu Kinto one")
    public void clickOnTheBurgerMenu() {
        salePage.getTopBarComponent().clickOnTheBurgerMenu();
    }

    @Step("The dealer click on sale button")
    public void clickOnSale() {
        salePage.getTopBarComponent().clickOnSale();
    }

    @Step("The dealer click on pending quotation")
    public void clickOnPendingQuotations() {
        salePage.getTopBarComponent().clickOnPendingQuotations();
    }

    @Step("The dealer select the quote to duplicate")
    public void selectQuote() {
        salePage.getQuotationSearchComponent().selectQuote();
    }

    @Step("The dealer open the quote action menu")
    public void openQuoteActionsMenu() {
        salePage.getQuotationSearchComponent().openQuoteActionsMenu();
    }

    @Step("The dealer click on copy")
    public void copyQuote() {
        salePage.getQuotationSearchComponent().copyQuote();
    }

    @Step("The dealer update the duration to {0} ")
    public void setDuration(int duration) {
        salePage.getFinancesServicesComponent().setDuration(duration);
    }

    @Step("The dealer update the distance to {0} ")
    public void setDistance(int distance) {
        salePage.getFinancesServicesComponent().setDistance(distance);
    }

    @Step("The dealer select the payment method: {1}")
    public void selectPaymentMethod(int paymentIndex, String paymentName) {
        salePage.getFinancesServicesComponent().selectPaymentMethod(paymentIndex, paymentName);
    }

    @Step("The dealer set the relief vehicle to: {0}")
    public void setReliefVehicle(String option) {
        if(option.equalsIgnoreCase("yes")){
            salePage.getFinancesServicesComponent().setReliefVehicle(true);
        }else {
            salePage.getFinancesServicesComponent().setReliefVehicle(false);
        }
    }

    @Step("The dealer selects the tires type {1}")
    public void selectTireType(int tiresIndex, String tiresType) {
        salePage.getFinancesServicesComponent().selectTires(tiresIndex, tiresType);
    }

    @Step("The dealer adds {1} tires")
    public void addTires(int index, int tiresNumber) {
        salePage.getFinancesServicesComponent().setTiresNumber(index, tiresNumber);
    }

    @Step("The dealer calculates the quote")
    public void calculateQuote() {
        salePage.getFinancesServicesComponent().quoteCalculation();
    }

    @Step("the dealer saved it")
    public void save() {
        salePage.getFinancesServicesComponent().saveQuote();
    }

    @Step("The dealer expects: {0} as total price")
    public void checkTotalPrice(String totalPrice) {
        String expectedPrice = salePage.getFinancesServicesComponent().getTotalPrice();
        assertThat(totalPrice, is(expectedPrice)); //TODO refactor put total price
    }

    @Step("The dealer click on topBar menu")
    public void topBarMenu() {
        salePage.getTopBarComponent().openTopBar();
    }

    @Step("The dealer click On profile")
    public void clickOnProfile() {
        salePage.getTopBarComponent().clickOnProfile();
    }

    @Step("The dealer click On logOut")
    public void clickOnLogOut() {
        salePage.getTopBarComponent().clickOnLogOut();
    }

    @Step("The dealer click on ne customer")
    public void gotToNewCustomerMenu() {
        salePage.getCustomerComponent().clickOnNewCustomer();
    }

    public void selectCustomerType(String customerType) {
        salePage.getVehicleComponent().setCustomerType(customerType);
    }

    public void switchToSoleTrader() {
        salePage.getCustomerComponent().switchToSoleTraderSearch();
    }

    public void selectIndividual() {
        salePage.getCustomerComponent().selectIndividual();
    }

    public void setLegalEntityToPrivate() {
        salePage.getCustomerComponent().setLegalEntityToPrivate();
    }

    public void optionsTabIsInFocus() {
        String tabName = salePage.getOptionsComponent().getActiveTabName();
        assertFalse("Table in Focus should be 2.Options but active table is "+ tabName  , !tabName.equalsIgnoreCase("2.Options"));
    }

    @Step("The dealer selects '{0}' as type and {1} as type of doors")
    public void selectCarTypeAndTypeOfDoors(String carType, String typeOfDoors) {
        salePage.getVehicleComponent().selectCarTypeAndTypeOfDoors(carType,typeOfDoors);
    }

    @Step("The dealer selects the option: {0} in the warning panel")
    public void selectsOptionInTheWarningPanel(String option) {
        salePage.getOptionsComponent().selectOptionInWarningPanel(option);
    }

    @Step("The dealer select the customer: {0} in the result list.")
    public void selectCustomerInTheResultList(String CustomerName) {
        salePage.getCustomerComponent().selectCustomerInTheResultList(CustomerName);
    }

    public void chooseGeneralTC(String tc) {
        salePage.chooseGeneralTc(tc);
    }
}

