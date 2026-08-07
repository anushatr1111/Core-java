import java.util.Scanner;
public class TwoSum {
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
        int[] result = twoSum(nums, target);
        
        if (result != null) {
            System.out.println("Indices of the two numbers that add up to the target: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two numbers found that add up to the target.");
        }
        scanner.close();
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // Return null if no solution is found
    }
}
