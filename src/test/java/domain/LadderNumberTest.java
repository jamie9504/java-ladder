package domain;

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
}
