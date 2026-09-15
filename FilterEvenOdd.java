import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenOdd {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35, 40, 45, 50);

        System.out.println("=== Even Numbers ===");
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(System.out::println);

        System.out.println("\n=== Odd Numbers ===");
        numbers.stream()
               .filter(n -> n % 2 != 0)
               .forEach(System.out::println);

        long evenCount = numbers.stream()
                                .filter(n -> n % 2 == 0)
                                .count();

        long oddCount = numbers.stream()
                               .filter(n -> n % 2 != 0)
                               .count();

        System.out.println("\nEven count: " + evenCount);
        System.out.println("Odd count:  " + oddCount);

        // Collect even numbers into a new List
        List<Integer> evens = numbers.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("\nEven numbers collected: " + evens);
    }
}
