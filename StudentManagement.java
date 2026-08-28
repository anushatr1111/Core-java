import java.util.*;
public class StudentManagement {
    int id;
    String name;
    String department;
    double marks;

    public StudentManagement(int id, String name, String department, double marks) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Marks: " + marks);
    }

    public char calculateGrade() {
        if (marks >= 80) {
            return 'A';
        } else if (marks >= 60) {
            return 'B';
        } else {
            return 'C';
        }
    }

    public boolean isPassed() {
        return marks >= 40;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.println("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Student Department: ");
        String department = sc.nextLine();
        System.out.println("Enter Student Marks: ");
        double marks = sc.nextDouble();

        StudentManagement student = new StudentManagement(id, name, department, marks);
        student.displayDetails();
        System.out.println("Grade: " + student.calculateGrade());
        System.out.println("Passed: " + student.isPassed());
        sc.close();
    }
}
