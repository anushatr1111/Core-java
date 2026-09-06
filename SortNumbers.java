import java.util.ArrayList;
import java.util.Collections;

public class SortNumbers {
    public static void main(String[] args) {
        // Create an ArrayList of Integer
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add 10 numbers
        numbers.add(40);
        numbers.add(10);
        numbers.add(70);
        numbers.add(20);
        numbers.add(50);
        numbers.add(90);
        numbers.add(30);
        numbers.add(80);
        numbers.add(60);
        numbers.add(100);

        // Print Original list
        System.out.println("Original:");
        System.out.println(numbers);

        // Sort in Ascending order using Collections.sort()
        Collections.sort(numbers);
        System.out.println("\nAscending:");
        System.out.println(numbers);

        // Sort in Descending order using Collections.sort() with reverseOrder()
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("\nDescending:");
        System.out.println(numbers);
    }
}