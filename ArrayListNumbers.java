import java.util.ArrayList;

public class ArrayListNumbers {
    public static void main(String[] args) {
        // Problem 2: ArrayList Numbers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add 10 integers
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(3);
        numbers.add(14);
        numbers.add(7);
        numbers.add(12);
        numbers.add(25);
        numbers.add(6);

        System.out.println("Numbers: " + numbers);

        // Calculations using a loop with numbers.get(i)
        int sum = 0;
        int largest = numbers.get(0);
        int smallest = numbers.get(0);
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < numbers.size(); i++) {
            int current = numbers.get(i);
            sum += current;

            if (current > largest) {
                largest = current;
            }

            if (current < smallest) {
                smallest = current;
            }

            if (current % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // Print results
        System.out.println("\nSum: " + sum);
        System.out.println("Largest: " + largest);
        System.out.println("Smallest: " + smallest);
        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }
}
