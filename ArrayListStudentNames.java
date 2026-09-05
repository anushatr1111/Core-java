import java.util.ArrayList;

public class ArrayListStudentNames {
    public static void main(String[] args) {
        // Problem 1: ArrayList Student Names
        ArrayList<String> students = new ArrayList<>();

        // Add 5 student names
        students.add("Aparajitha");
        students.add("Priya");
        students.add("Rahul");
        students.add("Anu");
        students.add("Kavin");

        // Print all names
        System.out.println("Students:");
        for (String name : students) {
            System.out.println(name);
        }

        // Print the first name
        System.out.println("\nFirst student: " + students.get(0));

        // Print the last name
        System.out.println("Last student: " + students.get(students.size() - 1));

        // Print the size
        System.out.println("Number of students: " + students.size());

        // Check whether "Aparajitha" exists
        boolean containsAparajitha = students.contains("Aparajitha");
        System.out.println("Contains Aparajitha: " + containsAparajitha);

        // Remove one student
        String removedStudent = students.remove(2); // removes "Rahul"
        System.out.println("\nRemoved student: " + removedStudent);

        // Print updated list and new size
        System.out.println("Updated Students list: " + students);
        System.out.println("Updated number of students: " + students.size());
    }
}
