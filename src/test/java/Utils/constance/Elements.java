package Utils.constance;

public enum Elements {
    KINTO_ONE_DECALAGE("KINTO ONE DECALAGE"),
    KINTO_ONE("KINTO ONE");


    private String name;

    Elements(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
