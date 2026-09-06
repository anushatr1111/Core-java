import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentSortingwithComparator {
    public static void main(String[] args) {
        // Use the same Student class
        List<Student> students = new ArrayList<>();
        students.add(new Student("Aparajitha", 90));
        students.add(new Student("Rahul", 72));
        students.add(new Student("Priya", 95));
        students.add(new Student("Anu", 82));

        System.out.println("--- Original List ---");
        for (Student s : students) {
            System.out.println(s.getName() + " -> " + s.getMarks());
        }

        // ==========================================
        // Comparator 1: Sort by name alphabetically
        // ==========================================
        Comparator<Student> nameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        };

        Collections.sort(students, nameComparator);

        System.out.println("\n--- Comparator 1: Sort by name alphabetically ---");
        for (Student s : students) {
            System.out.println(s.getName());
        }

        // ==========================================
        // Comparator 2: Sort by marks descending
        // ==========================================
        Comparator<Student> marksDescComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // Descending order: higher marks first
                return s2.getMarks() - s1.getMarks();
            }
        };

        Collections.sort(students, marksDescComparator);

        System.out.println("\n--- Comparator 2: Sort by marks descending ---");
        for (Student s : students) {
            System.out.println(s.getName() + " -> " + s.getMarks());
        }

        // The important idea:
        System.out.println("\n==========================================");
        System.out.println("Key Concept:");
        System.out.println("Comparable = default/natural sorting (marks ascending)");
        System.out.println("Comparator = custom sorting (name alphabetical, marks descending)");
        System.out.println("==========================================");
    }
}