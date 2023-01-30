import java.io.*;
import java.util.*;

/**
   Reads and processes file containing bond energies and bond lengths for covalent bonds
*/
public class BondQuery
{
/** 
   Builds a list of bond indices matching a query.
   @param query data item to be found in bond list
   @param data list containing information about various bonds
   @return an ArrayList containing matching bond indices
*/
   private static ArrayList<Integer> findMatchingBonds(String query,
         ArrayList<String> data)
   {
      ArrayList<Integer> bondIndices = new ArrayList<Integer>();
      int i = 0;
      for (String datum : data)
      {
         if (datum.equals(query))
         {
            bondIndices.add(i);
         }
         i++;
      }

      return bondIndices;
   }

/** 
   Displays information about bonds whose indices are stored in a list.
   @param bondIndices list of bond indices to be displayed
   @param types list of bond types
   @param energies list of bond energies
   @param lengths list of bond lengths
*/
   private static void printBonds(ArrayList<Integer> bondIndices,
         ArrayList<String> types, ArrayList<String> energies,
         ArrayList<String> lengths)
   {
      for (Integer index : bondIndices)
      {
         System.out.println("Type: " + types.get(index) + " Energy: "
               + energies.get(index) + " Length: " + lengths.get(index));
      }
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      try (Scanner inFile = new Scanner(new File("bonds.txt")))
      {
         int last = 0;
         ArrayList<String> types = new ArrayList<String>();
         ArrayList<String> energies = new ArrayList<String>();
         ArrayList<String> lengths = new ArrayList<String>();

         boolean done = false;

         while (inFile.hasNextLine())
         {
            Scanner lineScanner = new Scanner(inFile.nextLine());
            types.add(lineScanner.next());
            energies.add(lineScanner.next());
            lengths.add(lineScanner.next());
         }

         while (!done)
         {
            System.out.println("T)ype E)nergy L)ength Q)uit: ");

            String option = in.next();
            System.out.println("Enter value to find: ");
            if (option.equals("T"))
            {
               String type = in.next();
               ArrayList<Integer> bondIndices = findMatchingBonds(type, types);
               printBonds(bondIndices, types, energies, lengths);
            }
            else if (option.equals("E"))
            {
               String energy = in.next();
               ArrayList<Integer> bondIndices = findMatchingBonds(energy,
                     energies);
               printBonds(bondIndices, types, energies, lengths);
            }
            else if (option.equals("L"))
            {
               String length = in.next();
               ArrayList<Integer> bondIndices = findMatchingBonds(length,
                     lengths);
               printBonds(bondIndices, types, energies, lengths);
            }
            else if (option.equals("Q"))
            {
               done = true;
            }
         }
      } 
      catch (NoSuchElementException e)
      {
         System.err.println("invalid input");
      } 
      catch (FileNotFoundException e)
      {
         System.err.println("File not found!");
      }
   }
}
