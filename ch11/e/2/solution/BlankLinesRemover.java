import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
   Opens a file, removes any blank lines, reopens it, and prints the non-blank lines to the file.
*/
public class BlankLinesRemover
{
   /**
      Removes blank lines from the file given as argument and writes the non-blank lines
      back to the file.
      @param fileName the name of the file to be processed.
   */
   public static void removeLines(String fileName)
   {
      ArrayList<String> lines =  new ArrayList<>();
      try (Scanner in = new Scanner(new File(fileName)))
      {
         while (in.hasNextLine())
         {
            String line = in.nextLine();
            if (!line.trim().isEmpty())
            {
               lines.add(line);
            } 
         }
      } 
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      try (PrintWriter out = new PrintWriter(fileName))
      {
         for (String line: lines)
         {
            out.println(line);
         }
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
   }
}
