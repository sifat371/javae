/**
   This class will keep removing things from the queue
*/
public class ConsumerRunnable implements Runnable
{
   private Queue queue = null;
   private int count;
   private static final int DELAY = 100;

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
      try
      {
         for (int i = 0; i < count && !Thread.interrupted(); i++)
         {
            System.out.println("Removing: " + queue.remove());
            Thread.sleep(DELAY);
         }
      }
      catch (InterruptedException exception)
      {
      }
   }
}
