import java.util.Scanner;
public class SearchforaNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number to search: ");
        int target = scanner.nextInt();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Number found at index: " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Number not found.");
        }
    }
}
