package util;

import static org.assertj.core.api.Assertions.assertThat;
import static util.SplitAndRefine.splitExceptJustBlankWithDelimiter;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitAndRefineTest {

    private final static String SPLIT_DELIMITER = ",";

    @DisplayName("Delimiter로 구분된 문자열을 나눈 사이즈가 같음")
    @Test
    void splitWithComma() {
        String abc1 = "a" + SPLIT_DELIMITER + "b" + SPLIT_DELIMITER + "c";
        String abc2 = abc1 + SPLIT_DELIMITER;
        String abc3 = abc2 + SPLIT_DELIMITER;
        String abc4 = SPLIT_DELIMITER + SPLIT_DELIMITER + abc3;
        String abc5 =
            SPLIT_DELIMITER + "   " + SPLIT_DELIMITER + "   " + abc1 + "  " + SPLIT_DELIMITER;
        List<String> abc1s = splitExceptJustBlankWithDelimiter(abc1);
        List<String> abc2s = splitExceptJustBlankWithDelimiter(abc2);
        List<String> abc3s = splitExceptJustBlankWithDelimiter(abc3);
        List<String> abc4s = splitExceptJustBlankWithDelimiter(abc4);
        List<String> abc5s = splitExceptJustBlankWithDelimiter(abc5);
        assertThat(abc1s.size() == abc2s.size()).isTrue();
        assertThat(abc3s.size() == abc4s.size()).isTrue();
        assertThat(abc1s.size() == abc5s.size()).isTrue();
        assertThat(abc1s.size() == abc3s.size()).isTrue();
    }
}
