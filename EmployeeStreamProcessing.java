import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeStreamProcessing {

    // Inner Employee class (self-contained for this file)
    static class Emp {
        int id;
        String name;
        int age;
        double salary;

        Emp(int id, String name, int age, double salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName()   { return name; }
        public int    getAge()    { return age; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return String.format("%-12s | Age: %2d | Salary: ₹%.0f", name, age, salary);
        }
    }

    public static void main(String[] args) {
        List<Emp> employees = Arrays.asList(
            new Emp(1, "Aparajitha", 22, 45000),
            new Emp(2, "Priya",      27, 60000),
            new Emp(3, "Rahul",      24, 35000),
            new Emp(4, "Anu",        23, 52000),
            new Emp(5, "Kavin",      30, 75000),
            new Emp(6, "Meena",      26, 48000)
        );

        System.out.println("=== All Employees ===");
        employees.forEach(System.out::println);

        // Task 1: High Salary (> 50000)
        System.out.println("\n=== Task 1: Salary > 50,000 ===");
        employees.stream()
                 .filter(e -> e.getSalary() > 50000)
                 .forEach(System.out::println);

        // Task 2: Young Employees (age < 25)
        System.out.println("\n=== Task 2: Age < 25 ===");
        employees.stream()
                 .filter(e -> e.getAge() < 25)
                 .forEach(System.out::println);

        // Task 3: Names only (map + collect)
        System.out.println("\n=== Task 3: Names Only (map + collect) ===");
        List<String> names = employees.stream()
                                      .map(Emp::getName)
                                      .collect(Collectors.toList());
        System.out.println(names);

        // Task 4: Sort by Salary Ascending
        System.out.println("\n=== Task 4: Sorted by Salary (Ascending) ===");
        employees.stream()
                 .sorted(Comparator.comparingDouble(Emp::getSalary))
                 .forEach(System.out::println);

        // Task 5: Average Salary
        double avgSalary = employees.stream()
                                    .mapToDouble(Emp::getSalary)
                                    .average()
                                    .orElse(0);
        System.out.printf("%n=== Task 5: Average Salary ===%n₹%.2f%n", avgSalary);
    }
}
