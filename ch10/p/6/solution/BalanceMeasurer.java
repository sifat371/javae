/**
   Measure bank account balance
*/
public class BalanceMeasurer implements Measurer
{
   /**
      Measure bank account balance
      @param object bank account
      @return balance
   */
   public double measure(Object object)
   {
      return ((BankAccount) object).getBalance();
   }
}
