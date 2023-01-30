import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

/**
   A monoalphabet cipher.
*/
public class MonoalphabetCipher 
{ 
   private int[] encrypt;
   private int[] decrypt;

   /**
      Constructs a MonoalphabetCipher object.
      @param key the encryption key
   */
   public MonoalphabetCipher(String key) 
   {
      final int NLETTERS = 'Z' - 'A' + 1;
      encrypt = new int[NLETTERS];
      decrypt = new int[NLETTERS];

      int j = 0;
      for (int i = 0; i < key.length(); i++)
      {
         char c = key.charAt(i);
         if ('a' <= c && c <= 'z') c += 'A' - 'a';
         if ('A' <= c && c <= 'Z' && !contains(encrypt, j, c))
         {
            encrypt[j] = c;
            decrypt[c - 'A'] = j + 'A';
            j++;
         }         
      }
      for (char c = 'Z'; c >= 'A'; c--)
      {
         if (!contains(encrypt, j, c))
         {
            encrypt[j] = c;
            decrypt[c - 'A'] = j + 'A';
            j++;
         }
      }
   }

   private static boolean contains(int[] values, int length, int value)
   {
      for (int i = 0; i < length; i++)
         if (values[i] == value) return true;
      return false;
   }

   /**
      Processes the contents of a stream.
      @param in the input stream
      @param out the output stream
      @param encoding whether to encrypt or decrypt
   */
   public void processStream(InputStream in, OutputStream out, int[] encoding) 
         throws IOException
   {
      boolean done = false;
      while (!done)
      {
         int next = in.read();
         if (next == -1)
            done = true;
         else
         {              
            byte b = (byte) next;
            byte c = (byte) process(b, encoding);
            out.write(c);
         }
      }
   }
   
   /**
      Process a byte.
      @param b the byte to encrypt/decrypt
      @param encoding the encoding of the lowercase letters
      @return the encrypted/decrypted Byte
   */
   public int process(int b, int[] encoding) 
   {
      if ('A' <= b && b <= 'Z')
         return encoding[b - 'A'];
      else if ('a' <= b && b <= 'z')
         return encoding[b - 'a'] + 'a' - 'A';
      else
         return b;
   }
      
   /**
      Encrypt the contents of a stream.
      @param in the input stream
      @param out the output stream
   */
   public void encryptStream(InputStream in, OutputStream out)
            throws IOException
   {
      processStream(in, out, encrypt);
   }
   
   /**
      Decrypt the contents of a file.
      @param in the input stream
      @param out the output stream
   */
   public void decryptStream(InputStream in, OutputStream out)
            throws IOException
   {
      processStream(in, out, decrypt);
   }
} 
