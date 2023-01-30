/**
   Implement a subclass of BankAccount called
   BasicAccount whose withdraw method charges a
   penalty of $30 for each withdrawal that
   results in an overdraft.
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
      Charges a penalty of $30 for each withdrawal that
      results in an overdraft.
      @param amount the amount to be withdrawn
   */
   @Override
   public void withdraw(double amount)
   {
      // If this is a overdraft, charge $30 penalty
      if (( getBalance() - amount < 0))
      {
         amount = amount + 30;
      }

      super.withdraw(amount);
   }
}
