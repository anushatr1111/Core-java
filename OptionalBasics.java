import java.util.Optional;

public class OptionalBasics {
    public static void main(String[] args) {

        // ─── 1. Optional.of() ─────────────────────────────────────────────────
        System.out.println("=== 1. Optional.of() ===");
        Optional<String> name1 = Optional.of("Aparajitha");
        System.out.println(name1);                  // Optional[Aparajitha]
        System.out.println(name1.get());            // Aparajitha

        // ─── 2. Optional.ofNullable() ─────────────────────────────────────────
        System.out.println("\n=== 2. Optional.ofNullable() ===");
        String nullName = null;
        Optional<String> name2 = Optional.ofNullable(nullName);
        System.out.println(name2);                  // Optional.empty

        Optional<String> name3 = Optional.ofNullable("Priya");
        System.out.println(name3);                  // Optional[Priya]

        // ─── 3. isPresent() ───────────────────────────────────────────────────
        System.out.println("\n=== 3. isPresent() ===");
        if (name1.isPresent()) {
            System.out.println("Value found: " + name1.get());
        }
        if (!name2.isPresent()) {
            System.out.println("name2 is empty");
        }

        // ─── 4. orElse() ──────────────────────────────────────────────────────
        System.out.println("\n=== 4. orElse() ===");
        String result1 = name2.orElse("Guest");
        System.out.println("name2.orElse(Guest) = " + result1);  // Guest

        String result2 = name3.orElse("Guest");
        System.out.println("name3.orElse(Guest) = " + result2);  // Priya

        // ─── 5. orElseGet() ───────────────────────────────────────────────────
        System.out.println("\n=== 5. orElseGet() ===");
        String result3 = name2.orElseGet(() -> "Default from Supplier");
        System.out.println("orElseGet = " + result3);

        // ─── 6. orElseThrow() ─────────────────────────────────────────────────
        System.out.println("\n=== 6. orElseThrow() ===");
        try {
            String result4 = name2.orElseThrow(
                () -> new RuntimeException("Name not found!")
            );
            System.out.println(result4);
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // ─── 7. Real-world usage ───────────────────────────────────────────────
        System.out.println("\n=== 7. Real-World Usage ===");
        String username = null;
        String displayName = Optional.ofNullable(username)
                                     .orElse("Guest");
        System.out.println("Logged in as: " + displayName);

        // Optional with findFirst()
        java.util.List<Integer> numbers =
            java.util.Arrays.asList(10, 20, 30, 40, 50);

        Optional<Integer> firstGt25 = numbers.stream()
                                              .filter(n -> n > 25)
                                              .findFirst();
        System.out.println("\nFirst number > 25: " + firstGt25.orElse(0));
    }
}
