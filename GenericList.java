import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PROBLEM 1 — Generic List
 * 
 * Demonstrates:
 * - Creating a generic List<Integer> with ArrayList<Integer>
 * - Adding 10 integers
 * - Using for-each loops instead of traditional index-based loops
 * - Computing sum, largest, smallest, even count, and odd count
 */
public class GenericList {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("        PROBLEM 1 - Generic List          ");
        System.out.println("==========================================\n");

        // 1. Create a generic List of Integers
        List<Integer> numbers = new ArrayList<>();

        // 2. Add 10 integers
        Collections.addAll(numbers, 25, 14, 89, 4, 62, 77, 30, 95, 18, 51);

        // 3. Print all numbers using for-each
        System.out.print("Numbers in the list: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        // 4. Find sum using for-each
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        // 5. Find largest and smallest using for-each
        int largest = numbers.get(0);
        int smallest = numbers.get(0);
        for (int num : numbers) {
            if (num > largest) {
                largest = num;
            }
            if (num < smallest) {
                smallest = num;
            }
        }

        // 6. Count even and odd numbers using for-each
        int evenCount = 0;
        int oddCount = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // Display results
        System.out.println("---------------- Results -----------------");
        System.out.println("Total elements : " + numbers.size());
        System.out.println("Sum            : " + sum);
        System.out.println("Largest        : " + largest);
        System.out.println("Smallest       : " + smallest);
        System.out.println("Even numbers   : " + evenCount);
        System.out.println("Odd numbers    : " + oddCount);
        System.out.println("------------------------------------------");
    }
}
