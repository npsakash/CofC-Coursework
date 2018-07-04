
import java.util.Scanner;
/**
 Class of savings accounts.
*/
public class SavingsAccount
{
	private double balance;
    private static double interestRate = 0;
    private static int numberOfAccounts = 0;

    public SavingsAccount()
    {
        balance = 0;
		numberOfAccounts++;
    }

	/** Sets the interest rate for all accounts. */
    public static void setInterestRate(double newRate)
    {
        interestRate = newRate;
    }

    public static double getInterestRate()
    {
        return interestRate;
    }

    public static int getNumberOfAccounts()
    {
        return numberOfAccounts;
    }

    public void deposit(double amount)
    {
        balance = balance + amount;
    }

    public double withdraw(double amount)
    {
		if (balance >= amount)
			balance = balance - amount;
		else
			amount = 0;
        return amount;
    }

    public void addInterest()
    {
	    double interest = balance * interestRate; //balance * getInterestRate()	
	    balance = balance + interest;
    }
	
    public double getBalance()
    {
        return balance;
    }

    public static void showBalance(SavingsAccount account)
	{
		System.out.print(account.getBalance());	 
	}
}
