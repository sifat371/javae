import java.io.*;
import java.util.*;

public class SalesSplit
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
      Writes sale to writer.
      @param out PrintWriter to which sale is written
      @param sale sale information
   */
   private static void writeSale(PrintWriter out, Sale sale)
   {
      out.print(sale.getName());
      out.print(";");
      out.print(sale.getServiceCategory());
      out.print(";");
      out.print(sale.getAmount());
      out.print(";");
      out.print(sale.getDate());
      out.println();
   }

   /**
      Stores sales for category to new file.
      @param category service category to store
      @param sales list of sales
   */
   private static void writeCategorySalesToFile(String category,
         ArrayList<Sale> sales)
   {
      try (PrintWriter out = new PrintWriter(category + ".txt"))
      {
         for (Sale sale : sales)
         {
            if (sale.getServiceCategory().equals(category))
            {
               writeSale(out, sale);
            }
         }
      } 
      catch (FileNotFoundException e)
      {
         System.err.println("Cannot write to " + category + ".txt");
      }
   }

   /**
      Writes sales for each category to a separate file.
      @param categories list of service categories
      @param sales list of sales
   */
   private static void writeCategorySales(ArrayList<String> categories,
         ArrayList<Sale> sales)
   {
      for (String category : categories)
      {
         writeCategorySalesToFile(category, sales);
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
         writeCategorySales(categories, sales);
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
