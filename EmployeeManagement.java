import java.util.*;
public class EmployeeManagement {
    int id;
    String name;
    String department;
    double salary;

    void displayEmployee() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Department: " + department);
        System.out.println("Employee Salary: " + salary);
    }
    void increaseSalary(int increment) {
        salary += increment;
        System.out.println("Updated Salary: " + salary);
        
    }
    double calculateAnnualSalary() {
        
        
        return salary * 12;
    }
    public static void main(String[] args) {
        EmployeeManagement employee = new EmployeeManagement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        employee.id = sc.nextInt();
        System.out.println("Enter Employee Name: ");
        sc.nextLine(); // Consume the newline character
        employee.name = sc.nextLine();
        System.out.println("Enter Employee Department: ");
        employee.department = sc.nextLine();
        System.out.println("Enter Employee Salary: ");
        employee.salary = sc.nextDouble();
        employee.displayEmployee();
        System.out.println("Annual Salary: " + employee.calculateAnnualSalary());
        System.out.println("Enter Salary Increment: ");
        int increment = sc.nextInt();
        employee.increaseSalary(increment);
        System.out.println("Updated Employee Details:");
        employee.displayEmployee();
        sc.close();
    }
}
