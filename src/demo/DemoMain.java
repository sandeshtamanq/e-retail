package demo;

import model.*;
import payments.*;
import inventory.InventoryService;
import notifications.NotificationService;
import services.OrderProcessor;

public class DemoMain {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();
        OrderProcessor orderProcessor = new OrderProcessor(inventoryService);

        NotificationService notificationService = new NotificationService();
        orderProcessor.addObserver(notificationService);

        Product laptop = new Product("P001", "Laptop", 999.99);
        Product mouse = new Product("P002", "Mouse", 29.99);
        Product keyboard = new Product("P003", "Keyboard", 79.99);

        inventoryService.addStock(laptop, 10);
        inventoryService.addStock(mouse, 50);
        inventoryService.addStock(keyboard, 20);

        Customer customer = new Customer("C001", "John Doe", "john@example.com");

        System.out.println("=== Order Processing Demo ===\n");

        System.out.println("--- Demo 1: Card Payment ---");
        Order order1 = new Order("ORD001", customer);
        order1.addItem(new OrderItem(laptop, 1));
        order1.addItem(new OrderItem(mouse, 2));
        System.out.println("Order Total: $" + order1.totalAmount());
        PaymentStrategy cardPayment = new CardPayment("1234-5678-9012-3456");
        orderProcessor.processOrder(order1, cardPayment);
        System.out.println("Final Order Status: " + order1.getStatus() + "\n");

        System.out.println("--- Demo 2: Wallet Payment ---");
        Order order2 = new Order("ORD002", customer);
        order2.addItem(new OrderItem(keyboard, 1));
        System.out.println("Order Total: $" + order2.totalAmount());
        PaymentStrategy walletPayment = new WalletPayment("WALLET123");
        orderProcessor.processOrder(order2, walletPayment);
        System.out.println("Final Order Status: " + order2.getStatus() + "\n");

        System.out.println("=== Demo Complete ===");
    }
}

