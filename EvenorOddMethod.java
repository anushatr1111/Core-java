import java.util.*;
public class EvenorOddMethod {
    static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        int number = 10; // Example number
        if (isEven(number)) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }
}