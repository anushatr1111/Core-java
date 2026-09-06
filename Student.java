import java.util.Scanner;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int marks;

    // Default constructor
    public Student() {
    }

    // Constructor with name and marks
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Constructor with name, age, and marks
    public Student(String name, int age, int marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

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

    // Natural ordering: ascending order of marks
    @Override
    public int compareTo(Student other) {
        return this.marks - other.marks;
    }

    @Override
    public String toString() {
        return name + " -> " + marks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
