package domain;

public class LadderNumber {

    private final static int VALID_NUMBER_MORE = 0;
    private final static String EXCEPTION_MESSAGE_VALID_POSITIVE = "사다리 번호는 양수여야 합니다.";

    private final int ladderNumber;

    public LadderNumber(int number) {
        validPositive(number);
        this.ladderNumber = number;
    }

    private void validPositive(int number) {
        if (number <= VALID_NUMBER_MORE) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_VALID_POSITIVE);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object.getClass() == Integer.class) {
            return this.ladderNumber == (int) object;
        }
        return super.equals(object);
    }
}