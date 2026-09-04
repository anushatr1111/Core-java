public class MultipleExceptions {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int numerator = 10;
        int denominator = 0;

        try {
            System.out.println(arr[10]); // This will throw an ArrayIndexOutOfBoundsException
            int result = numerator / denominator; // This will throw an ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}