package Utils;

import Utils.constance.CountryIP;

import static Utils.constance.CountryIP.FRANCE_IP;
import static Utils.constance.CountryIP.ITALY_IP;
import static org.junit.Assert.fail;

public class CurrentProperties {

    private String currentCountry;
    private String currentCountryIP;

    public CurrentProperties(String currentCountry) {
        this.currentCountry = currentCountry;
    }

    public void setCurrentCountry(String currentCountry) {
        this.currentCountry = currentCountry;
    }

    public String getCurrentCountry() {
        return currentCountry;
    }

    public String getCurrentCountryIP() {
        if(getCurrentCountry().equalsIgnoreCase("France")){
            return FRANCE_IP.getMilesRiaIP();
        }if(getCurrentCountry().equalsIgnoreCase("Italy")){
            return ITALY_IP.getMilesRiaIP();
        }
        fail("Unknown Country");
        return "";
    }
}
