import java.util.*;
public class ElectricityBill {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the unit :");
        int unit=sc.nextInt();
        int result=1;
        if(unit>=0 && unit <=100){
            result=unit*2;
            System.out.println("Electricity Bill = "+result);
        }else if(unit>=101 && unit <=200){
            result=unit*3;
            System.out.println("Electricity Bill = "+result);
        }else if(unit>=201 && unit <=300){
            result=unit*5;
            System.out.println("Electricity Bill = "+result);
        }else {
            result=unit*7;
            System.out.println("Electricity Bill = "+result);
        }
        sc.close();
    }
}
