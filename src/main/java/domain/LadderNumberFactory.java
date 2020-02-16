package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderNumberFactory {

    private final List<LadderNumber> ladderNumbers;

    public LadderNumberFactory(int count) {
        ladderNumbers = makeLadderNumbers(count);
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
