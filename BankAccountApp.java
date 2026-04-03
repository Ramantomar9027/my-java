import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance < 0 ? 0 : initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
        else System.out.println("Deposit must be positive.");
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
        else System.out.println("Invalid withdrawal.");
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Account number: ");
        String accNum = sc.nextLine();

        System.out.print("Initial balance: ");
        double initBal = 0;
        try {
            initBal = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid balance, set to 0.");
        }

        BankAccount account = new BankAccount(accNum, initBal);

        while (true) {
            System.out.print("\n1.Deposit 2.Withdraw 3.Balance 4.Exit: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Deposit amount: ");
                    try {
                        account.deposit(Double.parseDouble(sc.nextLine()));
                    } catch (Exception e) {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case "2":
                    System.out.print("Withdraw amount: ");
                    try {
                        account.withdraw(Double.parseDouble(sc.nextLine()));
                    } catch (Exception e) {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case "3":
                    System.out.printf("Balance: $%.2f%n", account.getBalance());
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Choose 1-4.");
            }
        }
    }
}
