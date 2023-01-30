import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
   This program takes in a list of baby names and prints all names
   that are both boy and girl names. 
*/
public class DualGenderNames
{
   /**
      Reads name information and returns it.  It also consumes the 
      count and percentage values on the input line.
      @return the next name
   */
   public static String processName(Scanner in)
   {
      String name = in.next();
      int count = in.nextInt();
      double percent = in.nextDouble();
      return name;
   }

   /**
      Prints all elements of boyNames and girlNames that are the same.
      @param boyNames an input array list
      @param girlNames an input array list
   */
   public static void printSameNames(ArrayList<String> boyNames,
         ArrayList<String> girlNames)
   {
      for (String name : boyNames)
      {
         if (girlNames.contains(name))
         {
            System.out.println(name);
         }
      }
   }

   public static void main(String[] args)
   {
      try (Scanner in = new Scanner(new File("babynames.txt")))
      {
         ArrayList<String> boyNames = new ArrayList<String>();
         ArrayList<String> girlNames = new ArrayList<String>();
   
         while (in.hasNextInt())
         {
            int rank = in.nextInt();
            boyNames.add(processName(in));
            girlNames.add(processName(in));
         }
         printSameNames(boyNames, girlNames);
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }  
   }
}
