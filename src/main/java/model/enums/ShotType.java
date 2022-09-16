package model.enums;

/**
 * Enum for shot type.
 */
public enum ShotType {
    STRIKE(10),
    SPARE(10);

    private Integer shot;

    public Integer getShot() {
        return this.shot;
    }

    ShotType(final Integer shot) {
        this.shot = shot;
    }
}
