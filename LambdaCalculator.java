@FunctionalInterface
interface CalculatorInterface {
    int calculate(int a, int b);
}

public class LambdaCalculator {
    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }

    public static void main(String[] args) {
        // Lambda expressions implementing Calculator functional interface
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> {
            if (b == 0) {
                System.out.println("Division by zero error!");
                return 0;
            }
            return a / b;
        };

        int x = 10;
        int y = 5;

        System.out.println("=== Lambda Calculator ===");
        System.out.println(x + " + " + y + " = " + add.calculate(x, y));
        System.out.println(x + " - " + y + " = " + subtract.calculate(x, y));
        System.out.println(x + " * " + y + " = " + multiply.calculate(x, y));
        System.out.println(x + " / " + y + " = " + divide.calculate(x, y));
    }
}
