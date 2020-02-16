package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductFactoryTest {

    private static ProductFactory productFactory;

    @BeforeAll
    static void setProducts() {
        String names = "제일미,  제이미,제삼미, 제 사 미, 제오미 ";
        ParticipantFactory participantFactory = new ParticipantFactory(names);
        productFactory = new ProductFactory(names, ParticipantFactory);
    }

    @DisplayName("상품이 잘 셋팅했는지 확인")
    @Test
    void getProductNames() {
        assertThat(productFactory.getNames().get(0)).isEqualTo("제일미");
        assertThat(productFactory.getNames().get(1)).isEqualTo("제이미");
        assertThat(productFactory.getNames().get(2)).isEqualTo("제삼미");
        assertThat(productFactory.getNames().get(3)).isEqualTo("제 사 미");
        assertThat(productFactory.getNames().get(4)).isEqualTo("제오미");
    }

    @DisplayName("상품의 개수를 확인")
    @Test
    void getProductCounts() {
        assertThat(productFactory.getCount()).isEqualTo(5);
    }
}
