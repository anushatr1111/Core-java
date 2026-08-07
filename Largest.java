import java.util.*;
public class Largest {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the First number : ");
        int n1=sc.nextInt();
        System.out.println("Enter the Second number : ");
        int n2=sc.nextInt();
        System.out.println("Enter the Third number : ");
        int n3=sc.nextInt();
        if(n1>n2 && n1>n3){
            System.out.println("The Largest number is "+n1);
        }
        else if(n2>n1 && n2>n3){
            System.out.println("The Largest number is "+n2);
        }else if (n1==n2 && n2==n3 && n3==n1){
            System.out.println("All numbers are equal.");
        }
        else {
            System.out.println("The Largest number is "+n3);
        }
        sc.close();
    }
}
