import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        char result= '\0'; // Initialize result with null character
        Map<Character, Integer> charCountMap = new HashMap<>();
        
        // Count the occurrences of each character
        for (char c : input.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        // Find the first character with a count of 1
        for (char c : input.toCharArray()) {
            if (charCountMap.get(c) == 1) {
                result = c;
                break;
            }
        }  
        if (result != '\0') {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
        scanner.close();
    }
    
}
