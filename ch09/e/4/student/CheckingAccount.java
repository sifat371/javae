/**
   Reimplement the CheckingAccount class below so that the
   first overdraft in any given month incurs a $20 penalty,
   and any further overdrafts in the same month
   result in a $30 penalty.
*/
public class CheckingAccount extends BankAccount
{
   private int withdrawals;

   /**
      Constructs a checking account with a zero balance.
   */
   public CheckingAccount()
   {
      withdrawals = 0;
   }

   public void withdraw(double amount)
   {
      final int FREE_WITHDRAWALS = 3;
      final int WITHDRAWAL_FEE = 1;

      super.withdraw(amount);
      withdrawals++;
      if (withdrawals > FREE_WITHDRAWALS)
      {
         super.withdraw(WITHDRAWAL_FEE);
      }
   }

   public void monthEnd()
   {
      withdrawals = 0;
   }
}

