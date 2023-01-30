//TIMEOUT 100000
//SAMPLE
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
   This class runs producer and consumer threads.
*/
public class ProducerConsumerRunner
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      System.out.print("Please enter the number of producers: ");
      int numberOfProducers = in.nextInt();
      System.out.print("Please enter the number of consumers: ");
      int numberOfConsumers = in.nextInt();
      System.out.print("Please enter the queue capacity: ");
      int queueCapacity = in.nextInt();
      System.out.print("Please enter the number of iterations: ");
      int iterations = in.nextInt();

      ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(queueCapacity);
      for (int i = 1; i <= numberOfProducers; i++)
      {
         ProducerRunnable producer = new ProducerRunnable(i, q, iterations);
         Thread t = new Thread(producer);
         t.start();
      }

      for (int i = 1; i <= numberOfConsumers; i++)
      {
         ConsumerRunnable consumer = new ConsumerRunnable(i, q, iterations);
         Thread t = new Thread(consumer);
         t.start();
      }
   }
}
