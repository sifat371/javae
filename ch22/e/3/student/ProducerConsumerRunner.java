public class ProducerConsumerRunner
{
   private static int QUEUE_MAX_SIZE = 10;
   private static int ITERATIONS = 100;

   public static void main(String args[])
   {
      Queue q = new Queue(QUEUE_MAX_SIZE);
      ProducerRunnable producer = new ProducerRunnable(q, ITERATIONS);
      ConsumerRunnable consumer = new ConsumerRunnable(q, ITERATIONS);
      Thread t1 = new Thread(producer);
      Thread t2 = new Thread(consumer);
      t1.start();
      t2.start();
   }
}
