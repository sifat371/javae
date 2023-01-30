/**
   Populations of Cities in San Luis Obispo County
*/
public class MySequence implements Sequence
{
   private int n;

   private int populations[] = { 17252, 28310, 13156, 10234, 29793, 7655,
         45119, 1627, 930, 1262, 6032, 2592, 94, 193, 386, 2411, 641, 14276,
         1477, 16714, 337, 7286, 2336, 462, 1259, 1295, 7674, 285, 576 };

   /**
      Determine if the sequence has another value
      @return true if there is another value
   */
   public boolean hasNext()
   {
      return n < populations.length;
   }

   /**
      Get next value in sequence
      @return next value
   */
   public int next()
   {
      int value = populations[n];
      n++;
      return value;
   }
}
