package objectOrientedPrograms;

import java.util.*;
import java.time.LocalDateTime;

class CompanyShares {
    String symbol;
    int numberOfShares;
    double sharePrice;
    LocalDateTime dateTime;

    public CompanyShares(String symbol, int numberOfShares, double sharePrice) {
        this.symbol = symbol;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
        this.dateTime = LocalDateTime.now();
    }

    public double getValue() {
        return numberOfShares * sharePrice;
    }

    @Override
    public String toString() {
        return "Symbol: " + symbol + ", Shares: " + numberOfShares + ", Share Price: $" + sharePrice +
                ", Transaction Time: " + dateTime;
    }
}

public class StockAccount {
    private List<CompanyShares> sharesList;

    public StockAccount(String filename) {
        sharesList = new ArrayList<>();
        System.out.println("Stock account created from file: " + filename);
    }

    public double valueOf() {
        double totalValue = 0;
        for (CompanyShares shares : sharesList) {
            totalValue += shares.getValue();
        }
        return totalValue;
    }

    public void buy(int amount, String symbol) {
        for (CompanyShares shares : sharesList) {
            if (shares.symbol.equalsIgnoreCase(symbol)) {
                shares.numberOfShares += amount;
                shares.dateTime = LocalDateTime.now();
                System.out.println("Bought " + amount + " shares of " + symbol);
                return;
            }
        }

        sharesList.add(new CompanyShares(symbol, amount, 100.00));
        System.out.println("New stock added: " + symbol + " with " + amount + " shares.");
    }

    public void sell(int amount, String symbol) {
        for (CompanyShares shares : sharesList) {
            if (shares.symbol.equalsIgnoreCase(symbol)) {
                if (shares.numberOfShares >= amount) {
                    shares.numberOfShares -= amount;
                    shares.dateTime = LocalDateTime.now();
                    System.out.println("Sold " + amount + " shares of " + symbol);
                } else {
                    System.out.println("Error: Not enough shares to sell.");
                }
                return;
            }
        }
        System.out.println("Error: Stock with symbol " + symbol + " not found.");
    }

    public void save(String filename) {
        System.out.println("Stock account saved to file: " + filename);
    }

    public void printReport() {
        System.out.println("Stock Account Report:");
        for (CompanyShares shares : sharesList) {
            System.out.println(shares);
        }
        System.out.println("Total Account Value: $" + valueOf());
    }

    public static void main(String[] args) {

        StockAccount obj1 = new StockAccount("stocks.txt");
        obj1.buy(10, "AAPL");
        obj1.buy(5, "TSLA");
        obj1.sell(3, "AAPL");
        obj1.printReport();
        obj1.save("stocks_updated.txt");
    }
}