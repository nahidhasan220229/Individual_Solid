//*************************************************************************
// TITLE : A JAVA PROGRAMME TO DEMOSTRATE LISKOV SUBSTITUTION PRINCIPLE
// AUTHOR : NAHID HASAN , UNDERGRADUATE STUDENT (2ND YEAR) Of KHULNA UNIVERSITY
//*************************************************************************

/**

 ** Summary of the following code
 
 * In this example, both SavingsAccount and CheckingAccount implement the BankAccount interface. 
   According to the Liskov Substitution Principle, 
   we should be able to use a SavingsAccount wherever a BankAccount is expected, 
   and vice versa, without altering the behavior of the program.

 * Each account type implements the common operations defined in the BankAccount interface (getBalance(),
   deposit(), withdraw()), but they can have their own specific implementation details,
   such as overdraft protection for a checking account or interest calculation for a savings account. 
   Despite these differences, the behavior of the program remains consistent when using either 
   type of account, adhering to the Liskov Substitution Principle. 
   
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
 * Class representing a savings account.
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
 * Class representing a checking account.
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
 * Example usage demonstrating Liskov Substitution Principle.
 */
public class Liskov_Substitution_Principle {
    public static void main(String[] args) {
        BankAccount savingsAccount = new SavingsAccount(5000);
        BankAccount checkingAccount = new CheckingAccount(3000);

        // Perform operations on savings account
        savingsAccount.deposit(2000);
        savingsAccount.withdraw(1000);
        System.out.println("Savings account balance: " + savingsAccount.getBalance());

        // Perform operations on checking account
        checkingAccount.deposit(1500);
        checkingAccount.withdraw(2000);
        System.out.println("Checking account balance: " + checkingAccount.getBalance());
    }
}


