package e2eTests.cukeStepDefinitions.milesRia;

import Pages.milesRiaPages.FleetVehiclePage;
import io.cucumber.java.en.When;

import static Utils.constance.TabName.FLEET_VEHICLE;
import static Utils.constance.TabName.LONG_TERM_CONTRACTS;

public class FleetVehicleMRSteps {

    FleetVehiclePage fleetVehiclePage;


    @When("he switch to the Fleet vehicle tab")
    public void he_switch_to_the_fleet_vehicle_tab() {
        fleetVehiclePage.openMRTabPerName(FLEET_VEHICLE.getTabName());
    }
}
