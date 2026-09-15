import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class SummaryStatisticsDemo {
    public static void main(String[] args) {
        // --- Challenge 5: Average of 10, 20, 30, 40, 50 ---
        System.out.println("=== Challenge 5: Average of numbers ===");
        double avg = IntStream.of(10, 20, 30, 40, 50)
                              .average()
                              .orElse(0.0);
        System.out.println("Average: " + avg); // Expected: 30.0

        // --- Challenge 6: IntSummaryStatistics ---
        System.out.println("\n=== Challenge 6: IntSummaryStatistics ===");
        IntSummaryStatistics stats = IntStream.of(10, 20, 30, 40, 50)
                                              .summaryStatistics();

        System.out.println("Count:   " + stats.getCount());   // 5
        System.out.println("Sum:     " + stats.getSum());     // 150
        System.out.println("Min:     " + stats.getMin());     // 10
        System.out.println("Max:     " + stats.getMax());     // 50
        System.out.println("Average: " + stats.getAverage()); // 30.0

        // Real-world: Store Daily Sales Summary
        System.out.println("\n=== Real-World Store Sales Summary ===");
        List<Integer> sales = Arrays.asList(1000, 2500, 3000, 1500, 4000);
        System.out.println("Daily invoices: " + sales);

        IntSummaryStatistics salesStats = sales.stream()
                                               .mapToInt(Integer::intValue)
                                               .summaryStatistics();

        System.out.println("------------------------------------");
        System.out.println("Total Transactions : " + salesStats.getCount());
        System.out.println("Gross Revenue      : ₹" + salesStats.getSum());
        System.out.println("Smallest Bill      : ₹" + salesStats.getMin());
        System.out.println("Largest Bill       : ₹" + salesStats.getMax());
        System.out.printf ("Average Ticket     : ₹%.2f%n", salesStats.getAverage());
        System.out.println("------------------------------------");
    }
}
