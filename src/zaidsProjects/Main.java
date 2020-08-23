package zaidsProjects;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.68, 100);
        stockList.addStock(temp);
        temp = new StockItem("Cake", 1.10, 7);
        stockList.addStock(temp);
        temp = new StockItem("Car", 12.5, 20);
        stockList.addStock(temp);
        temp = new StockItem("Chair", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("Cup", 0.42, 127);
        stockList.addStock(temp);
        temp = new StockItem("Door", 72.10, 120);
        stockList.addStock(temp);
        temp = new StockItem("Phone", 96.43, 21);
        stockList.addStock(temp);
        System.out.println(stockList);

        Basket ZaidsBasket = new Basket("Zaid");
        sellItem(ZaidsBasket, "Cup", 20);

    }

    public static int sellItem(Basket basket, String item, int quntity) {
        StockItem inStock = stockList.get(item);
        if (inStock == null) {
            System.out.println("we don't sell this item");
            return 0;
        }
        if (stockList.sellStock(item, quntity) != 0) {
            basket.addStockItems(inStock, quntity);
            return quntity;
        }
        return 0;
    }

}
