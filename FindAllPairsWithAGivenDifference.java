import java.util.*;

public class FindAllPairsWithAGivenDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Enter the target difference: ");
        int targetDiff = scanner.nextInt();
        findPairsWithGivenDifference(nums, targetDiff);
        scanner.close();
    }
    public static void findPairsWithGivenDifference(int[] nums, int targetDiff) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        boolean found = false;
        System.out.println("Pairs with the given difference:");
        for (int num : nums) {
            if (set.contains(num + targetDiff)) {
                System.out.println("(" + num + ", " + (num + targetDiff) + ")");
                found = true;
            }
            if (set.contains(num - targetDiff)) {
                System.out.println("(" + num + ", " + (num - targetDiff) + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No pairs found with the given difference.");
        }
    }    
}
