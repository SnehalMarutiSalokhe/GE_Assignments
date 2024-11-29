import java.util.Scanner;

public class FlipCoin {
    public static  void flipCoins(int flips){

        if (flips <= 0) {
            System.out.println("Number of flips must be a positive integer.");
            return;
        }

        int heads = 0;
        for (int i = 0; i < flips; i++) {
            if (Math.random() < 0.5) {
                heads++;
            }
        }
        int tails = flips - heads;
        System.out.printf("Heads: %.2f%%\n", (heads * 100.0) / flips);
        System.out.printf("Tails: %.2f%%\n", (tails * 100.0) / flips);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of times to flip the coin:");
        int flips = scanner.nextInt();
        flipCoins(flips);
        scanner.close();
    }
}
