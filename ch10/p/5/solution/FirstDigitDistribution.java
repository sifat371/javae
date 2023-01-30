public class FirstDigitDistribution
{
   private int[] counters;

   /**
      Construct a first digit distribution object
   */
   public FirstDigitDistribution()
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
         if (value < 0)
         {
            value = -value;
         }
         while (value >= 10)
         {
            value = value / 10;
         }
         int firstDigit = value;
         counters[firstDigit]++;
      }
   }

   /**
      Display the distribution as a histogram
   */
   public void display()
   {
      for (int i = 0; i < 10; i++)
      {
         System.out.println(i + ": " + counters[i]);
      }
   }
}
