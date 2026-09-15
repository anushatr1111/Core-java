import java.util.Arrays;
import java.util.List;

public class NoneMatchDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        System.out.println("Numbers: " + numbers);

        // Challenge 1: noneMatch — no negatives?
        boolean noNegatives = numbers.stream()
                                     .noneMatch(n -> n < 0);
        System.out.println("\n=== noneMatch(n < 0) — No negatives? ===");
        System.out.println(noNegatives); // true

        // noneMatch — none greater than 100?
        boolean noneGt100 = numbers.stream()
                                   .noneMatch(n -> n > 100);
        System.out.println("\n=== noneMatch(n > 100) — None greater than 100? ===");
        System.out.println(noneGt100); // true

        // noneMatch — none greater than 30? (should be false)
        boolean noneGt30 = numbers.stream()
                                  .noneMatch(n -> n > 30);
        System.out.println("\n=== noneMatch(n > 30) — None greater than 30? ===");
        System.out.println(noneGt30); // false (40, 50 exist)

        // Comparison table: anyMatch vs allMatch vs noneMatch
        System.out.println("\n=== anyMatch vs allMatch vs noneMatch (n > 25) ===");
        System.out.println("anyMatch (at least one > 25) : " + numbers.stream().anyMatch(n -> n > 25));
        System.out.println("allMatch (all > 25)          : " + numbers.stream().allMatch(n -> n > 25));
        System.out.println("noneMatch (none > 25)        : " + numbers.stream().noneMatch(n -> n > 25));

        // Short-circuiting demo — noneMatch stops at first match
        System.out.println("\n=== Short-Circuiting Demo ===");
        boolean result = numbers.stream()
                .noneMatch(n -> {
                    System.out.println("  Checking: " + n);
                    return n > 25;
                });
        System.out.println("Result: " + result);
        System.out.println("(Stopped as soon as 30 matched — 40 and 50 were not checked)");
    }
}
