import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * PROBLEM 5 - Employee Map
 * 
 * Demonstrates:
 * - Map<Integer, String> mapping Employee ID -> Employee Name
 * - Adding 5 initial employees
 * - Displaying all employees
 * - Searching by ID
 * - Adding a new employee
 * - Updating an employee name
 * - Removing an employee
 * - Checking if an ID exists
 * - Printing total employees
 */
public class EmployeeMap {

    public static void printAllEmployees(Map<Integer, String> map) {
        System.out.println("ID\tName");
        System.out.println("-------------------------");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("        PROBLEM 5 - Employee Map          ");
        System.out.println("==========================================\n");

        // 1. Create the Map (LinkedHashMap preserves insertion order)
        Map<Integer, String> employees = new LinkedHashMap<>();

        // 2. Add 5 employees
        employees.put(101, "Aparajitha");
        employees.put(102, "Priya");
        employees.put(103, "Rahul");
        employees.put(104, "Anu");
        employees.put(105, "Kavin");

        // Operation 1: Display all employees
        System.out.println("1. All Employees:");
        printAllEmployees(employees);
        System.out.println();

        // Operation 2: Search by ID
        int searchId = 103;
        System.out.println("2. Search by ID:");
        System.out.println("Searching for employee ID: " + searchId);
        if (employees.containsKey(searchId)) {
            System.out.println("Employee: " + employees.get(searchId));
        } else {
            System.out.println("Employee with ID " + searchId + " not found.");
        }
        System.out.println();

        // Operation 3: Add a new employee
        int newId = 106;
        String newName = "Suresh";
        System.out.println("3. Add New Employee:");
        employees.put(newId, newName);
        System.out.println("Added: " + newId + " -> " + newName);
        System.out.println();

        // Operation 4: Update an employee name
        int updateId = 104;
        String updatedName = "Ananya";
        System.out.println("4. Update Employee Name:");
        if (employees.containsKey(updateId)) {
            String oldName = employees.put(updateId, updatedName);
            System.out.println("Updated ID " + updateId + ": '" + oldName + "' -> '" + updatedName + "'");
        }
        System.out.println();

        // Operation 5: Remove an employee
        int removeId = 102;
        System.out.println("5. Remove Employee:");
        if (employees.containsKey(removeId)) {
            String removedName = employees.remove(removeId);
            System.out.println("Removed: " + removeId + " -> " + removedName);
        }
        System.out.println();

        // Operation 6: Check whether an ID exists
        System.out.println("6. Check Whether ID Exists:");
        int checkId1 = 105;
        int checkId2 = 102;
        System.out.println("Does ID " + checkId1 + " exist? " + employees.containsKey(checkId1));
        System.out.println("Does ID " + checkId2 + " exist? " + employees.containsKey(checkId2));
        System.out.println();

        // Operation 7: Print total employees
        System.out.println("7. Total Employees:");
        System.out.println("Total employee count: " + employees.size());
        System.out.println();

        // Current state after all operations
        System.out.println("Final Employee Map:");
        printAllEmployees(employees);
    }
}
