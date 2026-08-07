import java.util.Scanner;
class ReverseJava{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string to reverse:");
        String str=sc.nextLine();
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        System.out.println("Reversed string: " + new String(charArray));
        sc.close();
    }
}