package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리가져오기")
    @Test
    void getLadder() {
        LadderSize height = new LadderSize(5);
        LadderSize width = new LadderSize(7);
        Ladder ladderObject = new Ladder(height, width);
        List<List<LegProperties>> ladder = ladderObject.getLadder();
        assertThat(ladder.get(0).get(0).getMoving()).isBetween(-1, 1);
        assertThat(ladder.get(4).get(4).getMoving()).isBetween(-1, 1);

    }
}
