//*************************************************************************
// Title : A java programme to demonstrate Single Responsibility Principle.
// Author : Nahid Hasan,Student ID: 220229, Undergrduate student, Khulna University.
//*************************************************************************
/**

/**
 * This class represents a BankAccount entity with a single responsibility of managing account balance.
 */
class BankAccount {
    
    private double balance;

    /**
     * Constructs a BankAccount object with an initial balance.
     * 
     * @param initialBalance the initial balance of the account
     */
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * Gets the current balance of the account.
     * 
     * @return the current balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits the specified amount into the account.
     * 
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + " successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    /**
     * Withdraws the specified amount from the account.
     * 
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }
}

/**
 * Main class to demonstrate the usage of the BankAccount class.
 */
class Single_Responsibility_Principle {

    public static void main(String[] args) {
        // Create a new bank account with an initial balance of $1000
        BankAccount account = new BankAccount(1000);

        // Display initial balance
        System.out.println("Initial balance: " + account.getBalance());

        // Deposit $500 into the account
        account.deposit(500);

        // Withdraw $200 from the account
        account.withdraw(200);

        // Withdraw $1500 from the account (should fail due to insufficient funds)
        account.withdraw(1500);

        // Display final balance
        System.out.println("Final balance: " + account.getBalance());
    }
}


/**
 * In this example, every class has only one responsibility. This is the main motto of 
   Single Responsibility Principle.
 */