import java.util.ArrayList;
import java.util.Scanner;

public class BankingApplication {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Welcome to the Banking Application!");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Create an account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. View account details");
            System.out.println("6. View transaction history");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performWithdrawal();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    viewAccountDetails();
                    break;
                case 6:
                    viewTransactionHistory();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting Banking Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void createAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();

        Account newAccount = new Account(accountNumber, accountHolderName, initialDeposit);
        accounts.add(newAccount);

        System.out.println("Account created successfully!");
    }

    private static Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    private static void performDeposit() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void performWithdrawal() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.println("Current balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void viewAccountDetails() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);

        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void viewTransactionHistory() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);

        if (account != null) {
            account.displayTransactionHistory();
        } else {
            System.out.println("Account not found.");
        }
    }
}

