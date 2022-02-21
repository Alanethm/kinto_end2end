package e2eTests.stepdefinitions.milesRia;

import Pages.milesRiaTabs.PurchaseInvoicesTab;
import Utils.constance.TabName;
import net.thucydides.core.annotations.Step;

public class PurchaseInvoicesSteps {

    PurchaseInvoicesTab purchaseInvoicesTab;

    @Step("The dealer set the invoice number to: {0}")
    public void setInvoiceNumber(String invoiceNumber) {
        purchaseInvoicesTab.getPurchaseInvoiceMRComponent().setInvoiceNumber(invoiceNumber);
    }

    @Step("The dealer validate the whole process")
    public void processValidate() {
        purchaseInvoicesTab.getPurchaseInvoiceMRComponent().processValidate();
    }

    public void setPaymentMethod(String paymentMethod) {
        purchaseInvoicesTab.getPurchaseInvoiceMRComponent().setPaymentMethod(paymentMethod);
    }

    public void openPI() {
        purchaseInvoicesTab.openMRTabPerName(TabName.PURCHASE_INVOICES.getTabName());
    }
}
