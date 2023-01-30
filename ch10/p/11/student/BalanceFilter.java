/**
   Filter out balance less than $1,000.
*/
public class BalanceFilter implements Filter
{
   /**
      Accept balances no less than $1,000
      @param object bank account
      @return true if balance is no less than $1,000
   */
   public boolean accept(Object object)
   {
      return ((BankAccount) object).getBalance() >= 1000;
   }
}
