import java.util.Scanner;
public class CheckEvenOrOddMethod {
    static void checkEvenOdd(int number){
        if(number%2==0){
            System.out.println("Even");
        }
        else{
            System.out.println("Odd");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number");
        int num=sc.nextInt();
        checkEvenOdd(num);
        sc.close();

    }
}
