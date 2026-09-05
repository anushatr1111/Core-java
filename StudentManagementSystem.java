import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

// Custom Exceptions (Exception Handling from Day 31)
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

class DuplicateStudentException extends Exception {
    public DuplicateStudentException(String message) {
        super(message);
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

// OOP Model: StudentManager encapsulates business logic and collections
class StudentManager {
    private ArrayList<String> students;
    private HashMap<String, Integer> marks;

    public StudentManager() {
        this.students = new ArrayList<>();
        this.marks = new HashMap<>();
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public HashMap<String, Integer> getMarks() {
        return marks;
    }

    // 1. Add Student
    public void addStudent(String name) throws DuplicateStudentException, InvalidInputException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Student name cannot be empty.");
        }
        name = name.trim();
        if (students.contains(name)) {
            throw new DuplicateStudentException("Student '" + name + "' already exists!");
        }
        students.add(name);
        System.out.println("\nStudent added successfully!");
    }

    // 2. Remove Student
    public void removeStudent(String name) throws StudentNotFoundException, InvalidInputException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Student name cannot be empty.");
        }
        name = name.trim();
        if (!students.contains(name)) {
            throw new StudentNotFoundException("Student '" + name + "' not found.");
        }
        students.remove(name);
        marks.remove(name); // Remove marks if any exist
        System.out.println("\nStudent '" + name + "' removed successfully!");
    }

    // 3. Display Students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo students enrolled in the system.");
            return;
        }
        System.out.println("\n----- Student List -----");
        for (int i = 0; i < students.size(); i++) {
            String studentName = students.get(i);
            String markInfo = marks.containsKey(studentName) ? String.valueOf(marks.get(studentName)) : "Not Assigned";
            System.out.println((i + 1) + ". " + studentName + " | Marks: " + markInfo);
        }
        System.out.println("Total Students: " + students.size());
    }

    // 4. Add/Update Marks
    public void addOrUpdateMarks(String name, int mark) throws StudentNotFoundException, InvalidMarksException, InvalidInputException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Student name cannot be empty.");
        }
        name = name.trim();
        if (!students.contains(name)) {
            throw new StudentNotFoundException("Student '" + name + "' not found! Please add the student first.");
        }
        if (mark < 0 || mark > 100) {
            throw new InvalidMarksException("Invalid marks: " + mark + ". Marks must be between 0 and 100.");
        }
        marks.put(name, mark);
        System.out.println("\nMarks updated!");
    }

    // 5. Search Student
    public void searchStudent(String name) throws StudentNotFoundException, InvalidInputException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Student name cannot be empty.");
        }
        name = name.trim();
        if (!students.contains(name)) {
            throw new StudentNotFoundException("Student '" + name + "' not found.");
        }
        if (marks.containsKey(name)) {
            System.out.println("\n" + name + " -> " + marks.get(name));
        } else {
            System.out.println("\n" + name + " is enrolled, but marks have not been assigned yet.");
        }
    }

    // 6. Display Highest Mark
    public void displayHighestMark() {
        if (marks.isEmpty()) {
            System.out.println("\nNo marks available to evaluate.");
            return;
        }
        String topStudent = "";
        int highest = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            if (entry.getValue() > highest) {
                highest = entry.getValue();
                topStudent = entry.getKey();
            }
        }
        System.out.println("\nHighest Mark: " + highest + " (Student: " + topStudent + ")");
    }

    // 7. Display Average
    public void displayAverage() {
        if (marks.isEmpty()) {
            System.out.println("\nNo marks available to calculate average.");
            return;
        }
        int total = 0;
        for (int mark : marks.values()) {
            total += mark;
        }
        double average = (double) total / marks.size();
        System.out.printf("\nAverage Marks of %d evaluated student(s): %.2f\n", marks.size(), average);
    }
}

// CLI Application Entry Point
public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=========================================");
        System.out.println(" Welcome to Student Management System");
        System.out.println("=========================================");

        while (running) {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Add/Update Marks");
            System.out.println("5. Search Student");
            System.out.println("6. Display Highest Mark");
            System.out.println("7. Display Average");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number (1-8).");
                scanner.nextLine(); // Clear invalid token
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String nameToAdd = scanner.nextLine();
                        manager.addStudent(nameToAdd);
                        break;

                    case 2:
                        System.out.print("Enter student name to remove: ");
                        String nameToRemove = scanner.nextLine();
                        manager.removeStudent(nameToRemove);
                        break;

                    case 3:
                        manager.displayStudents();
                        break;

                    case 4:
                        System.out.print("Enter student name: ");
                        String nameForMarks = scanner.nextLine();
                        System.out.print("Enter marks: ");
                        int mark;
                        try {
                            mark = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                        } catch (InputMismatchException e) {
                            scanner.nextLine(); // Clear token
                            throw new InvalidMarksException("Marks must be an integer value.");
                        }
                        manager.addOrUpdateMarks(nameForMarks, mark);
                        break;

                    case 5:
                        System.out.print("Enter student name: ");
                        String nameToSearch = scanner.nextLine();
                        manager.searchStudent(nameToSearch);
                        break;

                    case 6:
                        manager.displayHighestMark();
                        break;

                    case 7:
                        manager.displayAverage();
                        break;

                    case 8:
                        running = false;
                        System.out.println("\nExiting Student Management System. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please select an option between 1 and 8.");
                        break;
                }
            } catch (StudentNotFoundException | InvalidMarksException | DuplicateStudentException | InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
