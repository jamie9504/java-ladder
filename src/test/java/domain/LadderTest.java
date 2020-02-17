package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    private static LadderSize height;
    private static LadderSize width;
    private static Ladder ladderObject;

    @BeforeAll
    static void makeLadder() {
        height = new LadderSize(5);
        width = new LadderSize(7);
        ladderObject = new Ladder(height, width);
    }

    @DisplayName("사다리가져오기")
    @Test
    void getLadder() {
        List<List<LegProperties>> ladder = ladderObject.getLadder();
        assertThat(ladder.get(0).get(0).getMoving()).isBetween(-1, 1);
        assertThat(ladder.get(4).get(4).getMoving()).isBetween(-1, 1);
    }

    @DisplayName("사다리 사이즈 검증")
    @Test
    void getLadderSize() {
        ladderObject.getHeight();
        assertThat(ladderObject.getHeight()).isEqualTo(height);
        assertThat(ladderObject.getWidth()).isEqualTo(width);
    }
}
