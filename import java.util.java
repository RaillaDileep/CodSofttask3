import java.util.Scanner;

public class AtmMachine {

    private BankAccount account;
    private Scanner scanner = new Scanner(System.in);

    public AtmMachine(BankAccount account) {
        this.account = account;
    }

    public void displayMainMenu() {
        System.out.println("Welcome to your friendly neighborhood ATM!");
        System.out.println("Please select a transaction: ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processTransaction() {
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                withdrawMoney();
                break;
            case 2:
                depositMoney();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using our ATM. Have a nice day!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    private void withdrawMoney() {
        System.out.println("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        if (account.getBalance() < amount) {
            System.out.println("Insufficient funds. Please try a lower amount.");
        } else {
            account.withdraw(amount);
            System.out.println("Withdrawal successful. Your new balance is: " + account.getBalance());
        }
    }

    private void depositMoney() {
        System.out.println("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: " + account.getBalance());
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        AtmMachine atm = new AtmMachine(account);

        while (true) {
            atm.displayMainMenu();
            atm.processTransaction();
        }
    }
}

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}