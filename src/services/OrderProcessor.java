package services;

import model.Order;
import model.OrderItem;
import model.Order.OrderStatus;
import payments.PaymentStrategy;
import inventory.InventoryService;
import notifications.Subject;

public class OrderProcessor extends Subject {
    private InventoryService inventoryService;

    public OrderProcessor(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public boolean processOrder(Order order, PaymentStrategy paymentStrategy) {
        notifyObservers("ORDER_PLACED", "Order " + order.getOrderId() + " placed by " + order.getCustomer().getName());

        if (!validateOrder(order)) {
            order.setStatus(OrderStatus.FAILED);
            notifyObservers("ORDER_FAILED", "Order " + order.getOrderId() + " validation failed");
            return false;
        }

        if (!reserveInventory(order)) {
            order.setStatus(OrderStatus.FAILED);
            notifyObservers("ORDER_FAILED", "Order " + order.getOrderId() + " - insufficient inventory");
            return false;
        }

        order.setStatus(OrderStatus.RESERVED);
        notifyObservers("INVENTORY_RESERVED", "Inventory reserved for order " + order.getOrderId());

        double amount = order.totalAmount();
        boolean paymentSuccess = paymentStrategy.pay(amount);

        if (paymentSuccess) {
            order.setStatus(OrderStatus.PAID);
            notifyObservers("PAYMENT_SUCCESS", "Payment of $" + amount + " successful for order " + order.getOrderId());
            return true;
        } else {
            order.setStatus(OrderStatus.FAILED);
            notifyObservers("PAYMENT_FAILURE", "Payment of $" + amount + " failed for order " + order.getOrderId());
            return false;
        }
    }

    private boolean validateOrder(Order order) {
        return order != null && 
               order.getItems() != null && 
               !order.getItems().isEmpty() &&
               order.totalAmount() > 0;
    }

    private boolean reserveInventory(Order order) {
        for (OrderItem item : order.getItems()) {
            if (!inventoryService.reserve(item.getProduct(), item.getQuantity())) {
                return false;
            }
        }
        return true;
    }
}

