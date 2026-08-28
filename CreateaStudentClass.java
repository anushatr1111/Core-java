import java.util.Scanner;
public class CreateaStudentClass {
    void displayStudentDetails(String name, int age, String grade,int rollno) {
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student Grade: " + grade);
        System.out.println("RollNo: " + rollno);
    }
    public static void main(String[] args) {
        CreateaStudentClass student = new CreateaStudentClass();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Student Age: ");
        int age = sc.nextInt();
        System.out.println("Enter Student Grade: ");
        String grade = sc.next();
        System.out.println("Enter Student RollNo: ");
        int rollno = sc.nextInt();
        student.displayStudentDetails(name, age, grade, rollno);
        sc.close();
    }
}
