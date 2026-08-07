import java.util.*;
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        String[] strs = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }
        String lcp = longestCommonPrefix(strs);
        if (lcp.isEmpty()) {
            System.out.println("No common prefix found.");
        } else {
            System.out.println("Longest common prefix: " + lcp);
        }
        scanner.close();
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = "";
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return prefix;
                }
            }
            prefix += c;
        }
        return prefix;
    }
}
