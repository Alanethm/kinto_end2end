package general.utils;

public class ContactDataForm {
    private String streetName;
    private String streetNumber;
    private String zipCode;
    private String phoneNumber;
    private String city;
    private String country;
    public String registration_typ;
    private String start = "prospectdetail:prospectView:main:";

    public String getStreetName() {
        return start + registration_typ + ":address";
    }

    public String getStreetNumber() {
        return start + registration_typ + ":houseNumber";
    }

    public String getZipCode() {
        return start + registration_typ + ":postalCode";
    }

    public String getPhoneNumber() {
        return start + registration_typ + ":phoneNrs:0:typedPhone_localNr";
    }

    public String getCity() {
        return start + registration_typ + ":city";
    }

    public String getCountry() {
        return country;
    }
}
