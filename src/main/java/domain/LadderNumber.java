package domain;

public class LadderNumber {

    private final int ladderNumber;

    public LadderNumber(int number) {
        validPositive(number);
        this.ladderNumber = number;
    }

    private void validPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("사다리 번호는 양수여야 합니다.");
        }
    }
}
