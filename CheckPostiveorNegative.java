import java.util.Scanner;
public class CheckPostiveorNegative {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number:");
        int num=sc.nextInt();
        if(num<0){
            System.out.println("The number "+num+ " is Negative");
        }else if(num==0) {
            System.out.println("The number "+num+ " is Zero");
        }
        else{
            System.out.println("The number "+num+" is Postive");
        }
        sc.close();
    }
}
