import java.util.Scanner;

public class Distance {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x:");
        int x = sc.nextInt();
        System.out.print("Enter y:");
        int y = sc.nextInt();

        double distance = Math.sqrt((x * x) + (y * y));
        System.out.println("Distance from point (" + x + ", " + y + ") to origin (0, 0) is: " + distance);
    }
}
