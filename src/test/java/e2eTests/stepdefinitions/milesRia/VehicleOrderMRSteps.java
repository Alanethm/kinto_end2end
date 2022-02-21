package e2eTests.stepdefinitions.milesRia;

import Pages.milesRiaTabs.VehicleOrderTab;
import net.thucydides.core.annotations.Step;

public class VehicleOrderMRSteps {

    VehicleOrderTab vehicleOrderTab;

    @Step("The dealer set the supplier:{0}")
    public void setSupplierName(String name) {
        vehicleOrderTab.getVehicleOrderInfComponent().setSupplier(name);
    }

    @Step("The dealer set the request delivery date {0}")
    public void setRequestDeliveryDate(String futureDate) {
        vehicleOrderTab.getVehicleOrderInfComponent().setRequestDeliveryDate(futureDate);
    }

    @Step("The dealer set the estimated delivery date {0}")
    public void setEstimatedDeliveryDate(String futureDate) {
        vehicleOrderTab.getVehicleOrderInfComponent().setEstimatedDeliveryDate(futureDate);
    }

    @Step("The dealer set the Actual delivery date {0}")
    public void setActualDeliveryDate(String futureDate) {
        vehicleOrderTab.getVehicleOrderInfComponent().setActualDeliveryDate(futureDate);
    }
}
