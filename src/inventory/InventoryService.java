package inventory;

import model.Product;
import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<Product, Integer> stock;

    public InventoryService() {
        this.stock = new HashMap<>();
    }

    public void addStock(Product product, int quantity) {
        stock.put(product, stock.getOrDefault(product, 0) + quantity);
    }

    public boolean reserve(Product product, int quantity) {
        int available = stock.getOrDefault(product, 0);
        if (available >= quantity) {
            stock.put(product, available - quantity);
            return true;
        }
        return false;
    }

    public int getAvailableStock(Product product) {
        return stock.getOrDefault(product, 0);
    }
}

