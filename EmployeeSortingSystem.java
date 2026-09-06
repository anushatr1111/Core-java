import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

// Custom Exception for empty employee list
class EmptyEmployeeListException extends Exception {
    public EmptyEmployeeListException(String message) {
        super(message);
    }
}

// Custom Exception for invalid employee attributes
class InvalidEmployeeDataException extends Exception {
    public InvalidEmployeeDataException(String message) {
        super(message);
    }
}

public class EmployeeSortingSystem {

    // Store employees in ArrayList<Employee>
    private ArrayList<Employee> employees;

    public EmployeeSortingSystem() {
        this.employees = new ArrayList<>();
        seedInitialEmployees();
    }

    // Pre-populate with sample employees from prompt
    private void seedInitialEmployees() {
        employees.add(new Employee(1, "Rahul", 25000, 24));
        employees.add(new Employee(2, "Anu", 35000, 26));
        employees.add(new Employee(3, "Aparajitha", 45000, 28));
        employees.add(new Employee(4, "Priya", 55000, 30));
    }

    // Method 1: Add Employee with validation & exception handling
    public void addEmployee(Scanner scanner) {
        System.out.println("\n--- Add New Employee ---");
        try {
            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            // Check for duplicate ID
            for (Employee emp : employees) {
                if (emp.getId() == id) {
                    throw new InvalidEmployeeDataException("Employee with ID " + id + " already exists!");
                }
            }

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                throw new InvalidEmployeeDataException("Employee name cannot be empty.");
            }

            System.out.print("Enter Employee Salary (₹): ");
            double salary = scanner.nextDouble();
            if (salary <= 0) {
                throw new InvalidEmployeeDataException("Salary must be greater than zero.");
            }

            System.out.print("Enter Employee Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (age <= 0 || age > 100) {
                throw new InvalidEmployeeDataException("Age must be between 1 and 100.");
            }

            // Create and add employee object
            Employee newEmp = new Employee(id, name, salary, age);
            employees.add(newEmp);
            System.out.println("\nEmployee added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("\nError: Invalid input format! Please enter valid numeric values for ID, Salary, and Age.");
            scanner.nextLine(); // clear buffer
        } catch (InvalidEmployeeDataException e) {
            System.out.println("\nError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nUnexpected error occurred: " + e.getMessage());
        }
    }

    // Method 2: Display Employees using for-each
    public void displayEmployees() throws EmptyEmployeeListException {
        checkEmptyList();
        System.out.println("\n==================== ALL EMPLOYEES ====================");
        System.out.printf("%-6s %-16s %-12s %-6s\n", "ID", "Name", "Salary", "Age");
        System.out.println("-------------------------------------------------------");
        for (Employee emp : employees) {
            System.out.printf("%-6d %-16s ₹%-11.0f %-6d\n", emp.getId(), emp.getName(), emp.getSalary(), emp.getAge());
        }
        System.out.println("=======================================================");
    }

    // Method 3: Sort by Salary using Comparator
    public void sortBySalary() throws EmptyEmployeeListException {
        checkEmptyList();

        // Custom Comparator for salary (ascending)
        Comparator<Employee> salaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        };

        Collections.sort(employees, salaryComparator);

        System.out.println("\nEmployees sorted by salary:\n");
        for (Employee emp : employees) {
            System.out.printf("%-12s ₹%.0f\n", emp.getName(), emp.getSalary());
        }
    }

    // Method 4: Sort by Name using Comparator
    public void sortByName() throws EmptyEmployeeListException {
        checkEmptyList();

        // Custom Comparator for name (alphabetical)
        Comparator<Employee> nameComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareToIgnoreCase(e2.getName());
            }
        };

        Collections.sort(employees, nameComparator);

        System.out.println("\nEmployees sorted by name:");
        for (Employee emp : employees) {
            System.out.println(emp.getName());
        }
    }

    // Method 5: Sort by Age using Comparator
    public void sortByAge() throws EmptyEmployeeListException {
        checkEmptyList();

        // Custom Comparator for age (ascending)
        Comparator<Employee> ageComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        };

        Collections.sort(employees, ageComparator);

        System.out.println("\nEmployees sorted by age:\n");
        for (Employee emp : employees) {
            System.out.printf("%-12s %d years (₹%.0f)\n", emp.getName(), emp.getAge(), emp.getSalary());
        }
    }

    // Method 6: Highest Salary
    public void displayHighestSalary() throws EmptyEmployeeListException {
        checkEmptyList();

        Employee highestSalaryEmployee = employees.get(0);
        for (Employee emp : employees) {
            if (emp.getSalary() > highestSalaryEmployee.getSalary()) {
                highestSalaryEmployee = emp;
            }
        }

        System.out.println("\nEmployee with Highest Salary:");
        System.out.printf("%-12s ₹%.0f (Age: %d, ID: %d)\n",
                highestSalaryEmployee.getName(),
                highestSalaryEmployee.getSalary(),
                highestSalaryEmployee.getAge(),
                highestSalaryEmployee.getId());
    }

    // Helper to validate non-empty collection
    private void checkEmptyList() throws EmptyEmployeeListException {
        if (employees.isEmpty()) {
            throw new EmptyEmployeeListException("No employees available in the system.");
        }
    }

    // Main Method with interactive console menu and switch statement
    public static void main(String[] args) {
        EmployeeSortingSystem system = new EmployeeSortingSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Sort by Salary");
            System.out.println("4. Sort by Name");
            System.out.println("5. Sort by Age");
            System.out.println("6. Highest Salary");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        system.addEmployee(scanner);
                        break;
                    case 2:
                        system.displayEmployees();
                        break;
                    case 3:
                        system.sortBySalary();
                        break;
                    case 4:
                        system.sortByName();
                        break;
                    case 5:
                        system.sortByAge();
                        break;
                    case 6:
                        system.displayHighestSalary();
                        break;
                    case 7:
                        System.out.println("\nThank you for using Employee Management System! Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("\nInvalid choice! Please choose an option between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError: Please enter a valid numerical choice (1-7).");
                scanner.nextLine(); // clear invalid input
            } catch (EmptyEmployeeListException e) {
                System.out.println("\nNotice: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\nUnexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}