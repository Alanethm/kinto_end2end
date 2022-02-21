package e2eTests.cukeStepDefinitions.milesRia;

import Utils.generatedTestData.TestData;
import e2eTests.stepdefinitions.milesRia.PurchaseInvoicesSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class PurchaseInvoicesCucumberSteps extends TestData {

    @Steps
    PurchaseInvoicesSteps purchaseInvoicesSteps;

    @And("he sets the invoice number")
    public void heSetTheInvoiceNumber() {
        purchaseInvoicesSteps.setInvoiceNumber(getInvoiceNumber(8));
    }

    @And("he validates the process")
    public void heValidateTheProcess() {
        purchaseInvoicesSteps.processValidate();
    }

    @And("he sets the payment method to {string}")
    public void heSetsThePaymentMethodToDirectDebit(String paymentMethod) {
        purchaseInvoicesSteps.setPaymentMethod(paymentMethod);
    }

    @Then("he switch to purchase invoices")
    public void heSwitchToPurchaseInvoices() {
        purchaseInvoicesSteps.openPI();
    }
}
