/**
   Below is the CheckingAccount class from How To 9.1.
   Change the class so that a $1 fee is levied for deposits
   or withdrawals in excess of three free monthly transactions.
   Place the code for computing the fee into a separate
   method that you call from the deposit and withdraw
   methods.
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

