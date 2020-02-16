package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantFactoryTest {

    @DisplayName("참가자 이름을 셋팅하고, 잘 셋팅했는지 확인")
    @Test
    void getParticipantNames() {
        String names = "제일미,  제이미,제삼미, 제 사 미, 제오미 ";
        ParticipantFactory participantFactory = new ParticipantFactory(names);
        assertThat(participantFactory.getNames().get(0).getName()).isEqualTo("제일미");
        assertThat(participantFactory.getNames().get(1).getName()).isEqualTo("제이미");
        assertThat(participantFactory.getNames().get(2).getName()).isEqualTo("제삼미");
        assertThat(participantFactory.getNames().get(3).getName()).isEqualTo("제 사 미");
        assertThat(participantFactory.getNames().get(4).getName()).isEqualTo("제오미");
    }
}
