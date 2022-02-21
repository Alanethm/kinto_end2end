package e2eTests.cukeStepDefinitions.milesRia;

import Utils.generatedTestData.TestData;
import e2eTests.stepdefinitions.milesRia.VehicleOrderMRSteps;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class VehicleOrderCucumberSteps extends TestData {

    @Steps
    VehicleOrderMRSteps vehicleOrderMRSteps;


    @And("he updates the delivery date")
    public void heUpdateTheDeliveryDate() {
        vehicleOrderMRSteps.setRequestDeliveryDate(getActualDate());
        vehicleOrderMRSteps.setEstimatedDeliveryDate(getFutureDate(1));
        vehicleOrderMRSteps.setActualDeliveryDate(getActualDate());
    }

    @And("he sets the supplier name to {string}")
    public void setSupplierName(String name) {
        vehicleOrderMRSteps.setSupplierName(name);
    }
}
