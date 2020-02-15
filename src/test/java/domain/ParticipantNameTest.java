package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("참가자 이름이 1글자 미만이거나 5글자를 초과인 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "제일미제이미"})
    void exceptionParticipantName(String name) {
        assertThatThrownBy(() -> new ParticipantName(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은");
    }
}
