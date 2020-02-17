package domain;

public enum LegProperties {
    START_CENTER(0),
    START_RIGHT(1),
    MIDDLE_LEFT(-1),
    MIDDLE_CENTER(0),
    MIDDLE_RIGHT(1),
    END_LEFT(-1),
    END_CENTER(0);

    private final int moving;

    LegProperties(int moving) {
        this.moving = moving;
    }

    public int getMoving() {
        return moving;
    }
}
