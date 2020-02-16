package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductTest {

    @DisplayName("당첨항목 이름을 알려줌, 단 앞 뒤 공백은 제거할 것")
    @ParameterizedTest
    @ValueSource(strings = {"제이미", " 제이미", "제이미 ", "  제이미    "})
    void getProductName(String name) {
        Product product = new Product(name);
        assertThat(product.getName()).isEqualTo(name.trim());
    }
}
