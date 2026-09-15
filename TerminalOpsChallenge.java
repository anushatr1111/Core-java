import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TerminalOpsChallenge {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 20, 30, 40, 40, 50, 60);

        System.out.println("Input List: " + numbers);

        // --- Challenge 7: Find first unique number greater than 25 ---
        System.out.println("\n=== Challenge 7: First Unique Number Greater Than 25 ===");
        Optional<Integer> firstUniqueGt25 = numbers.stream()
                .distinct()
                .filter(n -> n > 25)
                .findFirst();

        System.out.println("Pipeline: distinct() -> filter(n > 25) -> findFirst()");
        System.out.println("Result: " + firstUniqueGt25.orElse(-1)); // Expected: 30

        // --- Interview Bonus 1: Maximum even number greater than 25 ---
        System.out.println("\n=== Bonus 1: Maximum Even Number > 25 ===");
        Optional<Integer> maxEvenGt25 = numbers.stream()
                .filter(n -> n > 25)
                .filter(n -> n % 2 == 0)
                .max(Integer::compareTo);
        System.out.println("Max Even Number > 25: " + maxEvenGt25.orElse(-1)); // Expected: 60

        // --- Interview Bonus 2: Stream Reuse Trap Demo ---
        System.out.println("\n=== Bonus 2: Stream Cannot Be Reused Demo ===");
        try {
            var stream = numbers.stream();
            long count = stream.count();
            System.out.println("First consumption (count): " + count);
            // Reusing the same stream will throw IllegalStateException
            stream.forEach(System.out::println);
        } catch (IllegalStateException e) {
            System.out.println("Caught Expected Exception on Stream reuse: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
