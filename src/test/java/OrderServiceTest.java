import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class StockToujours100 implements InventoryRepository {

    public int getStock(String id) {
        return 100;
    }

}
class OrderServiceTest {

    private InventoryRepository stock;
    private OrderService service;
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {

        stock = new StockToujours100();
        service = new OrderService(stock);
        cart = new ShoppingCart();

    }

    @Test
    void commandeValideDoitRetournerOrder() {

        cart.addItem("PROD-001", 2, 15.0);

        Order order = service.placeOrder(cart, "CLIENT-42");

        assertNotNull(order);
        assertEquals(30.0, order.total());
    }

    @Test
    void panierVideDoitLeverIllegalStateException() {

        assertThrows(
                IllegalStateException.class,
                () -> service.placeOrder(cart, "C1")
        );

    }

    @Test
    void customerIdNulDoitLeverException() {

        cart.addItem("PROD-001", 1, 10.0);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.placeOrder(cart, null)
        );

    }

    @Test
    void stockInsuffisantDoitLeverOutOfStockException() {

        cart.addItem("PROD-001", 200, 10.0);

        assertThrows(
                OutOfStockException.class,
                () -> service.placeOrder(cart, "CLIENT-1")
        );

    }

}



