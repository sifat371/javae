/**
 * Tests the BasicAccount.
 */
public class BasicAccountTester
{
   public static void main(String[] args)
   {
      //An BasicAccount with initial balance of 100.00
      BankAccount account = new BasicAccount(100.00);
      System.out.println(account.getBalance());
      System.out.println("Expected: 100.0");

      /*withdraw - If the amount is larger than the balance,
      the withdraw request will be denied
      */
      account.withdraw(80.00);
      System.out.println(account.getBalance());
      System.out.println("Expected: 20.0");

      /*withdraw - If the amount is larger than the balance,
      the withdraw request will be denied
      */
      account.withdraw(50);
      System.out.println("Expected: Withdraw amount can't be larger than the balance.");
      System.out.println(account.getBalance());
      System.out.println("Expected: 20.0");
   }
}
