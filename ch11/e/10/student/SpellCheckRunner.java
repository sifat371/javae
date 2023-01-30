import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/**
   This program runs a spell check. 
*/
public class SpellCheckRunner 
{ 
   public static void main(String[] args)
   { 
      Scanner in = new Scanner(System.in);
      System.out.println("Word list file: ");
      String dictionary = in.nextLine();
   
      try (Scanner dictIn = new Scanner(new File(dictionary)))
      {
         SpellChecker checker = new SpellChecker(dictIn);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Word list file: " + dictionary + " not found.");
      }
   
      System.out.println("File to check: ");
      String filename = in.nextLine();
     
      try (Scanner fileIn = new Scanner(new File(filename)))
      {
         while (fileIn.hasNext())
         {
            String word = fileIn.next();
            if (!checker.check(word))
               System.out.println(word);
         }
      }	
      catch (FileNotFoundException e)
      {
         System.out.println("File: " + filename + " not found.");
      }
   }
}