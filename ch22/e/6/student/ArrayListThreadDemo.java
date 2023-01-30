import java.util.Random;

/**
   This demo for demonstrating a thread safe array list.
*/
public class ArrayListThreadDemo implements Runnable
{
   private static ArrayList list;
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
         list.addLast(token);
         System.out.println("Added: " + token);
      }
      else
      {
         String token = (String) list.remove(choice);
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
      list = new ArrayList();
      Thread thread1 = new Thread(new ArrayListThreadDemo());
      thread1.start();
      Thread thread2 = new Thread(new ArrayListThreadDemo());
      thread2.start();
   }
}
