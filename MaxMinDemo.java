import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaxMinDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 50, 30, 90, 20);
        List<Integer> salaries = Arrays.asList(30000, 45000, 60000, 80000, 100000);

        System.out.println("Numbers: " + numbers);

        // Challenge 3: max()
        System.out.println("\n=== Challenge 3: max() ===");
        Optional<Integer> maxOpt = numbers.stream().max(Integer::compareTo);
        System.out.println("Max (Optional): " + maxOpt);
        System.out.println("Max value:      " + maxOpt.orElse(0));

        // Challenge 4: min()
        System.out.println("\n=== Challenge 4: min() ===");
        Optional<Integer> minOpt = numbers.stream().min(Integer::compareTo);
        System.out.println("Min (Optional): " + minOpt);
        System.out.println("Min value:      " + minOpt.orElse(0));

        // max() after filter
        System.out.println("\n=== Max of numbers > 25 ===");
        int maxGt25 = numbers.stream()
                .filter(n -> n > 25)
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println("Max number > 25: " + maxGt25);

        // Real-world: Highest & Lowest salary
        System.out.println("\n=== Real-World: Employee Salaries ===");
        System.out.println("Salaries: " + salaries);
        int highest = salaries.stream().max(Integer::compareTo).orElse(0);
        int lowest  = salaries.stream().min(Integer::compareTo).orElse(0);
        System.out.println("Highest salary: ₹" + highest);
        System.out.println("Lowest salary:  ₹" + lowest);

        // max() with Comparator.comparingInt
        System.out.println("\n=== max() with Comparator.comparingInt ===");
        List<String> names = Arrays.asList("Anu", "Aparajitha", "Priya", "Karthik");
        String longest = names.stream()
                .max(java.util.Comparator.comparingInt(String::length))
                .orElse("");
        String shortest = names.stream()
                .min(java.util.Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("Longest name:  " + longest);
        System.out.println("Shortest name: " + shortest);
    }
}
