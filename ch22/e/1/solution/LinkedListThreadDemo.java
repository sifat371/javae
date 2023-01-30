import java.util.LinkedList;
import java.util.Random;

/**
   This demo for demonstrating how threads can corrupt a linked list.
*/
public class LinkedListThreadDemo implements Runnable
{
   private static LinkedList<String> list;
   private static Random randomizer;

   public void run()
   {
      int choice = list.size();
      if (list.size() > 0)
      {
         choice = randomizer.nextInt(list.size() + 1);
      }
      if (choice == list.size())
      {
         String token = randomizer.nextInt(1000) + "";
         list.add(token);
         System.out.println("Added: " + token);
      }
      else
      {
         String token = list.remove(choice);
         System.out.println("Removed: " + token);
      }
      if (list.size() > 0)
      {
         run();
      }
   }

   public static void main(String[] args)
   {
      randomizer = new Random();
      list = new LinkedList<>();
      Thread thread1 = new Thread(new LinkedListThreadDemo());
      thread1.start();
      Thread thread2 = new Thread(new LinkedListThreadDemo());
      thread2.start();
   }
}
