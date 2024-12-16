package objectOrientedPrograms;

public class Stock {
    private String stockName;
    private int numberOfShares;
    private double sharePrice;

    public Stock(String stockName, int numberOfShares, double sharePrice) {
        this.stockName = stockName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public double calculateStockValue() {
        return numberOfShares * sharePrice;
    }

    public String getStockName() {
        return stockName;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public double getSharePrice() {
        return sharePrice;
    }
}
