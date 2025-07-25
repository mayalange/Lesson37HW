package coffee.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Order {

    private static final Logger logger = LogManager.getLogger(Order.class);
    private final int orderNumber;
    private final String customerName;

    public Order(int orderNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        logger.info("Created new order: number={}, customer={}", orderNumber, customerName);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
    @Override
    public String toString() {
        return "orderNumber=" + orderNumber +
                ", customerName='" + customerName;
    }
}