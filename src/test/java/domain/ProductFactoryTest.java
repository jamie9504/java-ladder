package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductFactoryTest {

    private static ParticipantFactory participantFactory;
    private static ProductFactory productFactory;

    @BeforeAll
    static void setProducts() {
        String names = "제일미,  제이미,제삼미, 제 사 미, 제오미 ";
        participantFactory = new ParticipantFactory(names);
        productFactory = new ProductFactory(names, participantFactory);
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

    @DisplayName("참여인원보다 상품이 더 많으면 예외")
    @Test
    void exceptionMoreParticipantFactory() {
        String namesProduct = "제일미,  제이미,제삼미, 제 사 미, 제오미 , 제육미";

        assertThatThrownBy(() -> new ProductFactory(namesProduct, participantFactory))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("많습니다.");
    }

    @DisplayName("참여인원보다 상품이 적으면 True")
    @Test
    void checkLessThan() {
        assertThat(productFactory.isLessThan(participantFactory)).isFalse();

        String namesProduct = "제일미,  제이미,제삼미, 제 사 미";
        ProductFactory productFactory = new ProductFactory(namesProduct, participantFactory);

        assertThat(productFactory.isLessThan(participantFactory)).isTrue();
    }
}
