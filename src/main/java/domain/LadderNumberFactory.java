package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderNumberFactory {

    private final static int COUNT_START_NUMBER = 1;
    private final static int COUNT_MORE_THAN_OR_EQUAL_TO = 2;
    private final static String EXCEPTION_MESSAGE_VALID_NUMBER =
        "사다리는 " + COUNT_MORE_THAN_OR_EQUAL_TO + "개 이상이여야 합니다.";

    private final List<LadderNumber> ladderNumbers;

    public LadderNumberFactory(int count) {
        validNumber(count);
        ladderNumbers = makeLadderNumbers(count);
    }

    private void validNumber(int count) {
        if (count < COUNT_MORE_THAN_OR_EQUAL_TO) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_VALID_NUMBER);
        }
    }

    private List<LadderNumber> makeLadderNumbers(int count) {
        List<LadderNumber> ladderNumbers = new ArrayList<>();
        for (int i = COUNT_START_NUMBER; i <= count; i++) {
            ladderNumbers.add(new LadderNumber(i));
        }
        return ladderNumbers;
    }

    public List<Integer> getLadderNumbers() {
        List<Integer> numbers = new ArrayList<>();
        int size = ladderNumbers.size();
        for (int i = COUNT_START_NUMBER; i <= size; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
