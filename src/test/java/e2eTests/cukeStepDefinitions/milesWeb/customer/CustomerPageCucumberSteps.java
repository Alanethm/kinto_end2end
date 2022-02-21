package e2eTests.cukeStepDefinitions.milesWeb.customer;

import Pages.customer.CustomerPage;
import Utils.generatedTestData.TestData;
import e2eTests.stepdefinitions.CustomerPageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CustomerPageCucumberSteps extends TestData {

    CustomerPage customerPage;
    @Steps
    public CustomerPageSteps customerPageSteps;

    @When("navigating to organization {int}")
    public void navigate_to_organization(Integer int1) {
        customerPageSteps.chooseTab(int1);
    }

    @And("he gives a company name in the company form")
    public void he_gives_a_company_name_in_the_company_form() {
        customerPageSteps.setCompany(getNameWithNumeric("Testaumation"));
    }

    @And("he sets a company name")
    public void setCompany() {
        customerPage.getIndividualComponent().setCompany(getNameWithNumeric("Testaumation"));
    }

    @And("he gives the street name {string} in the contact data form")
    public void heGivesTheStreetNameStreet_nameInTheContactDataForm(String streetName) {
        customerPageSteps.setStreetName(streetName);
    }

    @And("he gives the street fleet size {string} in the contact data form")
    public void heGivesTheStreetFleetSizeFleet_SizeInTheContactDataForm(String size) {
        customerPage.getOrganizationComponent().setFleetSize(size);
    }

    @And("he gives the street name {string}")
    public void heGivesTheStreetNameStreet_name(String streetName) {
        customerPage.getIndividualComponent().setStreetName(streetName);
    }

    @And("he gives the street number {string} in the contact data form")
    public void heGivesTheStreetNumberStreet_numberInTheContactDataForm(String street_number) {
        customerPageSteps.setStreetNumber(street_number);
    }

    @And("he gives the street number {string}")
    public void heGivesTheStreetNumberStreet_number(String street_number) {
        customerPage.getIndividualComponent().setStreetNumber(street_number);
    }

    @And("he gives the city name {string} in the contact data form")
    public void heGivesTheCityNameCity_nameInTheContactDataForm(String city) {
        customerPage.getOrganizationComponent().setCity(city);
    }

    @And("he gives the city name {string}")
    public void heGivesTheCityNameCity_name(String city) {
        customerPage.getIndividualComponent().setCity(city);
    }

    @And("he gives the zip code {string} in the contact data form")
    public void heGivesTheZipCodeZip_codeInTheContactDataForm(String zipCode) {
        customerPage.getOrganizationComponent().setZipCode(zipCode);
    }

    @And("he gives the zip code {string}")
    public void heGivesTheZipCodeZip_code(String zipCode) {
        customerPage.getIndividualComponent().setZipCode(zipCode);
    }

    @And("he select the country {string} in the contact data form")
    public void heSelectTheCountryCountryInTheContactDataForm(String country) {
        customerPage.getOrganizationComponent().setCountry(country);
    }

    @And("he gives the phone number {string} in the contact data form")
    public void heGivesThePhoneNumberPhone_numberInTheContactDataForm(String phoneNumber) {
        customerPage.getOrganizationComponent().setPhoneNumber(phoneNumber);
    }

    @And("he gives the phone number {string}")
    public void heGivesThePhoneNumberPhone_number(String phoneNumber) {
        customerPage.getIndividualComponent().setPhoneNumber(phoneNumber);
    }

    @And("he selects the legal entity {string}")
    public void heSelectTheLegalEntityLegal_entity(String legalEntity) {
        customerPage.getOrganizationComponent().setLegal_entity(legalEntity);
    }

    @And("he goes to contact person and selects the title {string}")
    public void heGoToContactPersonAndSelectsTheTitleTitle(String title) {
        customerPage.getOrganizationComponent().setTitleByText(title);
    }
    @And("he selects the contact person title {string}")
    public void selectTitle(String title) {
        customerPage.getIndividualComponent().setTitleByText(title);
    }

    @And("he click on the button save")
    public void heClickOnTheButtonSave() {
        customerPage.getOrganizationComponent().save();
    }



    @And("he gives the surname {string}")
    public void heGivesTheSurname(String surname) {
        customerPage.getOrganizationComponent().setSurname(surname);
    }

    @And("he sets the surname {string}")
    public void setTheSurname(String surname) {
        customerPage.getIndividualComponent().setSurname(getNameWithNumeric(surname));
    }

    @And("he gives the first name {string}")
    public void heGivesTheFirstName(String firstName) {
        customerPage.getOrganizationComponent().setName(firstName);
    }

    @And("he sets the first name {string}")
    public void setsTheFirstName(String firstName) {
        customerPage.getIndividualComponent().setName(firstName);
    }

    @And("he gives the email {string}")
    public void heGivesTheEmail(String email) {
        customerPage.getOrganizationComponent().setEmail(email);
    }

    @And("he sets the email {string}")
    public void setEmail(String email) {
        customerPage.getIndividualComponent().setEmail(email);
    }

    @And("he gives the date of birth {string}")
    public void heGivesTheDateOfBirth(String birthDate) {
        customerPage.getOrganizationComponent().setBirthDate(birthDate);
    }

    @And("he sets the establishment date to {string}")
    public void heSetsTheEstablishmentDateTo(String date) {
        customerPage.getIndividualComponent().setEstablishmentDate(date);
    }


}
