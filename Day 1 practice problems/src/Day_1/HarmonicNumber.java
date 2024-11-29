import java.util.Scanner;

public class HarmonicNumber {
    public static double harmonicNo(int n) {
        double ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += (1.0 / i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");

        int n = sc.nextInt(); // Read input

        if (n <= 0) {
            System.out.println("Enter a valid number greater than 0");
        } else {
            System.out.printf("Harmonic number is: %.6f%n", harmonicNo(n));
        }

        sc.close();
    }
}
