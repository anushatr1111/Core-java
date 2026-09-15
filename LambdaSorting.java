import java.util.ArrayList;
import java.util.Arrays;

public class LambdaSorting {
    public static void main(String[] args) {
        // --- 1. Integer Sorting with Lambdas ---
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(50, 10, 40, 20, 30));

        System.out.println("=== 1. Integer Sorting ===");
        System.out.println("Original Numbers: " + numbers);

        // Sort ascending using lambda
        numbers.sort((a, b) -> a - b);
        System.out.println("Ascending Sort:  " + numbers);

        // Sort descending using lambda
        numbers.sort((a, b) -> b - a);
        System.out.println("Descending Sort: " + numbers);

        // --- 2. String Sorting with Lambdas (Bonus) ---
        ArrayList<String> names = new ArrayList<>(Arrays.asList(
            "Aparajitha", "Priya", "Rahul", "Anu", "Karthik"
        ));

        System.out.println("\n=== 2. String Sorting (Bonus) ===");
        System.out.println("Original Names: " + names);

        // Sort by alphabetical order
        names.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("Alphabetical:   " + names);

        // Sort by name length
        names.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("By Name Length: " + names);

        // Sort by length descending, then alphabetical for ties
        names.sort((s1, s2) -> {
            int lenComp = Integer.compare(s2.length(), s1.length());
            return lenComp != 0 ? lenComp : s1.compareTo(s2);
        });
        System.out.println("Length Descending (ties alphabetical): " + names);
    }
}
