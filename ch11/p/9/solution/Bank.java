import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
   A bank contains account numbers and balances of each customer.
*/
public class Bank
{
   private ArrayList<BankAccount> accountList;

   /**
      Construct a Bank object.
   */
   public Bank()
   {
      accountList = new ArrayList<BankAccount>();
   }

   /**
      Reads a file with account numbers and balances and adds the accounts
      to the bank.
      @param filename the name of the file
   */
   public void readFile(String filename) throws IOException
   {
      try (Scanner in = new Scanner(new File(filename)))
      {
         read(in);
      } 
   }

   /**
      Read a file with account numbers and balances and adds the accounts
      to the bank.
      @param in the scanner for reading the input
   */
   private void read(Scanner in) throws IOException
   {
      while (in.hasNext())
      {
         BankAccount account = new BankAccount();
         account.read(in);
         addAccount(account);
      }
   }

   /**
      Add an account to the bank.
      @param b the BankAccount reference
   */
   public void addAccount(BankAccount b)
   {
      accountList.add(b);
   }

   /**
      Gets the account with the highest balance.
      @return the account with the highest balance
   */
   public BankAccount getHighestBalance()
   {
      BankAccount max = accountList.get(0);

      for (BankAccount account : accountList)
      {
         if (account.getBalance() > max.getBalance())
            max = account;
      }
      return max;
   }
}
