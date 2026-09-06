import java.util.HashSet;
import java.util.Iterator;

public class IterateThroughaHashSet {
    public static void main(String[] args) {
        // Create HashSet of String
        HashSet<String> cities = new HashSet<>();

        // Add 5 cities
        cities.add("Chennai");
        cities.add("Bangalore");
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Hyderabad");

        // Part A: Iterate using for-each loop
        System.out.println("--- Part A: Using for-each loop ---");
        System.out.println("Cities:");
        for (String city : cities) {
            System.out.println(city);
        }

        // Part B: Iterate using Iterator
        System.out.println("\n--- Part B: Using Iterator ---");
        System.out.println("Cities:");
        Iterator<String> iterator = cities.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Check whether a particular city exists
        System.out.println("\n--- Check City Existence ---");
        String searchCity1 = "Chennai";
        String searchCity2 = "Kolkata";

        if (cities.contains(searchCity1)) {
            System.out.println(searchCity1 + " exists in the HashSet.");
        } else {
            System.out.println(searchCity1 + " does NOT exist in the HashSet.");
        }

        if (cities.contains(searchCity2)) {
            System.out.println(searchCity2 + " exists in the HashSet.");
        } else {
            System.out.println(searchCity2 + " does NOT exist in the HashSet.");
        }
    }
}