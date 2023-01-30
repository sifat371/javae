
public class AccountTester
{
   public static void main(String[] args)
   {
      BankAccount checking = new CheckingAccount();
      checking.deposit(1000);
      checking.withdraw(100);
      checking.withdraw(100);
      System.out.println(checking.getBalance());
      System.out.println("Expected: 800.0");
      // Have now used up our 3 free transactions
      checking.deposit(200);
      System.out.println(checking.getBalance());
      System.out.println("Expected: 999.0");
      checking.withdraw(100);
      System.out.println(checking.getBalance());
      System.out.println("Expected: 898.0");
   }
}
