import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    private static String USER_ID = "JANANI";
    private static String USER_PIN = "4072";
    private static double balance = 10000.0;
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Welcome to ATM =====");

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (USER_ID.equals(userId) && USER_PIN.equals(pin)) {
            System.out.println("Login Successful!\n");
            showMenu(sc);
        } else {
            System.out.println("Invalid User ID or PIN");
        }

        sc.close();
    }

    private static void showMenu(Scanner sc) {
        int choice;

        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdraw(sc);
                    break;
                case 3:
                    deposit(sc);
                    break;
                case 4:
                    transfer(sc);
                    break;
                case 5:
                    System.out.println("Thank you for using ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 5);
    }

    private static void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("\n--- Transaction History ---");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    private static void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
            System.out.println("Please collect your cash.");
            System.out.println("Available Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private static void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        balance += amount;
        transactionHistory.add("Deposited: " + amount);
        System.out.println("Amount deposited successfully.");
        System.out.println("Available Balance: " + balance);
    }

    private static void transfer(Scanner sc) {
        sc.nextLine(); // clear buffer

        System.out.print("Enter recipient account number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transferred: " + amount + " to Account: " + accountNumber);
            System.out.println("Transfer successful.");
            System.out.println("Available Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

