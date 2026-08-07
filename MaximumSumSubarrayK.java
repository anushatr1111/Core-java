import java.util.Scanner;

public class MaximumSumSubarrayK {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();
        int result = -1;
        // Check if k is valid
        if (k > arr.length) {
            System.out.println("Invalid value of k");
        }

        // Calculate sum of first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        result = maxSum;

        if (result != -1) {
            System.out.println("Maximum Sum of Subarray of Size " + k + " = " + result);
        }

        sc.close();
    }
}