import java.util.HashMap;

public class Portfolio {
    private HashMap<String, Integer> holdings = new HashMap<>();

    public void buyStock(String symbol, int quantity) {
        holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
    }

    public void sellStock(String symbol, int quantity) {
        if (holdings.containsKey(symbol) && holdings.get(symbol) >= quantity) {
            holdings.put(symbol, holdings.get(symbol) - quantity);
            if (holdings.get(symbol) == 0) {
                holdings.remove(symbol);
            }
        } else {
            System.out.println("Not enough stock to sell.");
        }
    }

    public void displayPortfolio() {
        System.out.println("Your Portfolio:");
        for (String symbol : holdings.keySet()) {
            System.out.println(symbol + ": " + holdings.get(symbol) + " shares");
        }
    }
}
