import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EmployeeLambdaSystem {

    // Higher-order helper method accepting Predicate lambda
    public static void filterAndDisplay(List<Employee> list, Predicate<Employee> condition, String label) {
        System.out.println("\n=== " + label + " ===");
        boolean found = false;
        for (Employee e : list) {
            if (condition.test(e)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching employee records found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pre-populate ArrayList<Employee>
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Aparajitha", 65000.0, 24));
        employees.add(new Employee(102, "Priya", 78000.0, 28));
        employees.add(new Employee(103, "Rahul", 48000.0, 23));
        employees.add(new Employee(104, "Anu", 92000.0, 31));
        employees.add(new Employee(105, "Karthik", 45000.0, 22));
        employees.add(new Employee(106, "Vikram", 85000.0, 35));

        int choice = 0;
        do {
            System.out.println("\n===== EMPLOYEE LAMBDA SYSTEM =====");
            System.out.println("1. Display All Employees");
            System.out.println("2. Sort By Name (Lambda)");
            System.out.println("3. Sort By Salary (Lambda)");
            System.out.println("4. Sort By Age (Lambda)");
            System.out.println("5. Find High Salary Employees (> 50,000) [Predicate]");
            System.out.println("6. Find Young Employees (< 25) [Predicate]");
            System.out.println("7. Display Only Names [Consumer]");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number 1-8.");
                sc.next(); // Consume invalid token
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\n--- All Employees ---");
                    employees.forEach(System.out::println);
                }
                case 2 -> {
                    // Sort by name alphabetically using lambda
                    employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
                    System.out.println("\n--- Employees Sorted by Name (A-Z) ---");
                    employees.forEach(System.out::println);
                }
                case 3 -> {
                    // Sort by salary descending using lambda
                    employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
                    System.out.println("\n--- Employees Sorted by Salary (High to Low) ---");
                    employees.forEach(System.out::println);
                }
                case 4 -> {
                    // Sort by age ascending using lambda
                    employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
                    System.out.println("\n--- Employees Sorted by Age (Ascending) ---");
                    employees.forEach(System.out::println);
                }
                case 5 -> {
                    // Predicate: salary > 50000
                    Predicate<Employee> highSalaryPredicate = e -> e.getSalary() > 50000;
                    filterAndDisplay(employees, highSalaryPredicate, "High Salary Employees (Salary > $50,000)");
                }
                case 6 -> {
                    // Predicate: age < 25
                    Predicate<Employee> youngEmployeePredicate = e -> e.getAge() < 25;
                    filterAndDisplay(employees, youngEmployeePredicate, "Young Employees (Age < 25)");
                }
                case 7 -> {
                    // Consumer: display only the employee's name
                    Consumer<Employee> nameConsumer = e -> System.out.println("• " + e.getName());
                    System.out.println("\n--- Employee Names Roster ---");
                    employees.forEach(nameConsumer);
                }
                case 8 -> System.out.println("\nThank you for using Employee Lambda System. Goodbye!");
                default -> System.out.println("Invalid choice! Please choose between 1 and 8.");
            }
        } while (choice != 8);

        sc.close();
    }
}
