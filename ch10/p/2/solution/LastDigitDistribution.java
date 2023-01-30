public class LastDigitDistribution
{
   private int[] counters;

   /**
      Construct a last digit distribution object
   */
   public LastDigitDistribution()
   {
      counters = new int[10];
   }

   /**
      Process a sequence
      @param seq the sequence to process
      @param valuesToProcess the number of values to process
   */
   public void process(Sequence seq, int valuesToProcess)
   {
      for (int i = 1; i <= valuesToProcess; i++)
      {
         int value = seq.next();
         int lastDigit = value % 10;
         counters[lastDigit]++;
      }
   }

   /**
      Display the distribution as a histogram
   */
   public void display()
   {
      int max = maxCounter();
      double scale = 40.0 / max;

      for (int i = 0; i < 10; i++)
      {
         System.out.print(i + ": ");
         int numStars = (int) (counters[i] * scale);
         for (int j = 0; j < numStars; j++)
         {
            System.out.print("*");
         }
         System.out.println();
      }
   }

   /**
      Determine the maximum counter
   */
   private int maxCounter()
   {
      int max = counters[0];

      for (int i = 1; i < 10; i++)
      {
         if (counters[i] > max)
         {
            max = counters[i];
         }
      }

      return max;
   }
}
