import java.util.Arrays;

public interface Sequence
{
   int next();
   
   /**
      Counts and displays the distribution of the last digits of values in the sequence
      @param valuesToProcess the number of values to process
   */
   default void process(int valuesToProcess)
   {
      int[] counters = new int[10];
      for (int i = 1; i <= valuesToProcess; i++)
      {
         int value = next();
         int lastDigit = value % 10;
         counters[lastDigit]++;
      }
      System.out.println(Arrays.toString(counters));
   }
}
