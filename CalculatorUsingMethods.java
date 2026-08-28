import java.util.*;

public class CalculatorUsingMethods {

    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static int divide(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        int num = sc.nextInt();

        switch (num) {

            case 1:
                System.out.println("Result = " + add(a, b));
                break;

            case 2:
                System.out.println("Result = " + subtract(a, b));
                break;

            case 3:
                System.out.println("Result = " + multiply(a, b));
                break;

            case 4:
                System.out.println("Result = " + divide(a, b));
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}