package e2eTests.stepdefinitions.milesRia;

import Pages.milesRiaPages.QuotesPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class QuotesMRSteps {

    QuotesPage quotesPage;

    @Step("The dealer click on Credit Scores")
    public void selectCreditScore() {
        String selectedElement = quotesPage.getCreditScoreMRComponent().selectCreditScore();
    }

    @Step("The dealer set the status to {0}")
    public void setStatus(String status) {
        quotesPage.getCreditScoreMRComponent().setStatus(status);
    }

    @Step("The dealer set the status to {0}")
    public void overviewSetStatus(String status) {
        quotesPage.getCreditScoreMRComponent().overviewSetStatus(status);
    }


    @Step("The dealer set the decision to {0}")
    public void setDecision(String decision) {
        quotesPage.getCreditScoreMRComponent().setDecision(decision);
    }

    @Step("The dealer click on contract")
    public void clickOnContract() {
        quotesPage.getCreditScoreMRComponent().clickOnContract();
    }

    @Step("The dealer select the resulting contract")
    public void selectResultingContracts() {
       quotesPage.getResultingContractMRComponent().selectContract();
    }

    @Step()
    public void selectStipulation() {
        openFinancial();
        quotesPage.getResultingContractMRComponent().openStipulation();
        quotesPage.getResultingContractMRComponent().selectAllStipulation();
    }

    @Step()
    public void openFinancial(){
        quotesPage.getResultingContractMRComponent().openFinancial();
    }

    @Step()
    public void activateStipulation() {
        quotesPage.getResultingContractMRComponent().activateStipulation();
    }

    @Step()
    public void clickOnGeneral() {
        quotesPage.getResultingContractMRComponent().backToGeneral();
    }

    @Step()
    public void clickOnLTCGeneral() {
        quotesPage.getResultingContractMRComponent().clickOnLTCGeneral();
    }

    @Step()
    public void clickOnCopy() {
        quotesPage.clickOnCopy();
    }

    @Step()
    public void clickOnNewRequest() {
        quotesPage.selectNewRequest();
    }

    public void getQuoteId() {
        quotesPage.getQuoteID();
    }

    public void closeBrowser() {
        quotesPage.closeBrowser();
    }

    public void selectsCreditApplication() {
        quotesPage.selectsCreditApplication();
    }

    @Step()
    public void selectCAStipulation() {
        quotesPage.getResultingContractMRComponent().openCAStipulation();
        quotesPage.getResultingContractMRComponent().selectAllStipulation();
    }

    public void openTab(String name) {
        quotesPage.openMRTabPerName(name);
    }

    public void clickOnContextMenu(By contextMenuByName) {
        quotesPage.clickOnContextMenu(contextMenuByName);
    }

    public void clickOnStipulation() {
        quotesPage.clickOnStipulation();
    }

    public void clickOnRefresh() {
        quotesPage.clickOnRefresh();
    }

    public void openFinancialStipulation() {
        quotesPage.getResultingContractMRComponent().openFinancialStipulation();
        quotesPage.getResultingContractMRComponent().selectAllStipulation();
    }
}
