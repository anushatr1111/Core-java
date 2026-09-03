abstract class BankAccount {
    protected String accountHolder;
    protected double balance;

    abstract void withdraw(double amount);

    void deposit(double amount) {
        balance += amount;
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountHolder, double interestRate) {
        this.accountHolder = accountHolder;
        this.interestRate = interestRate;
    }

    @Override
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void addInterest() {
        balance += balance * interestRate;
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountHolder, double overdraftLimit) {
        this.accountHolder = accountHolder;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal denied. Exceeds overdraft limit.");
        }
    }
}