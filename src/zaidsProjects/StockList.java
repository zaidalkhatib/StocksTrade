package zaidsProjects;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = list.get(item.getName());
            if (inStock != null) {
                item.adjustStock(inStock.getQuantityStock());
            }
            list.put(item.getName(), item);
            return item.getQuantityStock();
        }
        return 0;
    }

    public int sellStock(String item, int quntity) {
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock != null) && (inStock.getQuantityStock() >= quntity) && (quntity > 0)) {
            inStock.adjustStock(-quntity);
            return quntity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }
    public Map<String, StockItem> items() {
        return Collections.unmodifiableMap(list);

    }

    @Override
    public String toString() {
        String s = "\n Stock List \n";
        double totalCosts = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.getQuantityStock();
            s = s + stockItem + "there  are " + stockItem.getQuantityStock() + " in stock. vlaue of items ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCosts += itemValue;

        }
        return s + "Total stock value " + totalCosts;
    }
}
