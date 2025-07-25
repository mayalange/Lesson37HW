package coffee.order;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoffeeOrderBoard {

    private static final Logger logger = LogManager.getLogger();
    private final List<Order> orders = new ArrayList<>();
    private int nextOrderNumber = 1;

    public void add(String customerName) {
        try {
            Order newOrder = new Order(nextOrderNumber, customerName);
            orders.add(newOrder);
            logger.info("Added new order: number={}, customer={}. Total orders: {}",
                    nextOrderNumber, customerName, orders.size());
            nextOrderNumber++;
        } catch (Exception e) {
            logger.error("Failed to add order: " + customerName, e);
            throw e;
        }
    }

    public Order deliver() {
        try {
            Order delivered = orders.remove(0);
            logger.info("Delivered next order: {}. Remaining orders: {}",
                    delivered, orders.size());
            return delivered;
        } catch (Exception e) {
            logger.error("Failed to deliver next order", e);
            throw e;
        }
    }

    public Order deliver(int orderNumber) {
        try {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getOrderNumber() == orderNumber) {
                    Order delivered = orders.remove(i);
                    logger.info("Delivered specific order: {}. Remaining orders: {}",
                            delivered, orders.size());
                    return delivered;
                }
            }
            return null;
        } catch (Exception e) {
            logger.error("Failed to deliver order with number: " + orderNumber, e);
            throw e;
        }
    }

    public void draw() {
        try {
            logger.info("Total orders: {}", orders.size());
            System.out.println("Num | Name");
            for (Order order : orders) {
                System.out.println(order);
            }
        } catch (Exception e) {
            logger.error("Failed to draw order", e);
            throw e;
        }
    }
}