import java.util.*;
public class PrintAllSubsetsofAnArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println("All subsets of the array:");
        printSubsets(nums, 0, new ArrayList<>());
        scanner.close();
    }
    public static void printSubsets(int[] nums, int index, List<Integer> current) {
        if (index == nums.length) {
            System.out.println(current);
            return;
        }
        // Exclude the current element
        printSubsets(nums, index + 1, current);
        // Include the current element
        current.add(nums[index]);
        printSubsets(nums, index + 1, current);
        // Backtrack
        current.remove(current.size() - 1);
    }
}
