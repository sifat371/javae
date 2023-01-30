import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
   This class decrypts files using the Caesar cipher and reports the number of words found.
*/
public class CaesarCipher
{
   private int key;

   /**
      Constructs a cipher object with a given key.
      @param aKey the encryption key
   */
   public CaesarCipher(int aKey)
   {
      key = aKey;
   }

   /**
      Decrypts the contents of a stream and reports how many words are found.
      @param in the dictionary input stream
   */
   public void decryptStream(InputStream in) throws IOException
   {
      // decrypt the stream into a string
      String output = "";
      boolean done = false;
      while (!done)
      {
         int next = in.read();
         if (next == -1)
         {
            done = true;
         }
         else
         {
            int decrypted = decrypt(next);
            output += (char) decrypted;
         }
      }

      int wordsFound = 0;
      try(// open dictionary stream
         FileInputStream dictionary = new FileInputStream("dictionary.txt");
         DataInputStream dictionaryIn = new DataInputStream(dictionary);
         BufferedReader br = new BufferedReader(new InputStreamReader(dictionaryIn));
		 )
	  {
         String strLine;

         // report number of words found compared to the dictionary file
         while ((strLine = br.readLine()) != null)
         {
            if (output.contains(strLine))
            {
               wordsFound++;
            }
         }

         in.close();
      } catch (Exception e)
      {
         System.err.println("Error: " + e.getMessage());
      }

      System.out.println("Decrypted with key : " + key + ", found "
            + wordsFound + " words.");
   }

   /**
      Decrypts a value.
      @param b the value to decrypt (between 0 and 255)
      @return the decrypted value
   */
   public int decrypt(int b)
   {
      return (b - key) % 256;
   }
}
