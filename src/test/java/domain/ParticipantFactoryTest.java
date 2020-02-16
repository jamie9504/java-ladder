package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantFactoryTest {

    private static ParticipantFactory participantFactory;

    @BeforeAll
    static void setParticipants() {
        String names = "제일미,  제이미,제삼미, 제 사 미, 제오미 ";
        participantFactory = new ParticipantFactory(names);
    }

    @DisplayName("참가자 이름들을 확인")
    @Test
    void getParticipantNames() {
        List<String> participantNames = participantFactory.getNames();

        assertThat(participantNames.get(0)).isEqualTo("제일미");
        assertThat(participantNames.get(1)).isEqualTo("제이미");
        assertThat(participantNames.get(2)).isEqualTo("제삼미");
        assertThat(participantNames.get(3)).isEqualTo("제 사 미");
        assertThat(participantNames.get(4)).isEqualTo("제오미");
    }

    @DisplayName("참가자 인원을 확인")
    @Test
    void getParticipantsCounts() {
        int participantCounts = participantFactory.getCount();

        assertThat(participantCounts).isEqualTo(5);
    }
}
