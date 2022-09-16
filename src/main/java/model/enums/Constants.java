package model.enums;

/**
 * Class enums for global constants.
 */
public enum Constants {
    TAB("\t"),
    FOUL("F"),
    STRIKE("X"),
    ZERO("0"),
    TEN("10"),
    SPEAR("/");

    private String message;

    public String getMessage() {
        return this.message;
    }

    Constants(final String message) {
        this.message = message;
    }
}
