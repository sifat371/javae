import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
   This class prints a report on the contents of a file.
*/
public class FileAnalyzer
{
   public static void main(String[] args) throws FileNotFoundException
   {  
      System.out.println("Filename: ");
      Scanner in = new Scanner(System.in);
      String name = in.nextLine();
      FileCounter counter = new FileCounter();
      try (Scanner fileIn = new Scanner(new File(name)))
      {
         counter.read(fileIn);
         System.out.println("Characters: " + counter.getCharacterCount());
         System.out.println("Words: " + counter.getWordCount());
         System.out.println("Lines: " + counter.getLineCount());
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File " + name + " not found");
      }
   }
}