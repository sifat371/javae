/**
   A BasicAccount whose withdraw method will not
   withdraw more money than is currently in the account,
   but will print an error message instead.
   Use "Withdraw amount can't be larger than the balance."
*/
public class BasicAccount extends BankAccount
{
   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   BasicAccount(double initialBalance)
   {
      super(initialBalance);
   }

   /**
      Withdraws the specified amount.
      @param amount the amount to be withdrawn
   */
   @Override
   public void withdraw(double amount)
   {
      // If balance is larger than the withdraw amount, then subtract amount from balance
      if (getBalance() > amount)
      {
         super.withdraw(amount);
      }
      else
      {
         System.out.println("Withdraw amount can't be larger than the balance.");
      }
   }
}
