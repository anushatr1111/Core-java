import java.util.Scanner;
public class CheckPalindrome {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string to check if it's a palindrome:");
        String str=sc.nextLine();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if(Character.isAlphabetic(right) || Character.isDigit(right) || Character.isWhitespace(right)){
                right--;
            }
            if(Character.isAlphabetic(left) || Character.isDigit(left) || Character.isWhitespace(left)){
                left++;
            }
            if(left >= right){
                break;
            }
            if (str.charAt(left) != str.charAt(right)) {
                System.out.println("The string is not a palindrome.");
                break;
            }
            sc.close();
        }
        System.out.println("The string is a palindrome.");
    }
}
