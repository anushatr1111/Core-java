public class BankAccountValidationException {
    public static void main(String[] args) {
        String accountNumber = "12345"; // Example account number
        double balance = -100.0; // Example balance

        try {
            validateAccount(accountNumber, balance);
            System.out.println("Account is valid.");
        } catch (InvalidAccountNumberException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NegativeBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    static void validateAccount(String accountNumber, double balance) throws InvalidAccountNumberException, NegativeBalanceException {
        if (accountNumber.length() != 10) {
            throw new InvalidAccountNumberException("Account number must be 10 digits long.");
        }
        if (balance < 0) {
            throw new NegativeBalanceException("Balance cannot be negative.");
        }
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance!");
        }
        balance -= amount;
    }
}

class InvalidAccountNumberException extends Exception {
    InvalidAccountNumberException(String message) {
        super(message);
    }
}

class NegativeBalanceException extends Exception {
    NegativeBalanceException(String message) {
        super(message);
    }
}