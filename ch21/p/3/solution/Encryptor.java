//ARGS -k TIGER encrypt.txt output.txt
//OUT output.txt
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

/**
   This class encrypts a file using a Vigenère cipher.
*/
public class Encryptor
{  
   public static void main(String[] args)
   {  
      boolean decrypt = false;
      String key = null;
      String inFile = null;
      String outFile = null;
      
      try
      {  
         int i = 0;
         while (i < args.length)
         {  
            if (args[i].equals("-d"))
               decrypt = true;
            else if (args[i].equals("-k"))
            {
               i++;
               if (i < args.length) key = args[i];
            }
            else if (inFile == null)
            {  
               inFile = args[i];
            }
            else if (outFile == null)
            {  
               outFile = args[i];
            }
            i++;
         }

         if (inFile == null || outFile == null || key == null)
            System.out.println("Usage: java Encryptor [-d] -k key inFile outFile");
         else
         {         
            InputStream inStream = new FileInputStream(inFile);
            OutputStream outStream = new FileOutputStream(outFile);
            VigenereCipher cipher = new VigenereCipher(key);
            cipher.processStream(inStream, outStream, decrypt);
            inStream.close();
            outStream.close();
         }
      }
      catch (IOException e)
      {  
         e.printStackTrace();
      }
   }
}
