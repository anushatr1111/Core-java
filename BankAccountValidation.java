import java.util.Scanner;
public class BankAccountValidation {
    private String accountNumber;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber.length() != 10) {
            System.out.println("Account number must be 10 digits.");
        } else {
            this.accountNumber = accountNumber;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Balance cannot be negative.");
        } else {
            this.balance = balance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccountValidation account = new BankAccountValidation();

        System.out.print("Enter account number: ");
        account.setAccountNumber(sc.nextLine());

        System.out.print("Enter account balance: ");
        account.setBalance(sc.nextDouble());

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Balance: " + account.getBalance());
    }
}
