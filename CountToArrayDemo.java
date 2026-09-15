import java.util.Arrays;
import java.util.List;

public class CountToArrayDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 20, 30, 40, 40, 50, 60);

        System.out.println("Original numbers: " + numbers);

        // --- Challenge 5: count() elements > 25 ---
        System.out.println("\n=== Challenge 5: count() elements > 25 ===");
        long totalCount = numbers.stream().count();
        System.out.println("Total count: " + totalCount);

        long countGt25 = numbers.stream()
                                .filter(n -> n > 25)
                                .count();
        System.out.println("Count of numbers > 25: " + countGt25); // Expected: 5 (30, 40, 40, 50, 60)

        // --- Challenge 6: toArray() ---
        System.out.println("\n=== Challenge 6: toArray() ===");
        // Method 1: Default Object[]
        Object[] objArray = numbers.stream().toArray();
        System.out.println("Object[] array: " + Arrays.toString(objArray));

        // Method 2: Typed array Integer[] with constructor reference
        Integer[] typedArray = numbers.stream().toArray(Integer[]::new);
        System.out.println("Integer[] array: " + Arrays.toString(typedArray));

        // Method 3: Primitive array int[] via mapToInt
        int[] primitiveArray = numbers.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("int[] primitive array: " + Arrays.toString(primitiveArray));
    }
}
