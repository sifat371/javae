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
   private Condition nonFullCondition;
   private Condition nonEmptyCondition;

   /** 
      Constructs the maximum size of the queue to deafult size.
   */
   public Queue()
   {
      size = DEAFULT_SIZE;
      queue = new ArrayList<>(size);
      queueLock = new ReentrantLock();
      nonFullCondition = queueLock.newCondition();
      nonEmptyCondition = queueLock.newCondition();
   }

   /**
      Constructs the maximum size of the queue to the given size.
      @param aSize the maximum size of the queue
   */
   public Queue(int aSize)
   {
      size = aSize;
      queue = new ArrayList<>(size);
      queueLock = new ReentrantLock();
      nonFullCondition = queueLock.newCondition();
      nonEmptyCondition = queueLock.newCondition();
   }

   /**
      Adds a string into the queue.
      @param item the item to add
   */
   public void add(String item) throws InterruptedException
   {
      queueLock.lock();
      try
      {
         while (isFull())
            nonFullCondition.await();
         queue.add(item);
         nonEmptyCondition.signalAll(); // notify all others that the queue is not empty
      }
      finally
      {
         queueLock.unlock();
      }
   }

   /**
      Removes one item from the queue.
      @return the first item of the queue
   */
   public String remove() throws InterruptedException
   {
      String element = null;
      queueLock.lock();
      try
      {
          while (isEmpty())
             nonEmptyCondition.await();
          element = queue.remove(0);
          nonFullCondition.signalAll(); // notify all others that the queue is not full
      }
      finally
      {
         queueLock.unlock();
      }
      return element;
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
