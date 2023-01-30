/**
   Reimplement the CheckingAccount class so that the
   first overdraft in any given month incurs a $20 penalty,
   and any further overdrafts in the same month
   result in a $30 penalty.
*/
public class CheckingAccount extends BankAccount
{
   private int withdrawals;
   private int overdrafts;

   /**
      Constructs a checking account with a 0 balance.
   */
   public CheckingAccount()
   {
      // Initialize withdrawals and overdrafts
      withdrawals = 0;
      overdrafts = 0;
   }

   /**
      Withdraws money from the bank account
      @param amount the amount to withdraw
   */
   @Override
   public void withdraw(double amount)
   {
      final int FREE_WITHDRAWALS = 3;
      final int WITHDRAWAL_FEE = 1;
      final int FIRST_OVERDRAFT_FEE = 20;
      final int OVERDRAFT_FEE = 30;

      // Always get the fee, no matter what
      withdrawals++;
      if (withdrawals > FREE_WITHDRAWALS)
      {
         super.withdraw(WITHDRAWAL_FEE);
      }

      // Now, is there enough to cover the amount?
      if(amount > getBalance())
      {
         overdrafts++;
         if (overdrafts > 1)
         {
            amount += OVERDRAFT_FEE;
         }
         else
         {
            amount += FIRST_OVERDRAFT_FEE;
         }
      }
      super.withdraw(amount);
   }

   /**
      Performs the end month processes.
   */
   public void monthEnd()
   {
      withdrawals = 0;
      overdrafts = 0;
   }
}
