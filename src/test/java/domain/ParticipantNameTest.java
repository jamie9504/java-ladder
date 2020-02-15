package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParticipantNameTest {

    @DisplayName("참가자 이름을 받아옴")
    @Test
    void getParticipantName() {
        ParticipantName participantName = new ParticipantName("순이");
        assertThat(participantNameTest).isEqualTo("순이");
    }
}
