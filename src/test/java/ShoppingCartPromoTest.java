import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartPromoTest {

    @ParameterizedTest
    @CsvSource({
            "'', 100.0",        // pas de promo
            "PROMO10, 90.0",    // -10%
            "PROMO20, 80.0"     // -20%
    })
    void getTotalDoitAppliquerLaBonneReduction(String code, double expectedTotal) {

        // Arrange
        ShoppingCart cart = new ShoppingCart();

        // Act
        cart.addItem("PROD-001", 10, 10.0); // 10 x 10 = 100

        if (code != null && !code.isBlank()) {
            cart.applyPromoCode(code.trim());
        }

        // Assert
        assertEquals(expectedTotal, cart.getTotal(), 0.001);
    }

}