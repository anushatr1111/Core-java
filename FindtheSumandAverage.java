import java.util.Scanner;
public class FindtheSumandAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        double average = (double) sum / size;
        System.out.println("Sum of the array elements is: " + sum);
        System.out.println("Average of the array elements is: " + average);
    }
}
