import java.util.Scanner;
public class SquareofaNumber {
    static int square(int num) {
        return num * num;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int square = square(number); // Calculate square using the static method
        System.out.println("The square of " + number + " is: " + square);
    }
}