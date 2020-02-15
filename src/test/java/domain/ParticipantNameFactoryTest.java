package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantNameFactoryTest {

    @DisplayName("참가자 이름을 셋팅하고, 잘 셋팅했는지 확인")
    @Test
    void getParticipantNames() {
        String names = "제일미,  제이미,제삼미, 제 사 미, 제오미 ";
        ParticipantNameFactory participantNameFactory = new ParticipantNameFactory(names);
        assertThat(participantNameFactory.getNames().get(0)).isEqualTo("제일미");
        assertThat(participantNameFactory.getNames().get(1)).isEqualTo("제이미");
        assertThat(participantNameFactory.getNames().get(2)).isEqualTo("제삼미");
        assertThat(participantNameFactory.getNames().get(3)).isEqualTo("제 사 미");
        assertThat(participantNameFactory.getNames().get(4)).isEqualTo("제오미");
    }
}
