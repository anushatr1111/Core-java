import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ValidAnagram {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the first string: ");
            String s = scanner.nextLine();
            System.out.print("Enter the second string: ");
            String t = scanner.nextLine();

            boolean isAnagram = isAnagram(s, t);
            if (isAnagram) {
                System.out.println("\"" + s + "\" and \"" + t + "\" are anagrams.");
            } else {
                System.out.println("\"" + s + "\" and \"" + t + "\" are not anagrams.");
            }
        }
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count the occurrences of each character in the first string
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Decrement the count for each character in the second string
        for (char c : t.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false;
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) == 0) {
                charCountMap.remove(c);
            }
        }

        // If the map is empty, all characters have been matched
        return charCountMap.isEmpty();
    }
}
