import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamDemo {
    public static void main(String[] args) {
        // --- Challenge 3: rangeClosed(1, 10) ---
        System.out.println("=== Challenge 3: IntStream.rangeClosed(1, 10) ===");
        System.out.print("Numbers 1 to 10: ");
        IntStream.rangeClosed(1, 10).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Interview Comparison: range vs rangeClosed
        System.out.println("\n=== range(1, 5) vs rangeClosed(1, 5) ===");
        System.out.print("range(1, 5) (exclusive end):       ");
        IntStream.range(1, 5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.print("rangeClosed(1, 5) (inclusive end): ");
        IntStream.rangeClosed(1, 5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // --- Challenge 4: Sum of 1 to 100 ---
        System.out.println("\n=== Challenge 4: Sum of numbers from 1 to 100 ===");
        int sum100 = IntStream.rangeClosed(1, 100).sum();
        System.out.println("Sum of 1..100: " + sum100); // Expected: 5050 (n * (n+1) / 2 = 100 * 101 / 2)

        // --- Challenge 7: boxed() -> List<Integer> ---
        System.out.println("\n=== Challenge 7: boxed() IntStream to List<Integer> ===");
        List<Integer> boxedList = IntStream.rangeClosed(1, 5)
                                           .boxed()
                                           .collect(Collectors.toList());
        System.out.println("Collected List<Integer>: " + boxedList);
        System.out.println("Type of element:         " + boxedList.get(0).getClass().getName());
    }
}
