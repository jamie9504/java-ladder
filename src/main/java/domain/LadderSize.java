package domain;

public class LadderSize {

    private static final int HEIGHT_MORE_THAN_NUMBER = 0;
    private static final String EXCEPTION_MESSAGE_LESS_THAN_OR_EQUAL_TO =
        "사다리 크기는 " + HEIGHT_MORE_THAN_NUMBER + "보다 커야합니다.";

    private final int size;

    public LadderSize(int size) {
        validHeightMoreThan(size);
        this.size = size;
    }

    private void validHeightMoreThan(int height) {
        if (height <= HEIGHT_MORE_THAN_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_LESS_THAN_OR_EQUAL_TO);
        }
    }

    public int getSize() {
        return size;
    }
}
