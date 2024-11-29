import java.util.Scanner;

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the power value N (0 <= N < 31):");
        int n = scanner.nextInt();

        if (n < 0 || n >= 31) {
            System.out.println("N must be in the range 0 <= N < 31.");
        } else {
            int power = 1;
            for (int i = 0; i <= n; i++) {
                System.out.println("2^" + i + " = " + power);
                power *= 2;
            }
        }
        scanner.close();
    }
}
