import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

/**
   This class implements the FIFO queue data structure.
 */
public class Queue
{
   private ArrayList<String> queue;
   private int size = 0;
   private static final int DEAFULT_SIZE = 10;
   private Lock queueLock;
   private Condition queueChangeCondition;

   /** 
      Constructs the maximum size of the queue to default size.
   */
   public Queue()
   {
      //complete this method
   }

   /**
      Constructs the maximum size of the queue to the given size.
      @param aSize the maximum size of the queue
   */
   public Queue(int aSize)
   {
      //complete this method
   }

   /**
      Adds a string into the queue.
      @param item the item to add
   */
   public void add(String item) throws InterruptedException
   {
      //complete this method
   }

   /**
      Removes one item from the queue.
      @return the first item of the queue
   */
   public String remove() throws InterruptedException
   {
      //complete this method
   }

   /**
      Check if the queue is empty.
      @return true if the queue is empty, else false
   */
   public boolean isEmpty()
   {
      return queue.isEmpty();
   }

   /** 
      Check if the queue is full.
      @return true if queue size equals to maximum size, else false
   */
   public boolean isFull()
   {
      return queue.size() == size;
   }
}
