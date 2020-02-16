package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductTest {

    @DisplayName("상품(당첨항목) 이름을 알려줌, 단 앞 뒤 공백은 제거할 것")
    @ParameterizedTest
    @ValueSource(strings = {"제이미", " 제이미", "제이미 ", "  제이미    ",
        "영일이삼사오육칠팔구영일이삼사오육칠팔구영일이삼사오육칠팔구영일이삼사오육칠팔구영일이삼사오육칠팔구"})
    void getProductName(String name) {
        Product product = new Product(name);
        assertThat(product.getName()).isEqualTo(name.trim());
    }

    @DisplayName("상품이 1글자 미만이거나 50글자 초과인 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"",
        "영일이삼사오육칠팔구영일이삼사오육칠팔구영일이삼사오육칠팔구영일이삼사오육칠팔구영일이삼사오육칠팔구십"})
    void exceptionParticipantName(String name) {
        assertThatThrownBy(() -> new Product(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("항목은");
    }
}
