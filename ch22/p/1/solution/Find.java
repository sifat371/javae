//ARGS lamb mary1.txt mary2.txt
/**
   Finds a target string from a file.  Then, the program will print out the
   line contains the target string.
*/
public class Find
{
   public static void main(String[] args[])
   {
      for (int i = 1; i < args.length; i++)
      {
         FindRunnable finder = new FindRunnable(args[0], args[i]);
         Thread t = new Thread(finder);
         t.start();
      }
   }
}
