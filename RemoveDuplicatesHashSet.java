import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesHashSet {
    public static void main(String[] args) {
        // Problem 3: Remove Duplicates Using HashSet
        int[] numbers = {10, 20, 10, 30, 20, 40, 50, 30};

        // Print original array
        System.out.println("Original:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + (i < numbers.length - 1 ? " " : ""));
        }
        System.out.println();

        // Use HashSet (LinkedHashSet to preserve insertion order) to remove duplicates
        HashSet<Integer> uniqueNumbers = new LinkedHashSet<>();
        for (int num : numbers) {
            uniqueNumbers.add(num);
        }

        // Print unique elements
        System.out.println("\nUnique:");
        int count = 0;
        int size = uniqueNumbers.size();
        for (int num : uniqueNumbers) {
            System.out.print(num + (++count < size ? " " : ""));
        }
        System.out.println();

        // Print the number of unique elements
        System.out.println("\nNumber of unique elements: " + uniqueNumbers.size());
    }
}
