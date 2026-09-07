/**
 * PROBLEM 3 - Generic Method
 * 
 * Demonstrates:
 * - Declaring a generic method with type parameter <T>
 * - static <T> void printArray(T[] array)
 * - Using the same generic method for Integer[], String[], and Double[] arrays
 */
public class GenericMethod {

    // Generic method that accepts an array of any reference type T
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       PROBLEM 3 - Generic Method         ");
        System.out.println("==========================================\n");

        // Test arrays
        Integer[] numbers = {10, 20, 30};
        String[] names = {"A", "B", "C"};
        Double[] prices = {10.5, 20.5, 30.5};

        // Calling generic printArray with Integer[]
        printArray(numbers);
        System.out.println();

        // Calling generic printArray with String[]
        printArray(names);
        System.out.println();

        // Calling generic printArray with Double[]
        printArray(prices);
    }
}
