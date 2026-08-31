import java.util.Scanner;
public class ATMSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", "123456789");
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== ATM =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful");
                    System.out.println("Balance: ₹" + account.getBalance());
                    break;

                case 3:
                    System.out.print("Enter amount: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful");
                        System.out.println("Balance: ₹" + account.getBalance());
                    } else {
                        System.out.println("Insufficient balance");
                    }
                    break;

                case 4:
                    account.displayAccountDetails();
                    break;

                case 5:
                    System.out.println("Exiting ATM...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    static class BankAccount {
        private double balance;
        private String accountHolderName;
        private String accountNumber;

        public BankAccount(String accountHolderName, String accountNumber) {
            this.accountHolderName = accountHolderName;
            this.accountNumber = accountNumber;
            this.balance = 10000.0;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public double getBalance() {
            return balance;
        }

        public void displayAccountDetails() {
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: ₹" + balance);
        }
    }
}

