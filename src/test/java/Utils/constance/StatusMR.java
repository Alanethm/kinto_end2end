package Utils.constance;

public enum StatusMR {
    COMPLETED("Completed");



    private final String statusName;

    StatusMR(String statusName) {
        this.statusName = statusName;
    }

    public String getName() {
        return statusName;
    }
}
