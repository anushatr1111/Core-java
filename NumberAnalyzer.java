import java.util.Scanner;

public class NumberAnalyzer {

    // Check if number is even
    static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Check if number is positive
    static boolean isPositive(int number) {
        return number > 0;
    }

    // Count digits
    static int countDigits(int number) {
        number = Math.abs(number);

        if (number == 0) {
            return 1;
        }

        int count = 0;

        while (number > 0) {
            count++;
            number = number / 10;
        }

        return count;
    }

    // Sum of digits
    static int sumDigits(int number) {
        number = Math.abs(number);
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }

        return sum;
    }

    // Reverse number
    static int reverseNumber(int number) {
        int reverse = 0;
        int temp = Math.abs(number);

        while (temp > 0) {
            int digit = temp % 10;
            reverse = reverse * 10 + digit;
            temp = temp / 10;
        }

        if (number < 0) {
            return -reverse;
        }

        return reverse;
    }

    // Check palindrome
    static boolean isPalindrome(int number) {
        return number == reverseNumber(number);
    }

    // Check prime
    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Check Armstrong number
    static boolean isArmstrong(int number) {
        if (number < 0) {
            return false;
        }

        int digits = countDigits(number);
        int temp = number;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp = temp / 10;
        }

        return sum == number;
    }

    // Find square
    static int findSquare(int number) {
        return number * number;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Even / Odd
        if (isEven(number)) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }

        // Positive / Negative
        if (isPositive(number)) {
            System.out.println(number + " is positive.");
        } else if (number < 0) {
            System.out.println(number + " is negative.");
        } else {
            System.out.println(number + " is zero.");
        }

        // Number of digits
        System.out.println("Number of digits: " + countDigits(number));

        // Sum of digits
        System.out.println("Sum of digits: " + sumDigits(number));

        // Reverse
        System.out.println("Reverse of " + number + " is: " + reverseNumber(number));

        // Palindrome
        if (isPalindrome(number)) {
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }

        // Prime
        if (isPrime(number)) {
            System.out.println(number + " is prime.");
        } else {
            System.out.println(number + " is not prime.");
        }

        // Armstrong
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }

        // Square
        System.out.println("Square of " + number + " is: " + findSquare(number));

        scanner.close();
    }
}