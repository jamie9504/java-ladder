package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderHeightTest {

    @DisplayName("사다리 높이 가져오기")
    @Test
    void getHeight() {
        LadderHeight ladderHeight = new LadderHeight(5);
        assertThat(ladderHeight.getHeight()).isEqualTo(5);
    }
}
