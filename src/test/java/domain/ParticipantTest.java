package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParticipantTest {

    @DisplayName("참가자 이름을 알려줌, 단 앞 뒤 공백은 제거할 것")
    @ParameterizedTest
    @ValueSource(strings = {"제이미", " 제이미", "제이미 ", "  제이미    "})
    void getParticipantName(String name) {
        Participant participant = new Participant(name);
        assertThat(participant.getName()).isEqualTo(name.trim());
    }

    @DisplayName("참가자 이름이 1글자 미만이거나 5글자를 초과인 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "제일미제이미"})
    void exceptionParticipantName(String name) {
        assertThatThrownBy(() -> new Participant(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은");
    }

    @DisplayName("참가자 이름 길이를 알려줌")
    @Test
    void getParticipantNameLength() {
        Participant participant = new Participant("제 이미");
        assertThat(participant.getNameLength()).isEqualTo(4);
    }

    @DisplayName("참가자 이름 사이즈를 알려줌")
    @Test
    void getParticipantNameSize() {
        Participant participant = new Participant("제 이미");
        System.out.println(participant.getNameSize());
        assertThat(participant.getNameSize()).isBetween(4.0, 10.0);

        Participant participant2 = new Participant("jamie");
        System.out.println(participant2.getNameSize());
        assertThat(participant2.getNameSize()).isBetween(4.0, 10.0);
    }
}
