import java.util.Scanner;
public class ATMmenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        double balance = 10000.00; // Initial balance
        switch (choice) {
            case 1:
                System.out.printf("Your balance is: $%.2f%n", balance);
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double deposit = sc.nextDouble();
                if (deposit > 0) {
                    balance += deposit;
                    System.out.printf("You have deposited: $%.2f%n", deposit);
                    System.out.printf("New balance is: $%.2f%n", balance);
                } else {
                    System.out.println("Invalid deposit amount.");
                }
                break;
            case 3:
                System.out.print("Enter amount to withdraw: ");
                double withdraw = sc.nextDouble();
                if (withdraw > 0 && withdraw <= balance) {
                    balance -= withdraw;
                    System.out.printf("You have withdrawn: $%.2f%n", withdraw);
                    System.out.printf("New balance is: $%.2f%n", balance);
                } else {
                    System.out.println("Invalid withdrawal amount or insufficient funds.");
                }
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            default:
                System.out.println("Invalid option selected.");
        }
        sc.close();
    }
}
