import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false; 
        }
        balance = balance - amount;
        return true; 
    }

    public double checkBalance() {
        return balance;
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(1000.0); 

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = x.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to be withdrawn: Rs.");
                    double w = x.nextDouble();
                    boolean withdrawalSuccess = userAccount.withdraw(w);
                    if (withdrawalSuccess) {
                        System.out.println("Withdrawal of Rs" + w + " successfully done.");
                    } else {
                        System.out.println("Insufficient balance for withdrawal.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the amount to be deposited: Rs");
                    double d = x.nextDouble();
                    userAccount.deposit(d);
                    System.out.println("Deposited Successfully Rs" + d);
                    break;

                case 3:
                    double b = userAccount.checkBalance();
                    System.out.println("Account balance is: Rs" + b);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    x.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please choose a correct option.");
            }
        }
    }
}