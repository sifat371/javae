import java.io.IOException;
import java.io.RandomAccessFile;

/**
   This class is a conduit to a random access file
   containing savings product data.
*/
public class ProductData
{
   private RandomAccessFile file;

   public static final int INT_SIZE = 4;  
   public static final int DOUBLE_SIZE = 8;  
   public static final int NAME_LENGTH = 30;
   public static final int NAME_SIZE = 2 * NAME_LENGTH;
   public static final int RECORD_SIZE 
         = INT_SIZE + DOUBLE_SIZE + NAME_SIZE;

   /**
      Constructs a ProductData object that is not associated
      with a file.
   */
   public ProductData()
   {
      file = null;
   }

   /**
      Opens the data file.
      @param filename the name of the file containing savings
      product information
   */
   public void open(String filename)
         throws IOException
   {
      if (file != null) file.close();
      file = new RandomAccessFile(filename, "rw");
   }

   /**
      Gets the number of products in the file.
      @return the number of products
   */
   public int size()
         throws IOException
   {
      return (int) (file.length() / RECORD_SIZE);
   }

   /**
      Closes the data file.
   */
   public void close()
         throws IOException
   {
      if (file != null) file.close();
      file = null;
   }

   /**
      Reads a product record.
      @param n the index of the product in the data file
      @return a product object initialized with the file data
   */
   public Product read(int n)
         throws IOException
   {  
      file.seek(n * RECORD_SIZE);      
      String name = readFixedString(NAME_LENGTH);
      double price = file.readDouble();
      int quantity = file.readInt();
      return new Product(name, price, quantity);
   }

   /**
      Finds the position of a product with a given name
      @param productName the product name to find
      @return the position of the product with the given name, 
      or -1 if there is no such product
   */
   public int find(String productName)
         throws IOException
   {
      for (int i = 0; i < size(); i++)
      {
         file.seek(i * RECORD_SIZE);
         String name = readFixedString(NAME_LENGTH);
         if (name.equalsIgnoreCase(productName)) // Found a match
            return i;
      } 
      return -1; // No match in the entire file
   }

   /**
      Writes a product record to the data file
      @param n the index of the product in the data file
      @param product the product to write
   */
   public void write(int n, Product product)
         throws IOException
   {  
      file.seek(n * RECORD_SIZE);
      writeFixedString(product.getName(), NAME_LENGTH);
      file.writeDouble(product.getPrice());
      file.writeInt(product.getQuantity());
   }

   /**
      Reads a fixed width string.
      @param size the number of characters to read
      @return the string with trailing spaces removed
   */
   public String readFixedString(int size) throws IOException
   {  
      String b = "";
      for (int i = 0; i < size; i++)
         b += file.readChar();
      return b.trim();
   }
   
   /**
      Writes a fixed width string.
      @param s the string to write
      @param size the number of characters to write
   */
   public void writeFixedString(String s, int size) throws IOException
   {  
      if (s.length() <= size)
      {  
         file.writeChars(s);
         for (int i = s.length(); i < size; i++)
            file.writeChar(' ');
      }
      else
         file.writeChars(s.substring(0, size));
   }
}
