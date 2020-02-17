package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductsTest {

    private static Participants participants;
    private static Products products;

    @BeforeAll
    static void setProducts() {
        String names = "제일미,  제이미,제삼미, 제 사 미, 제오미 ";
        participants = new Participants(names);
        products = new Products(names, participants);
    }

    @DisplayName("상품이 잘 셋팅했는지 확인")
    @Test
    void getProductNames() {
        assertThat(products.getNames().get(0)).isEqualTo("제일미");
        assertThat(products.getNames().get(1)).isEqualTo("제이미");
        assertThat(products.getNames().get(2)).isEqualTo("제삼미");
        assertThat(products.getNames().get(3)).isEqualTo("제 사 미");
        assertThat(products.getNames().get(4)).isEqualTo("제오미");
    }

    @DisplayName("상품의 개수를 확인")
    @Test
    void getProductCounts() {
        assertThat(products.getCount()).isEqualTo(5);
    }

    @DisplayName("참여인원보다 상품이 더 많으면 예외")
    @Test
    void exceptionMoreParticipantFactory() {
        String namesProduct = "제일미,  제이미,제삼미, 제 사 미, 제오미 , 제육미";

        assertThatThrownBy(() -> new Products(namesProduct, participants))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("많습니다.");
    }

    @DisplayName("참여인원보다 상품이 적으면 True")
    @Test
    void checkLessThan() {
        Assertions.assertThat(ProductsTest.products.isLessThan(participants)).isFalse();

        String namesProduct = "제일미,  제이미,제삼미, 제 사 미";
        Products products = new Products(namesProduct, participants);

        assertThat(products.isLessThan(participants)).isTrue();
    }

    @DisplayName("가장 큰 상품이름 길이를 가져옴")
    @Test
    void checkMaxSize() {
        assertThat(products.getMaxNameSize()).isEqualTo(5);
    }
}
