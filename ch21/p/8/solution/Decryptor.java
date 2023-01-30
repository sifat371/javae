import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
   This class helps to decrypt a file that has been encrypted using a monoalphabet cipher.
*/
//ARGS dictionary.txt
public class Decryptor
{
   public static void main(String[] args)
   {
      String inFile = null;

      int i = 0;
      while (i < args.length)
      {
         if (inFile == null)
         {
            inFile = args[i];
         }
         i++;
      }

      if (inFile == null)
      {
         System.out.println("Usage: java Decryptor inFile");
         return;
      }

      try(Reader reader = new FileReader(inFile))
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
      } catch (IOException e)
      {
         e.printStackTrace();
      }

      try(InputStream inStream = new FileInputStream(inFile))
      {         
         // brute force the decryption with the caesar cipher
         // and output the number of words from the dictionary file found for each key
         for (int key = 0; key < 256; key++)
         {
            CaesarCipher cipher = new CaesarCipher(key);
            cipher.decryptStream(inStream);
         }

         inStream.close();
      } catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}
