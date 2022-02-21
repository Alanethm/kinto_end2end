package e2eTests.cukeStepDefinitions.milesWeb.sale;

import Pages.sale.SalePage;
import Utils.CurrentProperties;
import e2eTests.stepdefinitions.SalePageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class CustomerSteps {


    @Steps
    SalePageSteps salePageSteps;

    SalePage salePage;

    @Then("he searches the customer by name {string}")
    public void he_Search_The_Customer_By_Name(String customerName){
        salePageSteps.searchCustomerByName(customerName);
    }

    @And("he selects the customer as {string}")
    public void heSelectsTheCustomer(String customerType) {
       // salePage.getCustomerComponent().selectCustomerTypInSearchCriteria(customerType);
        if(customerType.equalsIgnoreCase("Organization")){
            salePageSteps.selectCustomer(true);
        }else if(customerType.equalsIgnoreCase("Sole Trader")){
            salePageSteps.switchToSoleTrader();
            salePageSteps.selectCustomer(false);
        }else {
            Assert.assertFalse("Customer: "+customerType+" type is not implemented", true);
        }
    }

    @And("he switches to organization tab")
    public void heSwitchesToOrganizationTab() {
        salePageSteps.switchToOrganizationSearch();
    }
}
