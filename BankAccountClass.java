import java.util.*;
public class BankAccountClass {
    String accountNumber;
    String accountHolderName;
    double balance;

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
    void deposit(double amount) {
        balance += amount;
    }
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    double checkBalance() {
        return balance;
    }
    public static void main(String[] args) {
        BankAccountClass account = new BankAccountClass();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account Number: ");
        account.accountNumber = sc.nextLine();
        System.out.println("Enter Account Holder Name: ");
        account.accountHolderName = sc.nextLine();
        System.out.println("Enter Balance: ");
        account.balance = sc.nextDouble();
        account.displayAccountDetails();
        sc.close();
    }
}
