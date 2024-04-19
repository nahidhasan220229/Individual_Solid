/**
 * Interface representing a deposit operation.
 */
interface Deposit {
    void deposit(double amount);
}

/**
 * Interface representing a withdraw operation.
 */
interface Withdraw {
    void withdraw(double amount);
}

/**
 * Class representing a savings account implementing deposit operation.
 */
class SavingsAccount implements Deposit {
    private double balance;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

/**
 * Class representing a current account implementing both deposit and withdraw operations.
 */
class CurrentAccount implements Deposit, Withdraw {
    private double balance;

    public CurrentAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

/**
 * Example usage of the bank account classes.
 */
public class Interface_Segregation_Principle {
    public static void main(String[] args) {
        Deposit savingsAccount = new SavingsAccount(5000);
        savingsAccount.deposit(2000);
        System.out.println("Savings account balance after deposit: " + ((SavingsAccount) savingsAccount).getBalance());

        Withdraw currentAccount = new CurrentAccount(3000);
        currentAccount.withdraw(1000);
        System.out.println("Current account balance after withdrawal: " + ((CurrentAccount) currentAccount).getBalance());
    }
}

/**
 * In this example, SavingsAccount implements only the Deposit interface because it 
   only supports deposit operations. CurrentAccount, on the other hand, implements 
   both the Deposit and Withdraw interfaces as it supports both deposit and withdrawal operations.

 * By segregating the interfaces into smaller, more specific ones, we ensure that each class
   only needs to implement the methods relevant to its functionality, adhering to the 
   Interface Segregation Principle.
 
 */