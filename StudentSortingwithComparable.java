import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentSortingwithComparable {
    public static void main(String[] args) {
        // Create a list of Student objects
        List<Student> students = new ArrayList<>();

        // Add students
        students.add(new Student("Aparajitha", 90));
        students.add(new Student("Rahul", 72));
        students.add(new Student("Priya", 95));
        students.add(new Student("Anu", 82));

        // Print original list
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(s.getName() + " -> " + s.getMarks());
        }

        // Sort using Collections.sort() which invokes compareTo() in Student class
        Collections.sort(students);

        // Print sorted students in ascending order of marks
        System.out.println("\nExpected (Sorted by marks ascending):");
        for (Student s : students) {
            System.out.println(s.getName() + " -> " + s.getMarks());
        }
    }
}