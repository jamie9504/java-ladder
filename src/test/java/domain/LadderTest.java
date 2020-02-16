package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리가져오기")
    @Test
    void getLadder() {
        Ladder ladderObject = new Ladder(new LadderHeight(5), 5);
        List<byte[]> ladder = ladderObject.getLadder();
        assertThat(ladder.get(0)[0]).isEqualTo(0);
        assertThat(ladder.get(4)[4]).isEqualTo(0);
    }

}
