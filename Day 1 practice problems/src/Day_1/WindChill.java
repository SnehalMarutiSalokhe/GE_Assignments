import java.util.Scanner;

public class WindChill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature (in Fahrenheit, t): ");
        double t = sc.nextDouble();
        System.out.print("Enter wind speed (in miles per hour, v): ");
        double v = sc.nextDouble();

        if (t > 50 || v < 3 || v > 120) {
            System.out.println("Invalid input values. Ensure t <= 50, 3 <= v <= 120.");
        } else {
            double windChill = 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * Math.pow(v, 0.16);
            System.out.println("Effective temperature (Wind Chill): " + windChill);
        }
        sc.close();
    }
}
