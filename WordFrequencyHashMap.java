import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordFrequencyHashMap {
    public static void main(String[] args) {
        // Problem 5: Word Frequency Using HashMap
        String sentence = "java is easy and java is powerful";
        System.out.println("Given text: \"" + sentence + "\"\n");

        // Split the sentence into words
        String[] words = sentence.split("\\s+");

        // Use HashMap (LinkedHashMap to preserve first insertion order)
        HashMap<String, Integer> map = new LinkedHashMap<>();

        // Count frequency using the required pattern
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        // Display word counts
        System.out.println("Word Frequency:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
