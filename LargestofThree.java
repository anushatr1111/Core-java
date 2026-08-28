import java.util.*;
public class LargestofThree{
    static int findLargest(int a, int b, int c){
        if (a>b && a>c){
            return a;
        }
        else if (b>c && b>a){
            return b;
        }
        else {
            return c;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the numbers : ");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int result=findLargest(a, b, c);
        System.out.println("The number is "+result);
        sc.close();
    }
}