import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterSortCollect {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(45, 12, 78, 23, 56, 9, 34, 67);

        System.out.println("Original List: " + numbers);

        // Pipeline: filter > 30 → sort ascending → collect
        List<Integer> ascendingResult = numbers.stream()
                .filter(n -> n > 30)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("\n=== Numbers > 30, Sorted Ascending ===");
        System.out.println(ascendingResult);

        // Pipeline: filter > 30 → sort descending → collect
        List<Integer> descendingResult = numbers.stream()
                .filter(n -> n > 30)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("\n=== Numbers > 30, Sorted Descending ===");
        System.out.println(descendingResult);

        // Bonus: complete pipeline shown step by step
        System.out.println("\n=== Step-by-step Pipeline Trace ===");
        System.out.println("Input:                 " + numbers);
        System.out.println("After filter(n > 30):  " +
                numbers.stream().filter(n -> n > 30).collect(Collectors.toList()));
        System.out.println("After sorted (asc):    " + ascendingResult);
        System.out.println("After sorted (desc):   " + descendingResult);
    }
}
