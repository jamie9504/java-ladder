package domain;

public class LadderHeight {

    private static final int HEIGHT_MORE_THAN_NUMBER = 0;
    private static final String EXCEPTION_MESSAGE_LESS_THAN_OR_EQUAL_TO =
        "사다리의 높이는 " + HEIGHT_MORE_THAN_NUMBER + "보다 커야합니다.";

    private final int height;

    public LadderHeight(int height) {
        validHeightMoreThan(height);
        this.height = height;
    }

    private void validHeightMoreThan(int height) {
        if (height <= HEIGHT_MORE_THAN_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_LESS_THAN_OR_EQUAL_TO);
        }
    }

    public int getHeight() {
        return height;
    }
}
