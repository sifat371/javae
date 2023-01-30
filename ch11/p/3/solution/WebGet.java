import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
   This program reads all data from a web page and writes it to a file.
*/
public class WebGet
{
   /**
      This method reads all input from a scanner and prints it to a file
      @param in the scanner to read from
      @param filename the name of the file to write to
   */
   public static void dumpScannerToFile(Scanner in, String filename)
   {
      try (PrintWriter outfile = new PrintWriter(filename))
      {
         while (in.hasNextLine())
         {
            String line = in.nextLine();
            outfile.println(line);
         }
      } 
      catch (FileNotFoundException e)
      {
         System.out.println("Cannot write to file " + filename);
      }
   }

   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
   
      System.out.println("Enter the url to scan: ");
      String url = console.nextLine();
   
      System.out.println("Enter the file to write to: ");
      String fileName = console.nextLine();
   
      URL locator;
      try
      {
         locator = new URL(url);
         try (Scanner in = new Scanner(locator.openStream()))
         {
            dumpScannerToFile(in, fileName);
         } 
         catch (IOException e)
         {
            System.out.println("IO Exception!");
         }
      }
      catch (MalformedURLException e)
      {
         System.out.println("Invalid URL.");
      }       
      
   }
}
