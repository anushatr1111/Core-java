import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class PrimitiveStreamsDemo {
    public static void main(String[] args) {
        // --- 1. LongStream Demo ---
        System.out.println("=== 1. LongStream Operations ===");
        long longSum = LongStream.of(100L, 200L, 300L).sum();
        System.out.println("LongStream sum: " + longSum);

        System.out.print("LongStream.range(1, 6): ");
        LongStream.range(1, 6).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // --- 2. DoubleStream Demo ---
        System.out.println("\n=== 2. DoubleStream Operations ===");
        double doubleSum = DoubleStream.of(10.5, 20.5, 30.5).sum();
        System.out.println("DoubleStream sum: " + doubleSum); // 61.5

        OptionalDouble doubleAvg = DoubleStream.of(10.5, 20.5, 30.5).average();
        System.out.println("DoubleStream average: " + doubleAvg.orElse(0.0)); // 20.5

        // --- 3. Real-World: Order Values Aggregation ---
        System.out.println("\n=== 3. Real-World: E-Commerce Order Values ===");
        List<Double> orders = Arrays.asList(499.50, 1200.00, 750.25, 3000.00, 850.75);
        System.out.println("Orders: " + orders);

        double totalOrders = orders.stream()
                                   .mapToDouble(Double::doubleValue)
                                   .sum();
        double avgOrders = orders.stream()
                                 .mapToDouble(Double::doubleValue)
                                 .average()
                                 .orElse(0.0);
        double maxOrder = orders.stream()
                                .mapToDouble(Double::doubleValue)
                                .max()
                                .orElse(0.0);
        double minOrder = orders.stream()
                                .mapToDouble(Double::doubleValue)
                                .min()
                                .orElse(0.0);

        System.out.printf("Total Sales:   ₹%.2f%n", totalOrders);
        System.out.printf("Average Order: ₹%.2f%n", avgOrders);
        System.out.printf("Highest Order: ₹%.2f%n", maxOrder);
        System.out.printf("Lowest Order:  ₹%.2f%n", minOrder);

        // DoubleSummaryStatistics
        DoubleSummaryStatistics orderStats = orders.stream()
                                                   .mapToDouble(Double::doubleValue)
                                                   .summaryStatistics();
        System.out.println("\nStats object: " + orderStats);
    }
}
