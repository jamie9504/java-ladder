package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParticipantNameTest {

    @DisplayName("참가자 이름을 알려줌, 단 앞 뒤 공백은 제거할 것")
    @ParameterizedTest
    @ValueSource(strings = {"제이미", " 제이미", "제이미 "})
    void getParticipantName(String name) {
        ParticipantName participantName = new ParticipantName(name);
        assertThat(participantName.getName()).isEqualTo(name.trim());
    }
}
