import java.util.Scanner;

/**
   This class processes baby name records.
*/
public class RecordReader
{
   private double total;
   private double limit;
   private int numNamed;

   /**
      Constructs a RecordReader with a zero total.
      @param aLimit the percentage at which to stop processing
      @param totalNamed the total number of named children
   */
   public RecordReader(double aLimit, int totalNamed)
   {
      total = 0;
      limit = aLimit;
      numNamed = totalNamed;
   }

   /**
      Takes a number which may have commas in it and converts it to an int.
      @param numberAsString the string number to convert
      @return the integer value of numberAsString
   */
   public static int convertWithCommas(String numberAsString)
   {
      String number = "";
      for (int i = 0; i < numberAsString.length(); i++)
      {
         if (numberAsString.charAt(i) != ',')
         {
            number = number + numberAsString.charAt(i);
         }
      }
      return Integer.parseInt(number);
   }

   /**
      Reads an input record and prints the name if the current total is less
      than the limit.
      @param in the input stream
   */
   public void process(Scanner in)
   {
      String name = in.next();
      int count = convertWithCommas(in.next());
      double percent = count * 100.0 / numNamed;

      if (total < limit)
      {
         System.out.print(name + " ");
      }
      total = total + percent;
   }

   /**
      Checks whether there are more inputs to process.
      @return true if the limit has not yet been reached
   */
   public boolean hasMore()
   {
      return total < limit;
   }
}
