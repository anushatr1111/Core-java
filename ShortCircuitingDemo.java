import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ShortCircuitingDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        System.out.println("Original numbers: " + numbers);

        // 1. anyMatch short-circuiting: stops at first true
        System.out.println("\n=== 1. anyMatch Short-Circuiting (target: n > 25) ===");
        boolean any = numbers.stream().peek(n -> System.out.println("  Inspecting for anyMatch: " + n))
                             .anyMatch(n -> n > 25);
        System.out.println("Result: " + any + " (Notice it stops after 30!)");

        // 2. allMatch short-circuiting: stops at first false
        System.out.println("\n=== 2. allMatch Short-Circuiting (target: n > 25) ===");
        boolean all = numbers.stream().peek(n -> System.out.println("  Inspecting for allMatch: " + n))
                             .allMatch(n -> n > 25);
        System.out.println("Result: " + all + " (Notice it stops immediately after 10!)");

        // 3. noneMatch short-circuiting: stops at first match found
        System.out.println("\n=== 3. noneMatch Short-Circuiting (target: n > 25) ===");
        boolean none = numbers.stream().peek(n -> System.out.println("  Inspecting for noneMatch: " + n))
                              .noneMatch(n -> n > 25);
        System.out.println("Result: " + none + " (Stops after 30!)");

        // 4. findFirst short-circuiting: stops after first accepted item
        System.out.println("\n=== 4. findFirst Short-Circuiting (target: filter n > 25) ===");
        Optional<Integer> first = numbers.stream()
                .peek(n -> System.out.println("  Pipeline processing: " + n))
                .filter(n -> n > 25)
                .findFirst();
        System.out.println("Result: " + first.orElse(-1) + " (Pipeline halted right at 30!)");

        // 5. Lazy Evaluation proof: without terminal operation, nothing runs!
        System.out.println("\n=== 5. Lazy Evaluation Demonstration ===");
        System.out.println("Setting up intermediate pipeline without terminal operation...");
        numbers.stream().filter(n -> {
            System.out.println("  [Lazy check] Filter running on: " + n);
            return n > 20;
        });
        System.out.println("Notice: No filter prints appeared above because intermediate ops are LAZY!");
    }
}
