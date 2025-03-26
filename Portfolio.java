import java.util.HashMap;

public class Portfolio {
    private HashMap<String, StockHolding> holdings = new HashMap<>();

    public void buyStock(String symbol, double price, int quantity) {
        if (holdings.containsKey(symbol)) {
            holdings.get(symbol).addShares(quantity, price);
        } else {
            holdings.put(symbol, new StockHolding(symbol, price, quantity));
        }
    }

    public void sellStock(String symbol, int quantity) {
        if (holdings.containsKey(symbol)) {
            holdings.get(symbol).sellShares(quantity);
            if (holdings.get(symbol).getQuantity() == 0) {
                holdings.remove(symbol);
            }
        } else {
            System.out.println("Stock not found in portfolio.");
        }
    }

    public double calculatePortfolioValue(Market market) {
        double totalValue = 0;
        for (String symbol : holdings.keySet()) {
            Stock stock = market.getStock(symbol);
            if (stock != null) {
                totalValue += stock.getPrice() * holdings.get(symbol).getQuantity();
            }
        }
        return totalValue;
    }

    public double calculateProfitOrLoss(Market market) {
        double totalProfit = 0;
        for (String symbol : holdings.keySet()) {
            Stock stock = market.getStock(symbol);
            if (stock != null) {
                totalProfit += holdings.get(symbol).calculateProfit(stock.getPrice());
            }
        }
        return totalProfit;
    }

    public void displayPortfolio(Market market) {
        System.out.println("\nYour Portfolio:");
        for (StockHolding holding : holdings.values()) {
            Stock stock = market.getStock(holding.getSymbol());
            if (stock != null) {
                System.out.println(holding.getSymbol() + ": " + holding.getQuantity() + " shares @ $" +
                        stock.getPrice() + " | Bought at $" + holding.getAverageBuyPrice() +
                        " | P/L: $" + holding.calculateProfit(stock.getPrice()));
            }
        }
        System.out.println("Total Portfolio Value: $" + String.format("%.2f", calculatePortfolioValue(market)));
        System.out.println("Total Profit/Loss: $" + String.format("%.2f", calculateProfitOrLoss(market)));
    }
}
