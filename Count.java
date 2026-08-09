import java.util.Scanner;
public class Count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                count++;
            }
        }
        System.out.println("Count of even numbers from 1 to " + n + " is: " + count);
        int oddCount = n - count;
        System.out.println("Count of odd numbers from 1 to " + n + " is: " + oddCount);
        sc.close();
    }
}
