import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class BankDataCompactor
{
   public static final int INT_SIZE = 4;  
   public static final int DOUBLE_SIZE = 8;  
   public static final int RECORD_SIZE 
         = INT_SIZE + DOUBLE_SIZE;

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Filename:");
      String filename = in.nextLine();
      try(RandomAccessFile file = new RandomAccessFile(filename, "rw"))
      {         
         // find first hole
         boolean found = false;
         long holePosition = 0;
         int holes = 0;
         while (!found && file.getFilePointer() < file.length())
         {
            int accountNumber = file.readInt();
            if (accountNumber == 0) 
            {
               found = true;
               holePosition = file.getFilePointer() - INT_SIZE;
               holes++;
            }
            file.readDouble(); // skip remainder of record
         }
         if (!found)
         {
            file.close();         
            System.out.println("No inactive records removed");
            return;
         }

         long savedPosition = 0;
         // move all active records
         while (file.getFilePointer() < file.length())
         {
            int accountNumber = file.readInt();
            double balance = file.readDouble();
            if (accountNumber > 0) 
            {
               savedPosition = file.getFilePointer();
               file.seek(holePosition);
               file.writeInt(accountNumber);
               file.writeDouble(balance);
               System.out.println("Moved account " + accountNumber + " to position " + holePosition);
               holePosition = file.getFilePointer();
               file.seek(savedPosition);
            }
            else
               holes++;
         }         
         file.setLength(holePosition);
         System.out.println("Truncated file length to " + holePosition);
         file.close();         
         System.out.println(holes + " inactive records removed");
      }
      catch (IOException ex)
      {
         ex.printStackTrace();
      }
   }
}
