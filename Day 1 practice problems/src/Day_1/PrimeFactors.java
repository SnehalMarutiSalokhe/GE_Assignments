import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to find prime factors:");
        int n = scanner.nextInt();

        if (n <= 1) {
            System.out.println("Enter a number greater than 1.");
        } else {
            System.out.print("Prime factors of " + n + " are: ");
            for (int i = 2; i * i <= n; i++) {
                while (n % i == 0) {
                    System.out.print(i + " ");
                    n /= i;
                }
            }
            if (n > 1) {
                System.out.print(n);
            }
            System.out.println();
        }
        scanner.close();
    }
}
