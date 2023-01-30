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
      Filter filt = new BalanceFilter().invert();

      System.out.println("Average: " + Data.average(accounts, meas, filt));
      System.out.println("Expected: 600.0");
   }
}
