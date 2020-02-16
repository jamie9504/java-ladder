package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderNumberFactoryTest {

    @DisplayName("수량을 입력하였을 때, 그 만큼 Ladder Number들을 생성해주는지 확인")
    @Test
    void makeLadderNumber() {
        LadderNumberFactory ladderNumberFactory = new LadderNumberFactory(3);
        List<Integer> ladderNumbers = ladderNumberFactory.getLadderNumbers();
        assertThat(ladderNumbers.get(0)).isEqualTo(1);
        assertThat(ladderNumbers.get(1)).isEqualTo(2);
        assertThat(ladderNumbers.get(2)).isEqualTo(3);
    }

    @DisplayName("수량은 2 이상이어야 함")
    @Test
    void makeLadderNumberException() {
        assertThatThrownBy(() -> new LadderNumberFactory(1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("2");
    }
}
