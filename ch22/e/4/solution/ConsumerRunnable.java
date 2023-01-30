/**
   This class will keep removing things from the queue
*/
public class ConsumerRunnable implements Runnable
{
   private int id;
   private Queue queue = null;
   private int count;
   private static final int DELAY = 1000;

   /**
      Constructs the consumer with a queue and count.
      @param anId the ID of this producer
      @param aQueue the queue that the consumer going to consume from
      @param aCount the number of time that consumer going to consume
   */
   public ConsumerRunnable(int anId, Queue aQueue, int aCount)
   {
      id = anId;
      count = aCount;
      queue = aQueue;
   }

   public void run()
   {
      try
      {
         for (int i = 0; i < count &&  !Thread.interrupted(); i++)
         {
            System.out.println("Consumer " + id + ": Removing " + queue.remove());
            Thread.sleep(DELAY);
         }
      }
      catch (InterruptedException exception)
      {
      }
   }
}
