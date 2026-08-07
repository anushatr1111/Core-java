import java.util.Scanner;
public class Factorial {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        int num =scanner.nextInt();
        int result= factorial(num);
        System.out.println("Factorial of " + num + " is: " + result);
        scanner.close();
    }
    public static int factorial(int n){
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if(n==0 || n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
}
