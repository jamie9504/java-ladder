package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderNumberFactory {

    private final List<LadderNumber> ladderNumbers;

    public LadderNumberFactory(int count) {
        validNumber(count);
        ladderNumbers = makeLadderNumbers(count);
    }

    private void validNumber(int count) {
        if(count < 2) {
            throw new IllegalArgumentException("사다리는 " + 2 + "개 이상이여야 합니다.");
        }
    }

    private List<LadderNumber> makeLadderNumbers(int count) {
        List<LadderNumber> ladderNumbers = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            ladderNumbers.add(new LadderNumber(i));
        }
        return ladderNumbers;
    }

    public List<Integer> getLadderNumbers() {
        List<Integer> numbers = new ArrayList<>();
        int size = ladderNumbers.size();
        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
