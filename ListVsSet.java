import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * PROBLEM 2 - List vs Set
 * 
 * Demonstrates:
 * - Differences between List and Set collections in Java
 * - Inserting duplicate elements into both collections
 * - Observing size differences and element uniqueness
 */
public class ListVsSet {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("         PROBLEM 2 - List vs Set          ");
        System.out.println("==========================================\n");

        // 1. Declare collections
        List<Integer> numbers = new ArrayList<>();
        // LinkedHashSet maintains insertion order while removing duplicates
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();

        // 2. Input array with duplicate values
        int[] values = {10, 20, 10, 30, 20, 40, 50, 30};

        // 3. Put values into both collections
        for (int val : values) {
            numbers.add(val);
            uniqueNumbers.add(val);
        }

        // 4. Print both collections
        System.out.println("List:");
        System.out.println(numbers);
        System.out.println();

        System.out.println("Set:");
        System.out.println(uniqueNumbers);
        System.out.println();

        // 5. Print collection sizes
        System.out.println("List size: " + numbers.size());
        System.out.println("Set size: " + uniqueNumbers.size());
        System.out.println();

        // 6. Understanding why the sizes are different
        System.out.println("------------------------------------------");
        System.out.println("[UNDERSTAND] Why are the sizes different?");
        System.out.println("------------------------------------------");
        System.out.println("1. List (ArrayList):");
        System.out.println("   - Allows duplicate elements.");
        System.out.println("   - Retains all 8 inserted values: 10, 20, 10, 30, 20, 40, 50, 30.");
        System.out.println("   - Resulting List size: " + numbers.size());
        System.out.println();
        System.out.println("2. Set (LinkedHashSet):");
        System.out.println("   - Does NOT allow duplicate elements (guarantees uniqueness).");
        System.out.println("   - When duplicate values (10, 20, 30) were added, the Set simply discarded them.");
        System.out.println("   - Resulting Set size: " + uniqueNumbers.size() + " (only unique values: 10, 20, 30, 40, 50).");
        System.out.println("------------------------------------------");
    }
}
