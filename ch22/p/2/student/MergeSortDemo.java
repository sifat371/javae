import java.util.Arrays;

/**
   This program demonstrates the merge sort algorithm by
   sorting an array that is filled with random numbers. 
   A new thread is started for each subarray.
*/
public class MergeSortDemo
{  
   public static void main(String[] args)
   {  
      int[] a = ArrayUtil.randomIntArray(2000, 10000);
      System.out.println(Arrays.toString(a));

      MergeSorter sorter = new MergeSorter(a);
      Thread t = new Thread(sorter);
      try
      {
         t.start();
         t.join();
      }
      catch (InterruptedException ex)
      {
      }
      System.out.println(Arrays.toString(a));
   }
}
