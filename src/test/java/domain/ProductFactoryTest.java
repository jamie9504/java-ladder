package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductFactoryTest {
    @DisplayName("상품을 셋팅하고, 잘 셋팅했는지 확인 - 셋팅시 참여자 인원을 보내줌")
    @Test
    void getParticipantNames() {
        String names = "제일미,  제이미,제삼미, 제 사 미, 제오미 ";
        ProductFactory productFactory = new ProductFactory(names, 5);
        assertThat(productFactory.getNames().get(0)).isEqualTo("제일미");
        assertThat(productFactory.getNames().get(1)).isEqualTo("제이미");
        assertThat(productFactory.getNames().get(2)).isEqualTo("제삼미");
        assertThat(productFactory.getNames().get(3)).isEqualTo("제 사 미");
        assertThat(productFactory.getNames().get(4)).isEqualTo("제오미");
    }
}
