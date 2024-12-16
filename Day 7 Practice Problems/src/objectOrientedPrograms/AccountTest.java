package objectOrientedPrograms;
class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void debit(double amount) {
        if (amount > balance) {
            System.out.println("Debit amount exceeded account balance.");
        } else {
            balance -= amount;
            System.out.println("Debited: $" + amount);
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account obj1 = new Account(500);
        System.out.println("Initial Balance: $" + obj1.getBalance());
        obj1.debit(600);
        obj1.debit(200);
        System.out.println("Final Balance: $" + obj1.getBalance());
    }
}