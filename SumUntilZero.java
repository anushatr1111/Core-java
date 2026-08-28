import java.util.*;
public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        System.out.print("Enter numbers (enter 0 to stop): ");
        int num = sc.nextInt();
        while (num != 0) {
            sum += num;
            num = sc.nextInt();
        }
        System.out.println("Sum of numbers entered is: " + sum);
        sc.close();
    }
}
