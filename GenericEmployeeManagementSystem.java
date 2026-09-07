import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// ==========================================================
// Custom Exception Classes (Exception Handling - Day 31)
// ==========================================================
class DuplicateEmployeeException extends Exception {
    public DuplicateEmployeeException(String message) {
        super(message);
    }
}

class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

class InvalidEmployeeDataException extends Exception {
    public InvalidEmployeeDataException(String message) {
        super(message);
    }
}

/**
 * BOSS CHALLENGE — Generic Employee Management System
 * 
 * Features:
 * - List<Employee> for ordered storage and sorting
 * - Set<Integer> for maintaining unique employee IDs
 * - Map<Integer, Employee> for fast O(1) employee lookup
 * - Comparator for custom sorting strategies (Salary & Name)
 * - Exception Handling for runtime validation
 * - Encapsulation and Constructors
 */
public class GenericEmployeeManagementSystem {

    // Collections
    private List<Employee> employeeList;
    private Set<Integer> employeeIds;
    private Map<Integer, Employee> employeeMap;

    public GenericEmployeeManagementSystem() {
        this.employeeList = new ArrayList<>();
        this.employeeIds = new HashSet<>();
        this.employeeMap = new HashMap<>();

        // Seed with initial sample employees from prompt
        seedInitialEmployees();
    }

    // Pre-populate with sample employees matching the challenge prompt
    private void seedInitialEmployees() {
        addInitialEmployee(103, "Rahul", 23, 25000);
        addInitialEmployee(104, "Anu", 21, 35000);
        addInitialEmployee(101, "Aparajitha", 22, 45000);
        addInitialEmployee(102, "Priya", 24, 55000);
    }

    private void addInitialEmployee(int id, String name, int age, double salary) {
        Employee emp = new Employee(id, name, age, salary);
        employeeList.add(emp);
        employeeIds.add(id);
        employeeMap.put(id, emp);
    }

    // 1. Add Employee
    public void addEmployee(Scanner scanner) throws DuplicateEmployeeException, InvalidEmployeeDataException {
        System.out.print("\nEmployee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (id <= 0) {
            throw new InvalidEmployeeDataException("Employee ID must be a positive integer.");
        }

        // Set<Integer> check for unique employee IDs
        if (employeeIds.contains(id)) {
            throw new DuplicateEmployeeException("Employee with ID " + id + " already exists!");
        }

        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            throw new InvalidEmployeeDataException("Employee name cannot be empty.");
        }

        System.out.print("Age: ");
        int age = scanner.nextInt();
        if (age < 18 || age > 100) {
            throw new InvalidEmployeeDataException("Age must be between 18 and 100.");
        }

        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        if (salary <= 0) {
            throw new InvalidEmployeeDataException("Salary must be greater than zero.");
        }

        // Create new Employee using Encapsulation and Constructor
        Employee newEmployee = new Employee(id, name, age, salary);

        // Synchronize across all 3 collections
        employeeList.add(newEmployee);
        employeeIds.add(id);
        employeeMap.put(id, newEmployee);

        System.out.println("\nEmployee added successfully!");
    }

    // 2. Remove Employee
    public void removeEmployee(Scanner scanner) throws EmployeeNotFoundException {
        System.out.print("\nEnter Employee ID to remove: ");
        int id = scanner.nextInt();

        // Check ID existence using Set or Map
        if (!employeeMap.containsKey(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found!");
        }

        // Remove from Map (O(1)) and Set
        Employee removedEmp = employeeMap.remove(id);
        employeeIds.remove(id);
        employeeList.remove(removedEmp);

        System.out.println("Employee '" + removedEmp.getName() + "' (ID: " + id + ") removed successfully!");
    }

    // 3. Search Employee using Map for quick O(1) lookup
    public void searchEmployee(Scanner scanner) throws EmployeeNotFoundException {
        System.out.print("\nEnter employee ID: ");
        int id = scanner.nextInt();

        // Map<Integer, Employee> for quick ID lookup
        Employee emp = employeeMap.get(id);
        if (emp == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found!");
        }

        System.out.println("\n--- Employee Details ---");
        System.out.println("Employee: " + emp.getName());
        System.out.println("ID      : " + emp.getId());
        System.out.println("Age     : " + emp.getAge());
        System.out.println(String.format("Salary  : ₹%.0f", emp.getSalary()));
    }

    // 4. Display All Employees
    public void displayAllEmployees() {
        System.out.println("\n===== ALL EMPLOYEES =====");
        if (employeeList.isEmpty()) {
            System.out.println("No employees currently registered.");
            return;
        }

        System.out.printf("%-8s %-16s %-6s %-12s%n", "ID", "Name", "Age", "Salary");
        System.out.println("----------------------------------------------");
        for (Employee emp : employeeList) {
            System.out.printf("%-8d %-16s %-6d ₹%-10.0f%n",
                    emp.getId(), emp.getName(), emp.getAge(), emp.getSalary());
        }
        System.out.println("Total Employees: " + employeeList.size());
    }

    // 5. Update Salary
    public void updateSalary(Scanner scanner) throws EmployeeNotFoundException, InvalidEmployeeDataException {
        System.out.print("\nEnter Employee ID to update salary: ");
        int id = scanner.nextInt();

        // O(1) lookup via Map
        Employee emp = employeeMap.get(id);
        if (emp == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found!");
        }

        System.out.printf("Current salary of %s: ₹%.0f%n", emp.getName(), emp.getSalary());
        System.out.print("Enter new salary: ");
        double newSalary = scanner.nextDouble();

        if (newSalary <= 0) {
            throw new InvalidEmployeeDataException("Salary must be greater than zero.");
        }

        emp.setSalary(newSalary);
        System.out.printf("Salary updated successfully! New Salary: ₹%.0f%n", emp.getSalary());
    }

    // 6. Sort By Salary (Ascending) using Comparator
    public void sortBySalary() {
        if (employeeList.isEmpty()) {
            System.out.println("\nNo employees to sort.");
            return;
        }

        // Custom Comparator for salary (ascending order)
        Comparator<Employee> salaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        };

        Collections.sort(employeeList, salaryComparator);

        System.out.println("\nEmployees sorted by salary:\n");
        for (Employee emp : employeeList) {
            System.out.printf("%-12s ₹%.0f%n", emp.getName(), emp.getSalary());
        }
    }

    // 7. Sort By Name (Alphabetical) using Comparator
    public void sortByName() {
        if (employeeList.isEmpty()) {
            System.out.println("\nNo employees to sort.");
            return;
        }

        // Custom Comparator for name (alphabetical order)
        Comparator<Employee> nameComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareToIgnoreCase(e2.getName());
            }
        };

        Collections.sort(employeeList, nameComparator);

        System.out.println("\nEmployees sorted by name:\n");
        for (Employee emp : employeeList) {
            System.out.printf("%-12s (ID: %d, Age: %d, Salary: ₹%.0f)%n",
                    emp.getName(), emp.getId(), emp.getAge(), emp.getSalary());
        }
    }

    public static void main(String[] args) {
        GenericEmployeeManagementSystem system = new GenericEmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Update Salary");
            System.out.println("6. Sort By Salary");
            System.out.println("7. Sort By Name");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        system.addEmployee(scanner);
                        break;
                    case 2:
                        system.removeEmployee(scanner);
                        break;
                    case 3:
                        system.searchEmployee(scanner);
                        break;
                    case 4:
                        system.displayAllEmployees();
                        break;
                    case 5:
                        system.updateSalary(scanner);
                        break;
                    case 6:
                        system.sortBySalary();
                        break;
                    case 7:
                        system.sortByName();
                        break;
                    case 8:
                        System.out.println("\nThank you for using Employee Management System. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("\nInvalid choice! Please select an option between 1 and 8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[Error] Invalid input format! Please enter a valid number.");
                scanner.nextLine(); // clear invalid input from buffer
            } catch (DuplicateEmployeeException | EmployeeNotFoundException | InvalidEmployeeDataException e) {
                System.out.println("\n[Error] " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\n[Unexpected Error] " + e.getMessage());
            }
        }

        scanner.close();
    }
}
