package e2eTests.cukeStepDefinitions.milesRia;


public class ParametrizedCountry {

    private final String country;

    public ParametrizedCountry(String pCountry) {
        this.country = pCountry;
    }

    public String getCountry() {
        return this.country;
    }
}
