/**
 * Tests the BasicAccount.
 */
public class BasicAccountTester
{
   public static void main(String[] args)
   {
      //An BasicAccount with initial balance of 100.00 dollars
      BankAccount account = new BasicAccount(100.00);

      //No overdraft, so no penalty.
      account.withdraw(80.00);
      System.out.println(account.getBalance());
      System.out.println("Expected: 20.0");

      //If this is a overdraft, charges $30 penalty
      account.withdraw(50.00);
      System.out.println(account.getBalance());
      System.out.println("Expected: -60.0");

       //If this is a overdraft, charges $30 penalty
      account.withdraw(50.00);
      System.out.println(account.getBalance());
      System.out.println("Expected: -140.0");
   }
}
