import java.util.Scanner;
public class Fibonnaci {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms in the Fibonacci sequence:");
        int num =scanner.nextInt();
        System.out.println("Fibonacci sequence up to " + num + " terms:");
         fibnocci(num);

        scanner.close();
    }
    public static void fibnocci(int n){
        int a= 0, b = 1;
        for(int i=0; i<n; i++){
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}

