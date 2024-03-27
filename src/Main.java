import java.util.*;

class BankAccount {
    private int balance;

    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount());
        accounts.add(new BankAccount());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Simple Banking App");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw ");
            System.out.println("3. Transfer ");
            System.out.println("4. Check balances ");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter deposit sum");
                    int inputDeposit = scanner.nextInt();
                    scanner.nextLine();
                    accounts.get(0).deposit(inputDeposit);
                    break;
                case 2:
                    System.out.println("Enter withdraw sum");
                    int inputWithdraw = scanner.nextInt();
                    scanner.nextLine();
                    accounts.get(0).withdraw(inputWithdraw);
                    break;
                case 3:
                    System.out.println("Enter amount of money you want to transfer");
                    int inputTransferCash = scanner.nextInt();
                    System.out.println("Enter account number you want to transfer money to");
                    int recipientAccountIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (recipientAccountIndex >= 0 && recipientAccountIndex < accounts.size()) {
                        accounts.get(0).transfer(accounts.get(recipientAccountIndex), inputTransferCash);
                    } else {
                        System.out.println("Invalid account number.");
                    }
                    break;
                case 4:
                    System.out.println("Check accounts balance");
                    for (int i = 0; i < accounts.size(); i++) {
                        printBalance(accounts, i);
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

    public BankAccount() {
        this.balance = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
            System.out.println("Your new balance is " + balance + " euro");
        } else {
            System.out.println("Error, please check your balance or deposit sum entered!");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("You have withdrawn " + amount + " euro successfully.");
            System.out.println("Your new balance is " + balance + " euro");
        } else {
            System.out.println("Error, please check your balance or withdraw sum entered!");
        }
    }

    public static void printBalance(ArrayList<BankAccount> accounts, int id) {
        System.out.println("Current balance of account with id " + id + ": " + accounts.get(id).balance);
    }

    public void transfer(BankAccount recipient, int amount) {
        if (amount > 0 && balance >= amount) {
            this.withdraw(amount);
            recipient.deposit(amount);
            System.out.println(amount + " transferred successfully.");
            System.out.println("Your new balance is " + balance + " euro");
        } else {
            System.out.println("Insufficient balance or invalid amount for transfer.");
        }
    }
}
