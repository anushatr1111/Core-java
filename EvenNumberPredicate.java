import java.util.function.Predicate;

public class EvenNumberPredicate {
    public static void main(String[] args) {
        // Predicate checking whether a number is even
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // Predicate checking whether a number is greater than 50
        Predicate<Integer> isGreaterThan50 = n -> n > 50;

        int[] testNumbers = {10, 15, 22, 31, 40};

        System.out.println("=== Even Number Predicate Test ===");
        for (int num : testNumbers) {
            System.out.println(num + " -> " + isEven.test(num));
        }

        System.out.println("\n=== Greater Than 50 Predicate Test ===");
        int[] moreNumbers = {25, 50, 75, 100};
        for (int num : moreNumbers) {
            System.out.println(num + " > 50 -> " + isGreaterThan50.test(num));
        }

        // Combining predicates with .and()
        Predicate<Integer> isEvenAndGreaterThan50 = isEven.and(isGreaterThan50);
        System.out.println("\n=== Combined Predicate: Even AND > 50 ===");
        int[] combinedTests = {40, 52, 65, 80};
        for (int num : combinedTests) {
            System.out.println(num + " (Even & >50) -> " + isEvenAndGreaterThan50.test(num));
        }
    }
}
