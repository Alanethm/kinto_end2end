package e2eTests.cukeStepDefinitions.milesWeb.customer;

import Pages.customer.CustomerPage;
import e2eTests.stepdefinitions.CustomerPageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SoleTraderCucumberSteps {
    CustomerPage customerPage;
    @Steps
    public CustomerPageSteps customerPageSteps;

    @When("navigate to sole trader {int}")
    public void navigateToSoleTraderPosition(Integer int2) { customerPageSteps.chooseTab(int2);

    }

    @And("he gives a sole trader name {string} in the company info form")
    public void heGivesASoleTraderNameTrader_nameInTheCompanyInfoForm( String name) {
        customerPageSteps.setTrader(name);
    }

    @And("he gives the name of street {string} in the contact data form")
    public void heGivesTheNameOfStreetStreet_nameInTheContactDataForm(String streetName) {
        customerPage.getSoleTraderComponent().setStreetName(streetName);
    }

    @And("he gives the trader street number {string} in the contact data form")
    public void heGivesTheTraderStreetNumberStreet_NrInTheContactDataForm(String streetNr) {
        customerPage.getSoleTraderComponent().setStreetNumber(streetNr);
    }

    @And("he gives the trader zip code {string} in the contact data form")
    public void heGivesTheTraderZipCodeZip_codeInTheContactDataForm(String zip_code) {
        customerPage.getSoleTraderComponent().setZipCode(zip_code);
    }

    @And("he gives the town name {string} in the contact data form")
    public void heGivesTheTownNameCity_nameInTheContactDataForm(String city_name) {
        customerPage.getSoleTraderComponent().setCity(city_name);
    }

    @And("he selects the country {string} in the contact data form")
    public void heSelectsTheCountryCountryInTheContactDataForm(String country) {
        customerPage.getSoleTraderComponent().setCountry(country);
    }

    @And("he gives the telephone number {string} in the contact data form")
    public void heGivesTheTelephoneNumberPhone_numberInTheContactDataForm(String phone_number) {
        customerPage.getSoleTraderComponent().setPhoneNumber(phone_number);
    }

    @And("he clicks on the button save")
    public void heClicksOnTheButtonSave() {
        customerPage.getSoleTraderComponent().save();
    }

    @Then("he selects the agreement")
    public void he_selects_the_agreement() {
        customerPage.getSoleTraderComponent().agree();
    }

    @Then("he clicks on done")
    public void he_clicks_on_done() {
        customerPage.getSoleTraderComponent().done();
    }
}
