package zaidsProjects;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addStockItems(StockItem item, int quntity) {
        if ((item != null) && (quntity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quntity);
            return inBasket;
        }
        return 0;
    }

    public  Map<StockItem, Integer> items()
    {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\n Basket List \n";
        double totalCosts = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + "there  are " + item.getValue() + " in stock. vlaue of items ";
            totalCosts += item.getKey().getPrice() * item.getValue();

        }
        return s + "Total stock value " + totalCosts;
    }
}
