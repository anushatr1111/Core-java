import java.util.function.Function;

public class NumberTransformationFunction {
    public static void main(String[] args) {
        // Function to compute square: n -> n * n
        Function<Integer, Integer> square = n -> n * n;

        // Function to compute cube: n -> n * n * n
        Function<Integer, Integer> cube = n -> n * n * n;

        // Function to double the value: n -> n * 2
        Function<Integer, Integer> doubleValue = n -> n * 2;

        int[] sampleInputs = {2, 3, 5, 10};

        System.out.println("=== Function Transformations for Number 5 ===");
        int testVal = 5;
        System.out.println("Input:  " + testVal);
        System.out.println("Square: " + testVal + " -> " + square.apply(testVal));
        System.out.println("Cube:   " + testVal + " -> " + cube.apply(testVal));
        System.out.println("Double: " + testVal + " -> " + doubleValue.apply(testVal));

        System.out.println("\n=== Batch Test on Multiple Numbers ===");
        System.out.printf("%-10s %-10s %-10s %-10s%n", "Number", "Square", "Cube", "Double");
        System.out.println("----------------------------------------");
        for (int n : sampleInputs) {
            System.out.printf("%-10d %-10d %-10d %-10d%n", n, square.apply(n), cube.apply(n), doubleValue.apply(n));
        }

        // Function chaining using andThen() and compose()
        Function<Integer, Integer> squareThenDouble = square.andThen(doubleValue); // (5^2) * 2 = 50
        Function<Integer, Integer> doubleThenSquare = square.compose(doubleValue); // (5 * 2)^2 = 100

        System.out.println("\n=== Function Chaining (Composition) ===");
        System.out.println("squareThenDouble(5): (5^2) * 2 = " + squareThenDouble.apply(testVal));
        System.out.println("doubleThenSquare(5): (5 * 2)^2 = " + doubleThenSquare.apply(testVal));
    }
}
