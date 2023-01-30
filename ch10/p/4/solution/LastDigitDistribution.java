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
   */
   public void process(Sequence seq)
   {
      while (seq.hasNext())
      {
         int value = seq.next();
         int lastDigit = value % 10;
         counters[lastDigit]++;
      }
   }

   /**
      Display the distribution
   */
   public void display()
   {
      for (int i = 0; i < 10; i++)
      {
         System.out.println(i + ": " + counters[i]);
      }
   }
}
