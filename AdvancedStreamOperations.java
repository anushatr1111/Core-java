import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdvancedStreamOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 20, 30, 40, 40, 50, 60);

        System.out.println("Original list: " + numbers);

        // ─── Challenge 1: distinct → sorted → skip(2) → limit(3) → print ──────
        System.out.println("\n=== Challenge 1: distinct → sorted → skip(2) → limit(3) ===");
        System.out.println("Pipeline trace:");
        System.out.println("  After distinct(): " +
                numbers.stream().distinct().collect(Collectors.toList()));
        System.out.println("  After sorted():   " +
                numbers.stream().distinct().sorted().collect(Collectors.toList()));
        System.out.println("  After skip(2):    " +
                numbers.stream().distinct().sorted().skip(2).collect(Collectors.toList()));
        System.out.println("  After limit(3):   " +
                numbers.stream().distinct().sorted().skip(2).limit(3).collect(Collectors.toList()));

        System.out.println("\nResult:");
        numbers.stream()
               .distinct()
               .sorted()
               .skip(2)
               .limit(3)
               .forEach(System.out::println);

        // ─── Challenge 2: findFirst() > 50 ────────────────────────────────────
        System.out.println("\n=== Challenge 2: First number > 50 (findFirst) ===");
        Optional<Integer> firstGt50 = numbers.stream()
                .filter(n -> n > 50)
                .findFirst();
        System.out.println("First number > 50: " + firstGt50.orElse(-1));

        // ─── Challenge 3: anyMatch — any number > 100 ─────────────────────────
        System.out.println("\n=== Challenge 3: anyMatch — any number > 100? ===");
        boolean anyGt100 = numbers.stream()
                .anyMatch(n -> n > 100);
        System.out.println("Any number > 100: " + anyGt100);   // false

        // ─── Challenge 4: allMatch — all numbers > 5 ──────────────────────────
        System.out.println("\n=== Challenge 4: allMatch — all numbers > 5? ===");
        boolean allGt5 = numbers.stream()
                .allMatch(n -> n > 5);
        System.out.println("All numbers > 5: " + allGt5);      // true

        // ─── Bonus Operations ─────────────────────────────────────────────────
        System.out.println("\n=== Bonus: limit() and skip() standalone ===");
        System.out.print("limit(3): ");
        numbers.stream().limit(3).forEach(n -> System.out.print(n + " "));

        System.out.print("\nskip(5):  ");
        numbers.stream().skip(5).forEach(n -> System.out.print(n + " "));

        System.out.println("\n\n=== Bonus: anyMatch vs allMatch comparison ===");
        System.out.println("anyMatch(n > 50)  → " + numbers.stream().anyMatch(n -> n > 50));
        System.out.println("allMatch(n > 50)  → " + numbers.stream().allMatch(n -> n > 50));
        System.out.println("anyMatch(n > 0)   → " + numbers.stream().anyMatch(n -> n > 0));
        System.out.println("allMatch(n > 0)   → " + numbers.stream().allMatch(n -> n > 0));

        // ─── Product Search (real-world distinct + limit) ──────────────────────
        System.out.println("\n=== Real-World: Product Search ===");
        List<String> products = Arrays.asList(
                "Laptop", "Phone", "Laptop", "Tablet", "Monitor", "Phone");
        System.out.println("Distinct first 3 products:");
        products.stream()
                .distinct()
                .limit(3)
                .forEach(p -> System.out.println("  " + p));

        // ─── Age validation (real-world anyMatch / allMatch) ───────────────────
        System.out.println("\n=== Real-World: Age Validation ===");
        List<Integer> ages = Arrays.asList(22, 25, 30, 27);
        System.out.println("Any under 18? → " + ages.stream().anyMatch(a -> a < 18));
        System.out.println("All adults?   → " + ages.stream().allMatch(a -> a >= 18));
    }
}
