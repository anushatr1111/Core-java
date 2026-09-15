import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class SalaryAggregation {

    // Domain model representation for real-world backend architectures
    static class Employee {
        private String name;
        private int salary;

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() { return name; }
        public int getSalary()   { return salary; }
    }

    public static void main(String[] args) {
        // --- Challenge 8: Interview Pipeline Problem ---
        System.out.println("=== Challenge 8: Salary Aggregation Pipeline ===");
        List<Integer> salaries = Arrays.asList(25000, 40000, 55000, 55000, 70000, 90000);
        System.out.println("Raw Salaries: " + salaries);

        // Single Stream Pipeline:
        // distinct() -> filter(s > 30000) -> mapToInt -> summaryStatistics()
        IntSummaryStatistics stats = salaries.stream()
                                             .distinct()
                                             .filter(s -> s > 30000)
                                             .mapToInt(Integer::intValue)
                                             .summaryStatistics();

        System.out.println("\n--- Filtered & Processed Results (salaries > 30,000, distinct) ---");
        System.out.println("Count   = " + stats.getCount());    // 4
        System.out.println("Sum     = " + stats.getSum());      // 255000
        System.out.println("Min     = " + stats.getMin());      // 40000
        System.out.println("Max     = " + stats.getMax());      // 90000
        System.out.printf ("Average = %.1f%n", stats.getAverage()); // 63750.0

        // --- Real-World Object Pipeline ---
        System.out.println("\n=== Real-World Employee List Aggregation ===");
        List<Employee> staff = Arrays.asList(
            new Employee("Aparajitha", 30000),
            new Employee("Priya",      45000),
            new Employee("Rahul",      60000),
            new Employee("Anu",        75000)
        );

        double totalStaffSalary = staff.stream()
                                       .mapToDouble(Employee::getSalary)
                                       .sum();
        double avgStaffSalary = staff.stream()
                                     .mapToDouble(Employee::getSalary)
                                     .average()
                                     .orElse(0.0);

        System.out.printf("Total Staff Payroll:   ₹%.2f%n", totalStaffSalary);
        System.out.printf("Average Staff Salary:  ₹%.2f%n", avgStaffSalary);
    }
}
