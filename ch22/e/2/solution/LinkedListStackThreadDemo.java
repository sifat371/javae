import java.lang.Thread;
import java.util.Random;

/**
   This demo for demonstrating a thread safe stack using a linked list.
*/
public class LinkedListStackThreadDemo implements Runnable
{
   private static LinkedListStack list;
   private static Random randomizer;

   public void run()
   {
      int choice = 0;
      if (!list.empty())
      {
         choice = randomizer.nextInt(2);
      }
      if (choice == 0)
      {
         String token = randomizer.nextInt(1000) + "";
         list.push(token);
         System.out.println("Added: " + token);
      }
      else
      {
         String token = (String) list.pop();
         System.out.println("Removed: " + token);
      }
      if (!list.empty())
      {
         run();
      }
   }

   public static void main(String[] args)
   {
      randomizer = new Random();
      list = new LinkedListStack();
      Thread thread1 = new Thread(new LinkedListStackThreadDemo());
      thread1.start();
      Thread thread2 = new Thread(new LinkedListStackThreadDemo());
      thread2.start();
   }
}
