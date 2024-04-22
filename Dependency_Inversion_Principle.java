/**

 * Summary of the code
 * In this example:

 * BankAccount is the high-level abstraction representing a bank account.
 * SavingsAccount and CheckingAccount are low-level concrete implementations of bank accounts.
 * TransactionProcessor is the high-level module responsible for transaction processing, 
   which depends on the abstraction BankAccount.
 * Concrete implementations (SavingsAccount and CheckingAccount) depend on the abstraction BankAccount.

 * By depending on the BankAccount interface, the TransactionProcessor class is decoupled 
   from specific account types, allowing it to work with any type of bank account. 
   This promotes flexibility, maintainability, and extensibility in the system, 
   adhering to the Dependency Inversion Principle.

 */



/**
 * Interface representing a bank account.
 */
interface BankAccount {
    double getBalance();

    void deposit(double amount);

    void withdraw(double amount);
}

/**
 * Concrete implementation of a savings account.
 */
class SavingsAccount implements BankAccount {
    private double balance;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }
}

/**
 * Concrete implementation of a checking account.
 */
class CheckingAccount implements BankAccount {
    private double balance;

    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }
}

/**
 * High-level module responsible for transaction processing.
 */
class TransactionProcessor {
    private final BankAccount account;

    public TransactionProcessor(BankAccount account) {
        this.account = account;
    }

    public void processTransaction(double amount) {
        account.withdraw(amount);
        // Additional transaction processing logic
    }
}

/**
 * Example usage demonstrating Dependency Inversion Principle.
 */
public class Dependency_Inversion_Principle {
    public static void main(String[] args) {
        // Using savings account for transaction processing
        BankAccount savingsAccount = new SavingsAccount(5000);
        TransactionProcessor processor1 = new TransactionProcessor(savingsAccount);
        processor1.processTransaction(2000);

        // Using checking account for transaction processing
        BankAccount checkingAccount = new CheckingAccount(3000);
        TransactionProcessor processor2 = new TransactionProcessor(checkingAccount);
        processor2.processTransaction(1500);
    }
}

