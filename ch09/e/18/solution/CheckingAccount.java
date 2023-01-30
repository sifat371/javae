/**
   A checking account has a limited number of free deposits and withdrawals.
*/
public class CheckingAccount extends BankAccount
{
   private int transactions;

   /**
      Constructs a checking account with a zero balance.
   */
   public CheckingAccount()
   {
      transactions = 0;
   }

   /**
      Withdraws the given amount and possibly incurs fees.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {
      super.withdraw(amount);
      transactions++;
      levyFees();
   }

   /**
      Deposits the given amount and possibly incurs fees.
      @param amount the amount to withdraw
   */
   public void deposit(double amount)
   {
      super.deposit(amount);
      transactions++;
      levyFees();
   }

   /**
      A method to withdraw fees on the account if the number
      of transactions exceeds 3. 
   */
   private void levyFees()
   {
      final int FREE_TRANSACTIONS = 3;
      final int FEE = 1;

      if (transactions > FREE_TRANSACTIONS)
      {
         super.withdraw(FEE);
      }
   }

   /**
      Closes out the account at the month's end
   */
   public void monthEnd()
   {
      transactions = 0;
   }
}
