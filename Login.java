import java.util.*;
public class Login {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the username :");
        String username=sc.nextLine();
        System.out.print("Enter the password :");
        String password=sc.nextLine();
        if(username.equals("admin") && password.equals("12345")){
            System.out.println("Login Successful");
        }else{
            System.out.println("Invalid username or password");
        }
        sc.close();
    }
}
