import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

/**
   This class counts letter frequencies in a file.
*/
public class FrequencyCounter
{  
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      System.out.println("Filename: ");
      String filename = in.next();
      
      try(Reader reader = new FileReader(filename))
      {         
         FrequencyMap map = new FrequencyMap();
         boolean done = false;
         while (!done)
         {  
            int next = reader.read();
            if (next == -1) 
               done = true;
            else if (Character.isLetter((char) next))
               map.add(Character.toUpperCase((char) next));
         }
         reader.close();
         for (char c = 'A'; c <= 'Z'; c++)
            System.out.printf("%c:%5.2f%%%n", c, map.getFrequency(c));
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
