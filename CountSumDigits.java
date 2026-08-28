import java.util.Scanner;
public class CountSumDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        int sum = 0;
        int count=0;
        while (n > 0) {
            sum += n % 10;  
            count++;
            n /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Count of digits: " + count);
        sc.close();
    }
}
