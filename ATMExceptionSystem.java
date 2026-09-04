import java.util.Scanner;

public class ATMExceptionSystem {
    public static void main(String[] args) {
        ATM atm = new ATM(5000, 1234);
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n===== ATM =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                if (choice == 4) break;
                System.out.print("Enter PIN: ");
                atm.checkPin(scanner.nextInt());

                switch (choice) {
                    case 1:
                        System.out.println("Balance: " + atm.checkBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        atm.deposit(scanner.nextDouble());
                        System.out.println("Deposit successful.");
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        atm.withdraw(scanner.nextDouble());
                        System.out.println("Withdrawal successful.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (ATMException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Thank you for using the ATM.");
        }
    }
}

class ATM {
    private double balance;
    private final int pin;

    ATM(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    void checkPin(int enteredPin) throws ATMException {
        if (enteredPin != pin) throw new ATMException("Wrong PIN!");
    }

    void deposit(double amount) throws ATMException {
        if (amount <= 0) throw new ATMException("Deposit amount must be positive.");
        balance += amount;
    }

    void withdraw(double amount) throws ATMException {
        if (amount <= 0) throw new ATMException("Withdrawal amount must be positive.");
        if (amount > balance) throw new ATMException("Insufficient balance!");
        balance -= amount;
    }

    double checkBalance() {
        return balance;
    }
}

class ATMException extends Exception {
    ATMException(String message) {
        super(message);
    }
}
