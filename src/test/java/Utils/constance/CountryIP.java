package Utils.constance;

public enum CountryIP {

    ITALY_IP("https://10.21.0.226:10143/"),
    FRANCE_IP("https://10.21.2.50:10143/");



    private String milesRiaIP;

    CountryIP(String milesRiaIP) {
        this.milesRiaIP = milesRiaIP;
    }

    public String getMilesRiaIP() {
        return milesRiaIP;
    }
}
