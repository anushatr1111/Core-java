import java.util.*;
public class GroupAnagrams {
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
        groupAnagrams(strs);
        scanner.close();
    }
    public static void groupAnagrams(String[] strs) {
       Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        System.out.println("Grouped Anagrams:");
        for (List<String> group : map.values()) {
            System.out.println(group);
        }
    }
}
