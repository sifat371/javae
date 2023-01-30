import  java.util.Date;

/**
   This class will keep putting things into the queue.
*/
public class ProducerRunnable implements Runnable
{
   private int id;
   private Queue queue = null;
   private int count;
   private static final int DELAY = 1000;

   /**
      Constructs the producer with a queue and count.
      @param anId the ID of this producer
      @param aQueue the queue that the consumer going to consume from
      @param aCount the number of time that consumer going to consume
   */
   public ProducerRunnable(int anId, Queue aQueue, int aCount)
   {
      id = anId;
      count = aCount;
      queue = aQueue;
   }

   public void run()
   {
      try
      {
         for (int i = 0; i < count && !Thread.interrupted(); i++)
         {
            String item = new Date().toString();
            System.out.println("Producer " + id + ": Adding " + item);
            queue.add(item);
            Thread.sleep(DELAY);
         }
      }
      catch (InterruptedException exception)
      {
      }
   }
}
