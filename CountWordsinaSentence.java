import java.util.Scanner;
public class CountWordsinaSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        String[] words = sentence.split("\\s+");
        System.out.println("Number of words in the sentence: " + words.length);
    }
}
