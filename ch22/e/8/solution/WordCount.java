import java.util.concurrent.locks.ReentrantLock;

/**
   Counts how many words in a file.
*/
public class WordCount extends Thread
{
   public static void main(String argv[])
   {
      WordCountRunnable.threadCount = 0;
      WordCountRunnable.threadCountLock = new ReentrantLock();
      WordCountRunnable.combinedWordCount = 0;
      WordCountRunnable.combinedWordCountLock = new ReentrantLock();
      for (int i = 0; i < argv.length; i++)
      {
         WordCountRunnable wcr = new WordCountRunnable(argv[i]);
         Thread t = new Thread(wcr);
         t.start();
      }
   }
}
