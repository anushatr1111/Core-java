import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceAdvanced {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 20, 30, 40, 40, 50, 60);

        System.out.println("Numbers: " + numbers);

        // --- Challenge 1: Sum using reduce() ---
        System.out.println("\n=== Challenge 1: Sum using reduce() ===");
        // Form 1: With identity value 0
        int sumWithIdentity = numbers.stream()
                                     .reduce(0, (a, b) -> a + b);
        System.out.println("Sum (with identity 0): " + sumWithIdentity); // Expected: 270

        // Form 2: Without identity (returns Optional<Integer>)
        Optional<Integer> sumOptional = numbers.stream()
                                               .reduce((a, b) -> a + b);
        System.out.println("Sum (Optional):         " + sumOptional.orElse(0));

        // --- Challenge 2: Product of 2 x 3 x 4 x 5 using reduce() ---
        System.out.println("\n=== Challenge 2: Product of 2, 3, 4, 5 ===");
        List<Integer> factors = Arrays.asList(2, 3, 4, 5);
        int product = factors.stream()
                             .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product); // Expected: 120 (2 * 3 * 4 * 5)

        // Custom Reduction: Maximum and Minimum using reduce
        System.out.println("\n=== Custom Reduction: Max & Min ===");
        int max = numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        int min = numbers.stream().reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
        System.out.println("Max via reduce: " + max);
        System.out.println("Min via reduce: " + min);

        // String Concatenation using reduce with identity ""
        System.out.println("\n=== String Concatenation with reduce ===");
        List<String> words = Arrays.asList("Java", "Stream", "API", "Rocks");
        String concatenated = words.stream().reduce("", (a, b) -> a.isEmpty() ? b : a + " " + b);
        System.out.println("Sentence: " + concatenated);
    }
}
