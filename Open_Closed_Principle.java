//*************************************************************************
// TITLE : A JAVA PROGRAMME TO DEMOSTRATE OPEN CLOSED PRINCIPLE
// AUTHOR : NAHID HASAN , UNDERGRADUATE STUDENT (2ND YEAR) OF KHULNA UNIVERSITY
//*************************************************************************


/**

 ** Summary of the following code

 * In this example, the Account interface defines a common method getBalance() 
   for getting the balance of different types of bank accounts. 
   Both SavingsAccount and CurrentAccount classes implement this interface 
   and provide their own implementations of the getBalance() method.

* The AccountBalanceCalculator class adheres to the Open/Closed Principle 
  by accepting an array of Account objects and calculating 
  the total balance without needing to modify its code 
  when new account types are introduced. This allows for easy extension 
  of the functionality without modifying existing code.

*/

/**
 * Interface representing a bank account.
 */
interface Account {
    /**
     * Gets the balance of the account.
     *
     * @return The balance of the account.
     */
    double getBalance();
}

/**
 * Class representing a savings account.
 */
class SavingsAccount implements Account {
    private double balance;

    /**
     * Constructs a savings account with the given initial balance.
     *
     * @param balance The initial balance of the account.
     */
    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

/**
 * Class representing a current account.
 */
class CurrentAccount implements Account {
    private double balance;

    /**
     * Constructs a current account with the given initial balance.
     *
     * @param balance The initial balance of the account.
     */
    public CurrentAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

/**
 * Utility class for calculating the total balance of bank accounts.
 */
class AccountBalanceCalculator {
    /**
     * Calculates the total balance of an array of bank accounts.
     *
     * @param accounts The array of bank accounts.
     * @return The total balance of all bank accounts.
     */
    public double calculateTotalBalance(Account[] accounts) {
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }
}

/**
 * Example usage of the bank account classes and balance calculator.
 */
public class Open_Closed_Principle {
    public static void main(String[] args) {
        Account[] accounts = {
            new SavingsAccount(5000),
            new CurrentAccount(3000)
        };

        AccountBalanceCalculator balanceCalculator = new AccountBalanceCalculator();
        double totalBalance = balanceCalculator.calculateTotalBalance(accounts);
        System.out.println("Total balance of accounts: " + totalBalance);
    }
}

