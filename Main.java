import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Market market = new Market();
        Portfolio portfolio = new Portfolio();

        // Adding sample stocks
        market.addStock("AAPL", "Apple Inc.", 150);
        market.addStock("TSLA", "Tesla Inc.", 600);
        market.addStock("AMZN", "Amazon Inc.", 3200);

        while (true) {
            System.out.println("\n1. View Market\n2. Buy Stock\n3. Sell Stock\n4. View Portfolio\n5. Update Market Prices\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    market.displayStocks();
                    break;
                case 2:
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = scanner.next().toUpperCase();
                    Stock stockToBuy = market.getStock(buySymbol);
                    if (stockToBuy != null) {
                        System.out.print("Enter quantity: ");
                        int buyQuantity = scanner.nextInt();
                        portfolio.buyStock(buySymbol, stockToBuy.getPrice(), buyQuantity);
                    } else {
                        System.out.println("Stock not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = scanner.next().toUpperCase();
                    System.out.print("Enter quantity: ");
                    int sellQuantity = scanner.nextInt();
                    portfolio.sellStock(sellSymbol, sellQuantity);
                    break;
                case 4:
                    portfolio.displayPortfolio(market);
                    break;
                case 5:
                    market.updatePrices();
                    System.out.println("Market prices updated!");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
