import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// ==========================================================
// Custom Exception Hierarchy
// ==========================================================
class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

class DuplicateEmployeeException extends Exception {
    public DuplicateEmployeeException(String message) {
        super(message);
    }
}

class InvalidLeaveException extends Exception {
    public InvalidLeaveException(String message) {
        super(message);
    }
}

/**
 * 👑 BOSS CHALLENGE — Employee Leave Management System
 * 
 * Combines:
 * - OOP: Classes, Objects, Constructors, Encapsulation (Employee)
 * - Collections: ArrayList<Employee> & HashMap<Integer, Employee>
 * - File Handling: Persistent reading and writing to employee_leaves.txt
 * - Modern java.time API: LocalDate, DateTimeFormatter, Period, ChronoUnit
 * - Exception Handling: Custom exceptions & robust input validation
 * - Modular design with Methods and Switch statements
 */
public class EmployeeLeaveManagementSystem {
    private static final String FILE_NAME = "employee_leaves.txt";
    private static final DateTimeFormatter DISPLAY_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Collections
    private List<Employee> employeeList;
    private Map<Integer, Employee> employeeMap;

    public EmployeeLeaveManagementSystem() {
        this.employeeList = new ArrayList<>();
        this.employeeMap = new HashMap<>();
        loadEmployeesFromFile();
    }

    // ==========================================================
    // File Handling: Load employees from file
    // ==========================================================
    private void loadEmployeesFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            // Seed initial sample employees if file doesn't exist yet
            seedDefaultEmployees();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        LocalDate joiningDate = LocalDate.parse(parts[2].trim(), INPUT_FORMAT);

                        Employee emp = new Employee(id, name, joiningDate);
                        employeeList.add(emp);
                        employeeMap.put(id, emp);
                    } catch (Exception e) {
                        // Skip malformed record
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Warning: Could not read " + FILE_NAME + ": " + e.getMessage());
        }

        // If file was empty, provide default seed records
        if (employeeList.isEmpty()) {
            seedDefaultEmployees();
        }
    }

    private void seedDefaultEmployees() {
        addAndPersistEmployee(new Employee(101, "Aparajitha", LocalDate.of(2025, 6, 15)));
        addAndPersistEmployee(new Employee(102, "Priya", LocalDate.of(2024, 8, 20)));
    }

    private void addAndPersistEmployee(Employee emp) {
        if (!employeeMap.containsKey(emp.getId())) {
            employeeList.add(emp);
            employeeMap.put(emp.getId(), emp);
            appendEmployeeToFile(emp);
        }
    }

    private void appendEmployeeToFile(Employee emp) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(emp.getId() + "," + emp.getName() + "," + emp.getJoiningDate().format(INPUT_FORMAT) + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Warning: Could not save employee to file: " + e.getMessage());
        }
    }

    // ==========================================================
    // 1️⃣ Add Employee
    // ==========================================================
    public void addEmployee(Scanner sc) {
        try {
            System.out.print("Employee ID: ");
            String idStr = sc.nextLine().trim();
            int id = Integer.parseInt(idStr);

            if (id <= 0) {
                System.out.println("Error: Employee ID must be a positive number.");
                return;
            }

            if (employeeMap.containsKey(id)) {
                throw new DuplicateEmployeeException("Employee with ID " + id + " already exists!");
            }

            System.out.print("Name: ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Error: Name cannot be empty.");
                return;
            }

            System.out.print("Joining Date (yyyy-MM-dd): ");
            String dateStr = sc.nextLine().trim();
            LocalDate joiningDate = LocalDate.parse(dateStr, INPUT_FORMAT);

            Employee newEmp = new Employee(id, name, joiningDate);
            employeeList.add(newEmp);
            employeeMap.put(id, newEmp);
            appendEmployeeToFile(newEmp);

            System.out.println("\nEmployee added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid ID! Please enter a valid numeric ID.");
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format! Please use yyyy-MM-dd (e.g., 2025-06-15).");
        } catch (DuplicateEmployeeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ==========================================================
    // 2️⃣ Display Employees
    // ==========================================================
    public void displayEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees registered.");
            return;
        }

        System.out.println("\n----- Employee Records -----");
        for (Employee emp : employeeList) {
            String formattedDate = emp.getJoiningDate().format(DISPLAY_FORMAT);
            System.out.println(emp.getId() + " - " + emp.getName() + " - Joined: " + formattedDate);
        }
    }

    // ==========================================================
    // 3️⃣ Search Employee
    // ==========================================================
    public void searchEmployee(Scanner sc) {
        try {
            System.out.print("Enter ID: ");
            String idStr = sc.nextLine().trim();
            int id = Integer.parseInt(idStr);

            Employee emp = employeeMap.get(id);
            if (emp == null) {
                throw new EmployeeNotFoundException("Employee with ID " + id + " not found!");
            }

            System.out.println("\nEmployee Found:");
            System.out.println(emp.getName());
            System.out.println("Joining Date: " + emp.getJoiningDate().format(DISPLAY_FORMAT));
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid ID! Please enter a valid number.");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ==========================================================
    // 4️⃣ Check Experience
    // ==========================================================
    public void checkExperience(Scanner sc) {
        try {
            System.out.print("Enter ID: ");
            String idStr = sc.nextLine().trim();
            int id = Integer.parseInt(idStr);

            Employee emp = employeeMap.get(id);
            if (emp == null) {
                throw new EmployeeNotFoundException("Employee with ID " + id + " not found!");
            }

            LocalDate today = LocalDate.now();
            LocalDate joinDate = emp.getJoiningDate();

            if (joinDate.isAfter(today)) {
                System.out.println("Employee joining date is in the future: " + joinDate.format(DISPLAY_FORMAT));
                return;
            }

            Period period = Period.between(joinDate, today);

            int years = period.getYears();
            int months = period.getMonths();
            int days = period.getDays();

            StringBuilder expStr = new StringBuilder();
            if (years > 0) {
                expStr.append(years).append(years == 1 ? " year " : " years ");
            }
            if (months > 0) {
                expStr.append(months).append(months == 1 ? " month " : " months ");
            }
            expStr.append(days).append(days == 1 ? " day" : " days");

            System.out.println("\nExperience of " + emp.getName() + ":");
            System.out.println(expStr.toString().trim());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid ID! Please enter a valid number.");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ==========================================================
    // 5️⃣ Calculate Leave Duration
    // ==========================================================
    public void calculateLeaveDuration(Scanner sc) {
        try {
            System.out.print("Leave Start: ");
            String startStr = sc.nextLine().trim();
            LocalDate leaveStart = LocalDate.parse(startStr, INPUT_FORMAT);

            System.out.print("Leave End: ");
            String endStr = sc.nextLine().trim();
            LocalDate leaveEnd = LocalDate.parse(endStr, INPUT_FORMAT);

            if (leaveEnd.isBefore(leaveStart)) {
                throw new InvalidLeaveException("Leave End Date cannot be before Leave Start Date!");
            }

            // Calculate duration in days
            long duration = ChronoUnit.DAYS.between(leaveStart, leaveEnd);

            System.out.println("\nLeave Duration: " + duration + (duration == 1 ? " day" : " days"));
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format! Please use yyyy-MM-dd (e.g., 2026-09-10).");
        } catch (InvalidLeaveException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ==========================================================
    // Main Menu & Loop
    // ==========================================================
    public static void main(String[] args) {
        EmployeeLeaveManagementSystem system = new EmployeeLeaveManagementSystem();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== EMPLOYEE LEAVE SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Check Experience");
            System.out.println("5. Calculate Leave Duration");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choiceStr = sc.nextLine().trim();
            switch (choiceStr) {
                case "1":
                    system.addEmployee(sc);
                    break;
                case "2":
                    system.displayEmployees();
                    break;
                case "3":
                    system.searchEmployee(sc);
                    break;
                case "4":
                    system.checkExperience(sc);
                    break;
                case "5":
                    system.calculateLeaveDuration(sc);
                    break;
                case "6":
                    System.out.println("\nThank you for using the Employee Leave System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option (1-6).");
                    break;
            }
        }

        sc.close();
    }
}
