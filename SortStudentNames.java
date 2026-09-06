import java.util.ArrayList;
import java.util.Collections;

public class SortStudentNames {
    public static void main(String[] args) {
        // Create an ArrayList of String
        ArrayList<String> names = new ArrayList<>();

        // Add 6 names
        names.add("Zara");
        names.add("Anu");
        names.add("Rahul");
        names.add("Bala");
        names.add("Priya");
        names.add("Kiran");

        // Print original list
        System.out.println("Original:");
        System.out.println(names);

        // Sort alphabetically (Ascending)
        Collections.sort(names);
        System.out.println("\nAscending:");
        System.out.println(names);

        // Sort in reverse alphabetical order (Descending)
        Collections.sort(names, Collections.reverseOrder());
        System.out.println("\nDescending:");
        System.out.println(names);
    }
}