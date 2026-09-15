import java.util.Arrays;
import java.util.List;

public class ReduceOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        System.out.println("Numbers: " + numbers);

        // Task 1: Sum
        int sum = numbers.stream()
                         .reduce(0, (a, b) -> a + b);
        System.out.println("\n=== Task 1: Sum ===");
        System.out.println("Sum = " + sum);

        // Task 2: Product
        int product = numbers.stream()
                             .reduce(1, (a, b) -> a * b);
        System.out.println("\n=== Task 2: Product ===");
        System.out.println("Product = " + product);

        // Task 3: Maximum using reduce
        int max = numbers.stream()
                         .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println("\n=== Task 3: Maximum (using reduce) ===");
        System.out.println("Maximum = " + max);

        // Bonus: Minimum using reduce
        int min = numbers.stream()
                         .reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
        System.out.println("\n=== Bonus: Minimum (using reduce) ===");
        System.out.println("Minimum = " + min);

        // Bonus: Verify using built-in methods
        System.out.println("\n=== Verification ===");
        System.out.println("mapToInt().sum()    = " + numbers.stream().mapToInt(n -> n).sum());
        System.out.println("mapToInt().max()    = " + numbers.stream().mapToInt(n -> n).max().orElse(0));
        System.out.println("mapToInt().min()    = " + numbers.stream().mapToInt(n -> n).min().orElse(0));
        System.out.println("mapToInt().average()= " + numbers.stream().mapToInt(n -> n).average().orElse(0));
    }
}
