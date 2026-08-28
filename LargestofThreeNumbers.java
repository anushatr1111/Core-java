import java.util.*;
public class LargestofThreeNumbers {
    static int findLargest(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter the third number: ");
        int num3 = scanner.nextInt();

        int largest = findLargest(num1, num2, num3);
        System.out.println("The largest of the three numbers is: " + largest);
    }
}
