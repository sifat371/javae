import java.util.ArrayList;
import java.util.Scanner;

/**
   A class to check the spelling of words.
*/
public class SpellChecker
{
   private ArrayList<String> wordsList;

   /**
      Construct a SpellingCheck object.
      @param in the scanner containing a list of properly spelled words
   */
   public SpellChecker(Scanner in)
   {
         
      wordsList = new ArrayList<String>(); 
      boolean more = true;
      
      while (in.hasNextLine())
      {
         String w = in.nextLine();
         wordsList.add(w.toLowerCase());
      }
   }

   /**
      Checks if a word is in the word list (ignoring letter case and punctuation)
      @param word the word to check for
      @return true if word was found, false otherwise
   */
   public boolean check(String word)
   {
      boolean isFound = false;
      
      for (int i = 0; i < wordsList.size();i++)
      {
         if (word.replaceAll("[^A-Za-z]+", "").equalsIgnoreCase(wordsList.get(i)))
            isFound = true;
      }
               
      return isFound;
   }
}