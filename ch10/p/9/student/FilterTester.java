/**
   Demonstration of filter on bank accounts
*/
public class FilterTester
{
   public static void main(String[] args)
   {
      BankAccount accounts[] = new BankAccount[5];
      accounts[0] = new BankAccount(900);
      accounts[1] = new BankAccount(3000);
      accounts[2] = new BankAccount(300);
      accounts[3] = new BankAccount(5000);
      accounts[4] = new BankAccount(1000);

      BalanceMeasurer meas = new BalanceMeasurer();
      BalanceFilter filt = new BalanceFilter();

      System.out.println("Average: " + Data.average(accounts, meas, filt));
      System.out.println("Expected: 3000.0");
      Filter.retainAll(accounts, filt);
      System.out.print("Accounts balances retained: ");
      for (BankAccount account: accounts)
      {
         if (account != null)
         {
            System.out.print(account.getBalance() + " ");
         }
      }
      System.out.print("\nExpected: 3000.0 5000.0 1000.0 ");
   }
}
