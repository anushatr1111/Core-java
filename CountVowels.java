class CountVowels {
    public static void main(String[] args) {
        String input = "Hello, World!";
        int countVowels = 0;
        int countConsonants = 0;
        char[] strArray = input.toCharArray();
        for (char c : strArray) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                countVowels++;
            }
            else{
                countConsonants++;
            }
        }
        System.out.println("Number of vowels in the input string: " + countVowels);
        System.out.println("Number of consonants in the input string: " + countConsonants);
    }
}