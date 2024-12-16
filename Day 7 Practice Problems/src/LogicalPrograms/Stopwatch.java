package LogicalPrograms;
import java.util.Scanner;

class Stopwatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Press Enter to start...");
        sc.nextLine();
        long start = System.currentTimeMillis();

        System.out.println("Press Enter to stop...");
        sc.nextLine();
        long end = System.currentTimeMillis();

        long elapsed = end - start;
        System.out.println("Elapsed Time: " + elapsed + " ms");
    }
}


