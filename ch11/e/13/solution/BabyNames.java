import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
   This program displays the most common baby names given an input file.
*/
public class BabyNames
{
   public static final int LIMIT = 50;

   /**
      Processes the names that are read from the provided Scanner.
      @param in Scanner from which to read the baby names
   */
   private static void processNames(Scanner in)
   {
      int numBoys = in.nextInt();
      int numGirls = in.nextInt();
      RecordReader boys = new RecordReader(LIMIT, numBoys);
      RecordReader girls = new RecordReader(LIMIT, numGirls);

      while (in.hasNext() && (boys.hasMore() || girls.hasMore()))
      {
         int rank = in.nextInt();
         System.out.print(rank + " ");

         boys.process(in);
         girls.process(in);
         System.out.println();
      }
   }

   public static void main(String[] args) throws IOException
   {
      Scanner console = new Scanner(System.in);
      System.out.print("Enter the name of a file: ");
      if (console.hasNext())
      {
         String filename = console.next();

         try (Scanner in = new Scanner(new File(filename)))
         {
            processNames(in);
         } 
         catch (FileNotFoundException e)
         {
            System.err.println(filename + " not found");
         }
      }
      else
      {
         System.err.println("file name required");
      }
   }
}
