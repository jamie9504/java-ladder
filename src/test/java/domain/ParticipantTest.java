package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        jamie = new Participant(jamieName, 4);
    }

    @DisplayName("자신의 이름을 알려줌")
    @Test
    void getName() {
        assertThat(jamie.getName()).isEqualTo("제이미");
    }

    @DisplayName("사다리의 번호를 알려줌")
    @Test
    void getNumber() {
        assertThat(jamie.getNumber()).isEqualTo(4);
    }

    @DisplayName("사다리 번호는 양수여야 함")
    @Test
    void numberNotNative() {
        assertThatThrownBy(() -> new Participant(jamieName, -1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("양수");
    }
}
