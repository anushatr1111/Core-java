import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeAnalyticsSystem {

    static class Emp {
        int id;
        String name;
        int age;
        double salary;

        Emp(int id, String name, int age, double salary) {
            this.id     = id;
            this.name   = name;
            this.age    = age;
            this.salary = salary;
        }

        public String getName()   { return name; }
        public int    getAge()    { return age; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return String.format("[%2d] %-14s | Age: %2d | Salary: ₹%.0f",
                    id, name, age, salary);
        }
    }

    // ─── utility ──────────────────────────────────────────────────────────────

    static void printBanner(String title) {
        System.out.println();
        System.out.println("┌─────────────────────────────────────────────┐");
        System.out.printf ("│  %-43s│%n", title);
        System.out.println("└─────────────────────────────────────────────┘");
    }

    static void printResults(List<Emp> list) {
        if (list.isEmpty()) {
            System.out.println("  (no employees match this criteria)");
        } else {
            list.forEach(e -> System.out.println("  " + e));
        }
    }

    // ─── main ─────────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        List<Emp> employees = Arrays.asList(
            new Emp( 1, "Aparajitha", 22, 45000),
            new Emp( 2, "Priya",      27, 60000),
            new Emp( 3, "Rahul",      24, 35000),
            new Emp( 4, "Anu",        23, 52000),
            new Emp( 5, "Kavin",      30, 75000),
            new Emp( 6, "Meena",      26, 48000),
            new Emp( 7, "Arjun",      21, 40000),
            new Emp( 8, "Divya",      29, 80000),
            new Emp( 9, "Suresh",     32, 95000),
            new Emp(10, "Lakshmi",    25, 55000)
        );

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n╔══════════════════════════════════╗");
            System.out.println("║   EMPLOYEE ANALYTICS SYSTEM 🔥   ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║  1.  Display All Employees        ║");
            System.out.println("║  2.  High Salary Employees        ║");
            System.out.println("║  3.  Employees Under 25           ║");
            System.out.println("║  4.  Sort By Salary               ║");
            System.out.println("║  5.  Sort By Name                 ║");
            System.out.println("║  6.  Display Employee Names       ║");
            System.out.println("║  7.  Total Salary                 ║");
            System.out.println("║  8.  Average Salary               ║");
            System.out.println("║  9.  Highest Salary               ║");
            System.out.println("║  10. Count Employees              ║");
            System.out.println("║  11. Exit                         ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("  Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1 -> {
                    printBanner("All Employees");
                    printResults(employees);
                }

                case 2 -> {
                    // filter() — salary > 50000
                    printBanner("High Salary Employees (> ₹50,000)");
                    List<Emp> highSalary = employees.stream()
                            .filter(e -> e.getSalary() > 50000)
                            .collect(Collectors.toList());
                    printResults(highSalary);
                }

                case 3 -> {
                    // filter() — age < 25
                    printBanner("Employees Under 25");
                    List<Emp> youngEmployees = employees.stream()
                            .filter(e -> e.getAge() < 25)
                            .collect(Collectors.toList());
                    printResults(youngEmployees);
                }

                case 4 -> {
                    // sorted() by salary ascending
                    printBanner("Employees Sorted by Salary (Ascending)");
                    List<Emp> bySalary = employees.stream()
                            .sorted(Comparator.comparingDouble(Emp::getSalary))
                            .collect(Collectors.toList());
                    printResults(bySalary);
                }

                case 5 -> {
                    // sorted() by name alphabetically
                    printBanner("Employees Sorted by Name (A → Z)");
                    List<Emp> byName = employees.stream()
                            .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                            .collect(Collectors.toList());
                    printResults(byName);
                }

                case 6 -> {
                    // map() + collect() — names only
                    printBanner("Employee Names");
                    List<String> names = employees.stream()
                            .map(Emp::getName)
                            .collect(Collectors.toList());
                    names.forEach(n -> System.out.println("  → " + n));
                }

                case 7 -> {
                    // mapToDouble().sum()
                    printBanner("Total Salary");
                    double total = employees.stream()
                            .mapToDouble(Emp::getSalary)
                            .sum();
                    System.out.printf("  Total = ₹%.2f%n", total);
                }

                case 8 -> {
                    // mapToDouble().average()
                    printBanner("Average Salary");
                    double avg = employees.stream()
                            .mapToDouble(Emp::getSalary)
                            .average()
                            .orElse(0);
                    System.out.printf("  Average = ₹%.2f%n", avg);
                }

                case 9 -> {
                    // reduce() — find highest salary
                    printBanner("Highest Salary Employee");
                    Optional<Emp> highest = employees.stream()
                            .reduce((a, b) -> a.getSalary() > b.getSalary() ? a : b);
                    highest.ifPresentOrElse(
                        e -> System.out.println("  " + e),
                        () -> System.out.println("  (no employees)")
                    );
                }

                case 10 -> {
                    // stream().count()
                    printBanner("Employee Count");
                    long count = employees.stream().count();
                    System.out.println("  Total Employees: " + count);
                }

                case 11 -> System.out.println("\n  Goodbye! 👋");

                default -> System.out.println("  ⚠  Invalid choice. Please enter 1-11.");
            }

        } while (choice != 11);

        scanner.close();
    }
}
