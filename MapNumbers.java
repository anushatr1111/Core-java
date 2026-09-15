import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("=== Task 1: Multiply each number by 2 ===");
        numbers.stream()
               .map(n -> n * 2)
               .forEach(System.out::println);

        System.out.println("\n=== Task 2: Square each number ===");
        numbers.stream()
               .map(n -> n * n)
               .forEach(System.out::println);

        System.out.println("\n=== Task 3: Collect squared values into a List ===");
        List<Integer> squared = numbers.stream()
                                       .map(n -> n * n)
                                       .collect(Collectors.toList());
        System.out.println("Squared List: " + squared);

        System.out.println("\n=== Bonus: String representation (n -> 'Square of n = n*n') ===");
        numbers.stream()
               .map(n -> "Square of " + n + " = " + (n * n))
               .forEach(System.out::println);
    }
}
