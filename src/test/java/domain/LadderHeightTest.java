package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderHeightTest {

    @DisplayName("사다리 높이 가져오기")
    @Test
    void getHeight() {
        LadderHeight ladderHeight = new LadderHeight(5);
        assertThat(ladderHeight.getHeight()).isEqualTo(5);
    }

    @DisplayName("사다리 높이가 0보다 크지 않으면 아니면 예외")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void exceptionHeightNotMoreThan(int height) {
        assertThatThrownBy(() -> new LadderHeight(height))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1 이상 ");
    }
}
