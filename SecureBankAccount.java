public class SecureBankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public SecureBankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void displayAccount() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Holder: " + this.accountHolder);
        System.out.println("Balance: " + this.balance);
    }
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance");
        }
    }
    public void withdrawAmount(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("Invalid withdrawal");
        }
    }
    public static void main(String[] args) {
        SecureBankAccount account = new SecureBankAccount(12345, "John Doe", 1000.0);
        account.displayAccount();

        account.deposit(500.0);
        account.displayAccount();

        account.withdraw(200.0);
        account.displayAccount();

        account.withdrawAmount(1500.0); // Invalid withdrawal
        account.displayAccount();

        account.setBalance(-100000); // Invalid balance
        account.displayAccount();
    }
}
