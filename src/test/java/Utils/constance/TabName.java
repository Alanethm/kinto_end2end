package Utils.constance;

public enum TabName {
    QUOTE("Quote"),
    LONG_TERM_CONTRACTS("LTC"),
    FLEET_VEHICLE("FV"),
    PURCHASE_INVOICES("PI");

    private final String tabName;

    TabName(String tabName) {
        this.tabName = tabName;
    }

    public String getTabName() {
        return tabName;
    }
}
