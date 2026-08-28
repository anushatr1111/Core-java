public class FindtheLengthofaString {
    public static void main(String[] args) {
        String str = "Hello, World!";
        int length = findLength(str);
        System.out.println("Length of the string: " + length);
    }

    public static int findLength(String str) {
        return str.length();
    }
}
