import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

/**
   A class to encrypt and decrypt with the Vigenère cipher.
*/
public class VigenereCipher
{
   private String key;

   /**
      Construct a VigenereCipher object.
      @param aKey the key to encrypt from
   */
   public VigenereCipher(String aKey)
   {
      key = aKey.toUpperCase();
   }
   
   
   /**
      Processes the stream.
      @param in the input stream
      @param out the output stream
      @param decrypt true for decryption
   */
   public void processStream(InputStream in, OutputStream out,
      boolean decrypt) 
         throws IOException
   {
      int n = 0;
      boolean done = false;
      while (!done)
      {
         int next = in.read();
         if (next == -1)
            done = true;
         else
         {              
            int k = key.charAt(n) - 'A';
            n = (n + 1) % key.length();
            
            if (decrypt)
               k = -k;
            byte c = (byte) process(next, k);
            out.write(c);
         }
      }
   }
   
   /**
      Processes a single byte for encryption or decryption.
      @param b the byte to encrypt/decrypt
      @param k the amount by which to shift
      @return the encrypted/decrypted byte
   */
   public int process(int b, int k) 
   {
      int n = 'Z' - 'A' + 1;
      if ('A' <= b && b <= 'Z')
      {
         
         int r = b - 'A' + k + n;
         return r % n + 'A';
      }
      else if ('a' <= b && b <= 'z')
      {
         
         int r = b - 'a' + k + n;
         return r % n + 'a';
      }
      else 
         return b;
   }
}
