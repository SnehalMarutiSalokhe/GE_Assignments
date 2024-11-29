import java.util.Scanner;

public class TripletsSumZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of integers (N): ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean found = false;
        System.out.println("Triplets that sum to zero are:");
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((arr[i] + arr[j] + arr[k]) == 0) {
                        System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k]);
                        found = true;
                    }
                }
            }
        }

        if (!found) {
            System.out.println("No such triplets found.");
        }
        sc.close();
    }
}
