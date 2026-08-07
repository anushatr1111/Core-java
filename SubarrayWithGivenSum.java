import java.util.Scanner;
public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();
        findSubarrayWithGivenSum(nums, target);
        scanner.close();
    }
    public static void findSubarrayWithGivenSum(int[] nums, int target) {
        int currentSum = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];
            while (currentSum > target && start <= end) {
                currentSum -= nums[start];
                start++;
            }
            if (currentSum == target) {
                System.out.println("Subarray with the given sum found from index " + start + " to " + end);
                return;
            }
        }
        System.out.println("No subarray with the given sum found.");
    }
}
