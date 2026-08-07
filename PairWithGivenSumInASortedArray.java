import java.util.Scanner;
public class PairWithGivenSumInASortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the sorted array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();
        boolean found = false;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                found = true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        if (found) {
            System.out.println("Pair with the given sum found.");
        } else {
            System.out.println("No pair with the given sum found.");
        }
        scanner.close();
    }
    
}
