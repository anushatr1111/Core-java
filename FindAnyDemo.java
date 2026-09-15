import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAnyDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        System.out.println("Numbers: " + numbers);

        // findFirst() — always first element
        System.out.println("\n=== findFirst() ===");
        Optional<Integer> first = numbers.stream().findFirst();
        System.out.println("findFirst(): " + first);
        System.out.println("Value:       " + first.orElse(0));

        // findAny() — any element (sequential → usually first)
        System.out.println("\n=== findAny() ===");
        Optional<Integer> any = numbers.stream().findAny();
        System.out.println("findAny():   " + any);

        // Challenge 2: findAny — number greater than 40
        System.out.println("\n=== Challenge 2: findAny — number > 40 ===");
        Optional<Integer> anyGt40 = numbers.stream()
                .filter(n -> n > 40)
                .findAny();
        System.out.println("Any number > 40: " + anyGt40.orElse(-1));

        // findFirst() vs findAny() comparison
        System.out.println("\n=== findFirst() vs findAny() comparison ===");
        System.out.println("findFirst(n > 20): " +
                numbers.stream().filter(n -> n > 20).findFirst().orElse(-1));
        System.out.println("findAny(n > 20):   " +
                numbers.stream().filter(n -> n > 20).findAny().orElse(-1));

        // Empty stream — orElse safety
        System.out.println("\n=== Empty Stream safety with orElse ===");
        Optional<Integer> none = numbers.stream()
                .filter(n -> n > 1000)
                .findFirst();
        System.out.println("Found > 1000: " + none.isPresent());
        System.out.println("orElse(-1):   " + none.orElse(-1));

        // String findFirst() example
        System.out.println("\n=== String findFirst() example ===");
        List<String> names = Arrays.asList("Aparajitha", "Priya", "Rahul", "Anu");
        String firstLong = names.stream()
                .filter(n -> n.length() > 4)
                .findFirst()
                .orElse("None found");
        System.out.println("First name with > 4 chars: " + firstLong);
    }
}
