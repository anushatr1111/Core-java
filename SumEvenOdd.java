import java.util.*;
public class SumEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sumEven += i;
            } else {
                sumOdd += i;
            }
        }
        System.out.println("Sum of even numbers from 1 to " + n + ": " + sumEven);
        System.out.println("Sum of odd numbers from 1 to " + n + ": " + sumOdd);
        sc.close();
    }
}
