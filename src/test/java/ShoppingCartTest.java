import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {


    //1
    @Test
    void addItemDoitAugmenterLeNombreArticles() {

        // Arrange
        ShoppingCart cart = new ShoppingCart();

        // Act
        cart.addItem("PROD-001", 2, 15.0);

        // Assert
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void getTotalDoitRetournerSommePrixUnitairesMultipliesParQuantite() {

        // Arrange
        ShoppingCart cart = new ShoppingCart();

        // Act
        cart.addItem("PROD-001", 2, 15.0);

        // Assert
        assertEquals(30.0, cart.getTotal());
    }

    @Test
    void cartVideDoitAvoirIsEmptyTrue() {

        // Arrange
        ShoppingCart cart = new ShoppingCart();

        // Assert
        assertTrue(cart.isEmpty());
    }

    //2 cas invlides

    @Test
void productIdNulDoitLeverException() {

    ShoppingCart cart = new ShoppingCart();

    assertThrows(
        IllegalArgumentException.class,
        () -> cart.addItem(null, 1, 10.0)
    );
}

@Test
void productIdVideDoitLeverException() {

    ShoppingCart cart = new ShoppingCart();

    assertThrows(
        IllegalArgumentException.class,
        () -> cart.addItem("", 1, 10.0)
    );
}

@Test
void quantiteNulleDoitLeverException() {

    ShoppingCart cart = new ShoppingCart();

    assertThrows(
        IllegalArgumentException.class,
        () -> cart.addItem("PROD-001", 0, 15.0)
    );
}

@Test
void quantiteNegativeDoitLeverException() {

    ShoppingCart cart = new ShoppingCart();

    assertThrows(
        IllegalArgumentException.class,
        () -> cart.addItem("PROD-001", -3, 15.0)
    );
}

@Test
void prixNegatifDoitLeverException() {

    ShoppingCart cart = new ShoppingCart();

    assertThrows(
        IllegalArgumentException.class,
        () -> cart.addItem("PROD-001", 1, -5.0)
    );
}

@Test
void codePromoVideDoitLeverException() {

    ShoppingCart cart = new ShoppingCart();

    assertThrows(
        IllegalArgumentException.class,
        () -> cart.applyPromoCode("")
    );
}

//3 cas limites

@Test
void quantiteUneDoitFonctionner() {

    ShoppingCart cart = new ShoppingCart();

    cart.addItem("PROD-001", 1, 9.99);

    assertEquals(9.99, cart.getTotal());
}

@Test
void articleGratuitDoitEtreAccepte() {

    ShoppingCart cart = new ShoppingCart();

    cart.addItem("PROMO-FREE", 1, 0.0);

    assertEquals(0.0, cart.getTotal());
}

@Test
void prixEleveDoitFonctionner() {

    ShoppingCart cart = new ShoppingCart();

    cart.addItem("PROD-LUXE", 1, 999.99);

    assertEquals(999.99, cart.getTotal());
}

@Test
void panierAvecUnSeulArticleDoitFonctionner() {

    ShoppingCart cart = new ShoppingCart();

    cart.addItem("PROD-001", 2, 10.0);

    assertEquals(1, cart.getItemCount());
}
}