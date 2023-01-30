import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
   Finds a target string from a file.  Then, the program will print out the
   line contains the target string.
*/
public class FindRunnable implements Runnable
{
   private String target;
   private String filename;

   /**
       Constructs a FindRunnable object with a target string and file name.
       @param aTarget the target string that needs to be search
       @param aFilename the file name that needs to count word
   */
   public FindRunnable(String aTarget, String aFilename)
   {
      target = aTarget;
      filename = aFilename;
   }

   public void run()
   {
      try(Scanner in = new Scanner(new FileInputStream(filename)))
      {         
         while (in.hasNextLine())
         {  
            String line = in.nextLine();
            if ((line.indexOf(target)) != -1)
            {
               System.out.println(filename + ": " + line);
               Thread.sleep(1);
            }
         }
      } 
      catch (FileNotFoundException e)
      {
         System.out.println(filename + " not found!");
      }
      catch (IOException e)
      {
         System.out.println(e);
      }
      catch (InterruptedException e)
      {
      }
   }
}
