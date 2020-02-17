package domain;

public enum LegProperties {
    LEFT(-1, "┤"),
    CENTER(0, "│"),
    RIGHT(1, "├");

    private final int moving;
    private final String sign;

    LegProperties(int moving, String sign) {
        this.moving = moving;
        this.sign = sign;
    }

    public int getMoving() {
        return moving;
    }

    public String getSign() {
        return sign;
    }
}
