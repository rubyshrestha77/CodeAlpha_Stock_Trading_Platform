public class StockHolding {
    private String symbol;
    private int quantity;
    private double totalCost;

    public StockHolding(String symbol, double price, int quantity) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.totalCost = price * quantity;
    }

    public void addShares(int newQuantity, double price) {
        totalCost += price * newQuantity;
        quantity += newQuantity;
    }

    public void sellShares(int sellQuantity) {
        if (quantity >= sellQuantity) {
            quantity -= sellQuantity;
        } else {
            System.out.println("Not enough shares to sell.");
        }
    }

    public double getAverageBuyPrice() {
        return (quantity == 0) ? 0 : totalCost / quantity;
    }

    public double calculateProfit(double currentPrice) {
        return (currentPrice - getAverageBuyPrice()) * quantity;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }
}
