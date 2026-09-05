import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentMarksHashMap {
    public static void main(String[] args) {
        // Problem 4: Student Marks Using HashMap
        // Using LinkedHashMap (which extends HashMap) to preserve order of entries
        HashMap<String, Integer> marks = new LinkedHashMap<>();

        // Store 5 students and their marks
        marks.put("Aparajitha", 85);
        marks.put("Priya", 92);
        marks.put("Rahul", 76);
        marks.put("Anu", 88);
        marks.put("Kavin", 69);

        // 1. Print all students and marks
        System.out.println("All Students and Marks:");
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // 2. Find Highest, Lowest, and Average Marks
        String highestStudent = "";
        int highestMark = Integer.MIN_VALUE;

        String lowestStudent = "";
        int lowestMark = Integer.MAX_VALUE;

        int totalSum = 0;

        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            String student = entry.getKey();
            int mark = entry.getValue();

            totalSum += mark;

            if (mark > highestMark) {
                highestMark = mark;
                highestStudent = student;
            }

            if (mark < lowestMark) {
                lowestMark = mark;
                lowestStudent = student;
            }
        }

        double average = (double) totalSum / marks.size();

        System.out.println("\nStatistics:");
        System.out.println("Highest Mark: " + highestMark + " (" + highestStudent + ")");
        System.out.println("Lowest Mark: " + lowestMark + " (" + lowestStudent + ")");
        System.out.printf("Average Mark: %.2f\n", average);

        // 3. Check whether a student exists
        String checkName = "Aparajitha";
        System.out.println("\nChecking existence:");
        System.out.println("Contains '" + checkName + "': " + marks.containsKey(checkName));
        System.out.println("Contains 'Ramesh': " + marks.containsKey("Ramesh"));

        // 4. Search for a student's marks
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter student name to search: ");
        String searchName = "Priya";
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                searchName = input;
            }
        }

        if (marks.containsKey(searchName)) {
            System.out.println("Marks for " + searchName + ": " + marks.get(searchName));
        } else {
            System.out.println("Student '" + searchName + "' not found.");
        }

        scanner.close();
    }
}
