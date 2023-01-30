import java.io.*;
import java.util.*;

public class BalanceTransactions
{
   public static void main(String[] args)
   {
      final double EPSILON = 1E-14;
      Scanner in = new Scanner(System.in);
   
      System.out.print("Please enter the file name for input: ");
      String filename = in.next();
   
      System.out.print("Please enter the cash amount at the start: ");
      double start = in.nextDouble();
   
      System.out.print("Please enter the cash amount at the end: ");
      double end = in.nextDouble();
   
      try (Scanner inFile = new Scanner(new File(filename)))
      {
         double runningTotal = start;
      
         while (inFile.hasNextLine())
         {
            String str = inFile.nextLine();
            Scanner lineScanner = new Scanner(str);
         
            int invoice = Integer.parseInt(lineScanner.next());
            double amount = Double.parseDouble(lineScanner.next());
            String code = lineScanner.next();
         
            if (code.equals("R"))
            {
               runningTotal = runningTotal + amount;
            }
            if (code.equals("P"))
            {
               runningTotal = runningTotal - amount;
            }
         }
      
         if (runningTotal - EPSILON <= end && end <= runningTotal + EPSILON)
         {
            System.out.println("End of day total is properly balanced.");
         }
         else
         {
            System.out.println("End of day total is not balanced.");
            System.out.println("Computed ending total: " + runningTotal);
         }
      } 
      catch (NoSuchElementException e)
      {
         System.err.println("invalid input");
      } 
      catch (FileNotFoundException e)
      {
         System.err.println("File not found!");
      }
   }
}
