package Utils.constance;

public enum MenuName {
    QUOTES("Quotes"),
    LONG_TERM_CONTRACTS("Long");

    private final String menuName;

    MenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getName() {
        return menuName;
    }
}
