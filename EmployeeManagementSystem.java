import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.txt";

    // 1. Add Employee
    private static void addEmployee(Scanner sc) {
        try {
            System.out.print("ID: ");
            String id = sc.nextLine().trim();

            System.out.print("Name: ");
            String name = sc.nextLine().trim();

            System.out.print("Age: ");
            String age = sc.nextLine().trim();

            System.out.print("Salary: ");
            String salary = sc.nextLine().trim();

            if (id.isEmpty() || name.isEmpty() || age.isEmpty() || salary.isEmpty()) {
                System.out.println("All fields are required. Employee not added.");
                return;
            }

            // Append employee details in: ID - Name - Age - Salary
            String record = id + " - " + name + " - " + age + " - " + salary;
            FileWriter writer = new FileWriter(FILE_NAME, true);
            writer.write(record + System.lineSeparator());
            writer.close();

            System.out.println("\nEmployee added successfully!");
        } catch (IOException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    // 2. Display Employees
    private static void displayEmployees() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            System.out.println("No employee records found.");
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("\n----- Employee Records -----");
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    System.out.println(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error displaying employees: " + e.getMessage());
        }
    }

    // 3. Search Employee
    private static void searchEmployee(Scanner sc) {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            System.out.println("No employee records found to search.");
            return;
        }

        System.out.print("Enter Employee ID: ");
        String searchId = sc.nextLine().trim();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();
                if (trimmed.isEmpty()) continue;

                String[] parts = trimmed.split(" - ");
                if (parts.length > 0 && parts[0].trim().equalsIgnoreCase(searchId)) {
                    System.out.println("\nEmployee Found:");
                    System.out.println(line);
                    found = true;
                    break;
                }
            }
            reader.close();

            if (!found) {
                System.out.println("\nEmployee with ID " + searchId + " not found.");
            }
        } catch (IOException e) {
            System.out.println("Error searching employee: " + e.getMessage());
        }
    }

    // 4. Delete Employee
    private static void deleteEmployee(Scanner sc) {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            System.out.println("No employee records found to delete.");
            return;
        }

        System.out.print("Delete ID: ");
        String deleteId = sc.nextLine().trim();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<String> remainingEmployees = new ArrayList<>();
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();
                if (trimmed.isEmpty()) continue;

                String[] parts = trimmed.split(" - ");
                if (parts.length > 0 && parts[0].trim().equalsIgnoreCase(deleteId)) {
                    found = true;
                } else {
                    remainingEmployees.add(trimmed);
                }
            }
            reader.close();

            if (found) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
                for (String emp : remainingEmployees) {
                    writer.write(emp);
                    writer.newLine();
                }
                writer.close();
                System.out.println("\nEmployee deleted successfully!");
            } else {
                System.out.println("\nEmployee with ID " + deleteId + " not found.");
            }
        } catch (IOException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    addEmployee(sc);
                    break;
                case "2":
                    displayEmployees();
                    break;
                case "3":
                    searchEmployee(sc);
                    break;
                case "4":
                    deleteEmployee(sc);
                    break;
                case "5":
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select an option between 1 and 5.");
            }
        }
    }
}
