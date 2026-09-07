/**
 * Generic Box class that can hold any reference data type T.
 * Demonstrates:
 * - Generic class declaration with type parameter <T>
 * - Type-safe fields, setters, getters, and display methods
 */
class Box<T> {
    private T value;

    // Default constructor
    public Box() {
    }

    // Parameterized constructor
    public Box(T value) {
        this.value = value;
    }

    // Setter
    public void setValue(T value) {
        this.value = value;
    }

    // Getter
    public T getValue() {
        return value;
    }

    // Display method
    public void display() {
        System.out.println("Box Value: " + value + " | Type: " + (value != null ? value.getClass().getSimpleName() : "null"));
    }
}

/**
 * PROBLEM 4 - Generic Box
 * 
 * Demonstrates:
 * - Instantiating Box<T> with different types (Integer, String, Double)
 * - Using setValue(), getValue(), and display()
 * - Understanding type safety and reusability of generic classes
 */
public class GenericBox {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("         PROBLEM 4 - Generic Box          ");
        System.out.println("==========================================\n");

        // 1. Box for Integer
        Box<Integer> intBox = new Box<>();
        intBox.setValue(100);
        System.out.println("Box<Integer> -> " + intBox.getValue());
        intBox.display();
        System.out.println();

        // 2. Box for String
        Box<String> strBox = new Box<>();
        strBox.setValue("Java");
        System.out.println("Box<String>  -> \"" + strBox.getValue() + "\"");
        strBox.display();
        System.out.println();

        // 3. Box for Double
        Box<Double> dblBox = new Box<>();
        dblBox.setValue(99.5);
        System.out.println("Box<Double>  -> " + dblBox.getValue());
        dblBox.display();
        System.out.println();

        // 4. Summary explanation of generic classes
        System.out.println("------------------------------------------");
        System.out.println("[KEY TAKEAWAY]");
        System.out.println("------------------------------------------");
        System.out.println("A single generic class 'Box<T>' works seamlessly");
        System.out.println("with Integer, String, Double, or any custom object");
        System.out.println("while providing compile-time type safety and");
        System.out.println("eliminating the need for explicit type casting!");
        System.out.println("------------------------------------------");
    }
}
