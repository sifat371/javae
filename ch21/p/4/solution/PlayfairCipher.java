import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

/**
   A class to encrypt and decrypt using the Playfair cipher.
*/
public class PlayfairCipher
{
   private String key;
   private char[][] keys;

   /**
      Construct a PlayfairCipher object.
      @param key the Playfair key to use
   */   
   public PlayfairCipher(String key)
   {
      keys = makeEncryptionKey(key);
   }

   /**
      Processes the stream.
      @param in the input stream
      @param out the output stream
      @param decrypt true for decryption
   */
   public void processStream(InputStream in, OutputStream out)
         throws IOException
   {    
      while (true)
      { 
         int ic1 = in.read();
         if (ic1 == -1) 
            return;
         int ic2 = in.read();
         if (ic2 == -1)
         { 
            out.write(ic1);
            return;
         }
         int[] encrypted = process(ic1, ic2);
         out.write(encrypted[0]);
         out.write(encrypted[1]);
      }            
   }

   private int[] process(int a, int b) 
         throws IOException
   {
      int[] r = new int[2];

      int r1 = -1;
      int r2 = -1;
      int c1 = -1;
      int c2 = -1;

      int au = Character.toUpperCase(a);
      int bu = Character.toUpperCase(b);

      if (au == 'J') 
         au = 'I';
      if (bu == 'J') 
         bu = 'I';

      for (int i = 0; i < keys.length; i++)
         for (int j = 0; j < keys[i].length; j++)
         {  
            if (keys[i][j] == au)
            { 
               r1 = i;
               c1 = j;
            }
            if (keys[i][j] == bu)
            { 
               r2 = i;
               c2 = j;
            }
         }

      if (r1 == -1 || r2 == -1)
      /* one of them wasn't a letter */
      {  
         r[0] = a;
         r[1] = b;
      }
      else
      { 
         r[0] = keys[r1][c2];
         r[1] = keys[r2][c1];
         if (Character.isLowerCase(a))
            r[0] = Character.toLowerCase(r[0]);
         if (Character.isLowerCase(b))
            r[1] = Character.toLowerCase(r[1]);
      }      
      return r;
   }
   
   /**
      Makes an encryption key
      @param k the encryption key
      @return the encryption tableau
   */
   public char[][] makeEncryptionKey(String k)
   { 
      final String LETTERS = "ABCDEFGHIKLMNOPQRSTUVWXYZ";  

      String in = k.toUpperCase() + LETTERS;
      char[][] out = new char[5][5];
      int i;
      int row = 0;
      int col = 0;

      for (i = 0; i < in.length(); i++)
      {  
         char s = in.charAt(i);
         if (s == 'J') 
            s = 'I';
         if (!found(out, s))
         {  
            out[row][col] = s;
            col++;
            if (col == out[row].length)
            { 
               row++;
               col = 0;
            }
         }
      }

      return out;
   } 
   
   /**
      Determines if character is found.
      @param square the square matrix
      @param s the character to find
      @return true if character is found, false otherwise
   */
   public boolean found(char[][] square, char s)
   {  
      for (int i = 0; i < square.length; i++)
         for (int j = 0; j < square[i].length; j++)
            if (square[i][j] != '\0' && square[i][j] == s)
               return true;
      return false;
   }   
}
