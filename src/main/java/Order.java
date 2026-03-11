import java.time.LocalDateTime;

public class Order {

    private final String customerId;
    private final double total;
    private final LocalDateTime dateTime;

    public Order(String customerId, double total, LocalDateTime dateTime) {
        this.customerId = customerId;
        this.total = total;
        this.dateTime = dateTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double total() {
        return total;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}