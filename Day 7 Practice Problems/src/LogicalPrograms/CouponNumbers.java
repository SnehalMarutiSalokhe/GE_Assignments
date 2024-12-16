package LogicalPrograms;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

class CouponNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of distinct coupons: ");
        int n = sc.nextInt();
        HashSet<Integer> coupons = new HashSet<>();
        Random r = new Random();
        int count=0;
        while (coupons.size() < n) {
            int c = r.nextInt(100);
            coupons.add(c);
            count++;
        }

        System.out.println("Total random numbers needed: " + count);
        System.out.println("Distinct Coupons: " + coupons);
        sc.close();
    }
}