import java.util.HashMap;
public class FrequencyofEveryElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 3, 1, 4, 5, 4};
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (int num : frequencyMap.keySet()) {
            System.out.println("Element: " + num + ", Frequency: " + frequencyMap.get(num));
        }
    }
}
