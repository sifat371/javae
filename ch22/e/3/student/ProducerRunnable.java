import  java.util.Date;

/**
   This class will keep putting things into the queue.
*/
public class ProducerRunnable implements Runnable
{
   private Queue queue = null;
   private int count;

   /**
      Constructs the producer with a queue and count.
      @param aQueue the queue that the consumer going to consume from
      @param aCount the number of time that consumer going to consume
   */
   public ProducerRunnable(Queue aQueue, int aCount)
   {
      count = aCount;
      queue = aQueue;
   }

   public void run()
   {
      . . .
      for (. . .)
      {
         String item = new Date().toString();
         System.out.println("Adding: " + item);
         queue.add(item);
         . . .
      }
      . . .
   }
}
