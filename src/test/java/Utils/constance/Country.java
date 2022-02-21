package Utils.constance;

public enum Country {
    ITALY("https://10.21.0.226:10143/milesria/","https://10.21.0.226:9943/TFMIT_TST_WEB/user/login.xhtml"),
    FRANCE("https://10.21.2.50:10143/milesria/", "https://10.21.2.50:9943/TFMFR_TST_WEB/user/login.xhtml");


    private String milesRiaURL;
    private String milesWebURL;

    Country(String milesRiaURL, String milesWebURL) {
        this.milesRiaURL = milesRiaURL;
        this.milesWebURL = milesWebURL;
    }

    public String getMilesWebURL() {
        return milesWebURL;
    }

    public String getMilesRiaURL() {
        return milesRiaURL;
    }
}


