import java.util.Scanner;
public class Student {
    private String name;
    private int age;
    private int marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Age cannot be negative.");
        } else {
            this.age = age;
        }
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
        } else {
            this.marks = marks;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Student student = new Student();

        System.out.print("Enter student name: ");
        student.setName(sc.nextLine());

        System.out.print("Enter student age: ");
        student.setAge(sc.nextInt());

        System.out.print("Enter student marks: ");
        student.setMarks(sc.nextInt());

        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
        System.out.println("Student Marks: " + student.getMarks());
    }
}
