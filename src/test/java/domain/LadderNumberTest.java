package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderNumberTest {

    @DisplayName("사다리 번호는 양수여야 함")
    @Test
    void numberNotNative() {
        assertThatThrownBy(() -> new LadderNumber(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("양수");
    }

    @DisplayName("사다리 번호와 번호가 같은지 확인")
    @Test
    void numberEquals() {
        LadderNumber ladderNumber = new LadderNumber(1);
        assertThat(ladderNumber.equals(1)).isTrue();
    }
}
