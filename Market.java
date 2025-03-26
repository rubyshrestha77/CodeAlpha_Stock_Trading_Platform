import java.util.HashMap;
import java.util.Random;

public class Market {
    private HashMap<String, Stock> stocks = new HashMap<>();
    private Random random = new Random();

    public void addStock(String symbol, String name, double price) {
        stocks.put(symbol, new Stock(symbol, name, price));
    }

    public void updatePrices() {
        for (Stock stock : stocks.values()) {
            double change = (random.nextDouble() - 0.5) * 10;
            stock.setPrice(Math.max(1, stock.getPrice() + change));
        }
    }

    public void displayStocks() {
        System.out.println("\nMarket Prices:");
        for (Stock stock : stocks.values()) {
            System.out.println(stock);
        }
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }
}
