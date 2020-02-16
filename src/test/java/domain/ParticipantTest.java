package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantTest {

    static ParticipantName jamieName;
    static Participant jamie;

    @BeforeAll
    @Test
    static void makeParticipant() {
        jamieName = new ParticipantName("제이미");
        jamie = new Participant(jamieName, new LadderNumber(4));
    }

    @DisplayName("자신의 이름을 알려줌")
    @Test
    void getName() {
        assertThat(jamie.getName()).isEqualTo("제이미");
    }

    @DisplayName("사다리의 번호가 맞는지 확인함")
    @Test
    void getNumber() {
        assertThat(jamie.isSameNumber(4)).isTrue();
    }
}
