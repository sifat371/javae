import java.io.*;
import java.util.*;

public class SalesTally
{
   /**
      Prompts for and reads name of file to process.
      @param in Scanner from which to read
      @return file name
   */
   private static String getFileName(Scanner in)
   {
      String filename = null;
      System.out.print("Enter file to process: ");
      if (in.hasNext())
      {
         filename = in.next();
      }

      return filename;
   }

   /**
      Read a sales entry from input Scanner.
      @param in Scanner from which to read entry
   */
   private static Sale readSaleEntry(Scanner in)
   {
      String inputLine = in.nextLine();
      Scanner lineScan = new Scanner(inputLine);
      lineScan.useDelimiter(";");

      String name = lineScan.next();
      String service = lineScan.next();
      double amount = lineScan.nextDouble();
      String date = lineScan.next();

      return new Sale(name, service, amount, date);
   }

   /**
      Reads sales data from the specified file.
      @param filename name of sales data file
   */
   private static ArrayList<Sale> readSalesFile(String filename)
         throws FileNotFoundException
   {
      ArrayList<Sale> sales = new ArrayList<Sale>();

      if (filename != null)
      {
         try (Scanner infile = new Scanner(new File(filename)))
         {
            while (infile.hasNext())
            {
               sales.add(readSaleEntry(infile));
            }
         } 
      }

      return sales;
   }

   /**
      Gather categories from list of sales.
      @param sales list of sales
      @return list of categories
   */
   private static ArrayList<String> gatherCategories(ArrayList<Sale> sales)
   {
      ArrayList<String> categories = new ArrayList<String>();

      for (Sale sale : sales)
      {
         if (!categories.contains(sale.getServiceCategory()))
         {
            categories.add(sale.getServiceCategory());
         }
      }

      return categories;
   }

   /**
      Computes the total sales for a given service category.
      @param category service category for which to compute total
      @param sales list of sales
   */
   private static double computeCategoryTotal(String category,
         ArrayList<Sale> sales)
   {
      double total = 0.0;

      for (Sale sale : sales)
      {
         if (sale.getServiceCategory().equals(category))
         {
            total = total + sale.getAmount();
         }
      }

      return total;
   }

   /**
      Prints total sales for service categories.
      @param categories list of service categories
      @param sales list of sales
   */
   private static void printCategoryTotals(ArrayList<String> categories,
         ArrayList<Sale> sales)
   {
      for (String category : categories)
      {
         double total = computeCategoryTotal(category, sales);
         System.out.println(category + " total : " + total);
      }
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      String filename = getFileName(in);

      try
      {
         ArrayList<Sale> sales = readSalesFile(filename);
         ArrayList<String> categories = gatherCategories(sales);
         printCategoryTotals(categories, sales);
      } 
      catch (FileNotFoundException e)
      {
         System.out.println("File not found!");
      } 
      catch (NoSuchElementException e)
      {
         System.out.println("File format not valid.");
      }
   }
}
