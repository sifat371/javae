/**
   This class will keep removing things from the queue
*/
public class ConsumerRunnable implements Runnable
{
   private Queue queue = null;
   private int count;

   /**
      Constructs the consumer with a queue and count.
      @param aQueue the queue that the consumer going to consume from
      @param aCount the number of time that consumer going to consume
   */
   public ConsumerRunnable(Queue aQueue, int aCount)
   {
      count = aCount;
      queue = aQueue;
   }

   public void run()
   {
      . . .
      for (. . .)
      {
         . . .
         System.out.println("Removing: " + item);
         . . .
      }
      . . .
   }
}
