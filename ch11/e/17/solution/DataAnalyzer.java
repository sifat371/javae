import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DataAnalyzer
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      DataSetReader reader = new DataSetReader();
      
      boolean done = false;
      while (!done) 
      {
         try 
         {
            System.out.println("Please enter the file name: ");
            String filename = in.next();
            
            double[] data = reader.readFile(filename);
            double sum = 0;
            for (double d : data) 
            {
               sum = sum + d;
            } 
            System.out.println("Sum: " + sum);
            done = true;
         }
         catch (FileNotFoundException e)
         {
            System.out.println("File not found.");
         }
         catch (BadDataException e)
         {
            System.out.println("Bad data: " + e.getMessage());
         }
         catch (IOException e)
         {
            e.printStackTrace();
         }
      }
   }
}