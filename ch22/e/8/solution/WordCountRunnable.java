import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;

/**
   Counts how many words in a file.
*/
public class WordCountRunnable implements Runnable
{
   public static int threadCount;
   public static Lock threadCountLock;
   public static int combinedWordCount;
   public static Lock combinedWordCountLock;

   private String filename;

   /**
      Constructs a WordCountRunnable object with a file name.
      @param aFilename the file name that needs to count word
   */
   public WordCountRunnable(String aFilename)
   {
      filename = aFilename;
   }

   public void run()
   {
      threadCountLock.lock();
      threadCount++;
      threadCountLock.unlock();
      int count = 0;
      try
      {
         Scanner in = new Scanner(new FileInputStream(filename));

         while (in.hasNext())
         {
            in.next();
            count++;
         }
      } catch (FileNotFoundException e)
      {
         System.out.println(filename + " not found!");
      } catch (IOException e)
      {
         System.out.println(e);
      }
      System.out.println(filename + ": " + count);
      combinedWordCountLock.lock();
      combinedWordCount += count;
      threadCountLock.lock();
      threadCount--;
      if (threadCount < 1)
         System.out.println("Combined Total: " + combinedWordCount);
      threadCountLock.unlock();
      combinedWordCountLock.unlock();
   }
}
