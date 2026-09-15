import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerArrayList {
    public static void main(String[] args) {
        // Create ArrayList with 5 student names
        ArrayList<String> names = new ArrayList<>(Arrays.asList(
            "Aparajitha", "Priya", "Rahul", "Anu", "Karthik"
        ));

        // Create Consumer to print greeting
        Consumer<String> greetingConsumer = name -> System.out.println("Hello, " + name + "!");

        System.out.println("=== Consumer with ArrayList.forEach() ===");
        names.forEach(greetingConsumer);

        // Chaining consumers using .andThen()
        Consumer<String> uppercaseConsumer = name -> System.out.println("  [LOG] In uppercase: " + name.toUpperCase());

        System.out.println("\n=== Chained Consumer (Greeting + Logging) ===");
        names.forEach(greetingConsumer.andThen(uppercaseConsumer));
    }
}
