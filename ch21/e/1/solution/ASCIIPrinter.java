import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
   This program prints all ASCII characters in a file.

   When this program is used with a word processor file, the
   words become visible, but they are not necessarily in order. 
   There are also random-looking characters that occur when the
   binary formatting instructions happen to have bytes that are
   in the visible ASCII range.

   When printing an image file, there may be a few legible text
   items since some image files contain comments. Most of the output
   will consist of seemingly random character caused by bytes 
   in the binary image data that happen to be in the visible ASCII
   range.
*/
public class ASCIIPrinter
{  
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      System.out.println("Filename: ");
      String filename = in.next();
      
      try(InputStream inStream = new FileInputStream(filename))
      {         
         boolean done = false;
         int counter = 0;
         final int LINE_LENGTH = 64;
         while (!done)
         {  
            int next = inStream.read();
            if (next == -1) 
               done = true;
            else if (32 <= next && next <= 126)
            {
               System.out.print((char) next);
               counter++;
               if (counter == LINE_LENGTH)
               {
                  System.out.println();
                  counter = 0;
               }
            }
         }
         if (counter > 0)
            System.out.println();
         inStream.close();
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}