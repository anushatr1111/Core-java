import java.util.*;
public class ATM {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount:");
        int num=sc.nextInt();
        int balance=10000;
        if(num%100==0 && num<=balance && num >0){
            System.out.println("Please collect your cash.");
            balance=balance-num;
            System.out.println("Remaining balance : Rs."+balance);
        }else{
            System.out.println("Invalid ");
        }sc.close();
    }
}
