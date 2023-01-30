public class PrimeSequence implements Sequence
{
   private int n = 2;

   /**
      Produce the next value in the sequence of primes using
      a naive algorithm.
   */
   public int next()
   {
      boolean prime = false;
      do
      {
         int i;

         // check each number less than n for divisibility of n
         for (i = 2; i < n && n % i != 0; i++)
            ;

         // if none of the numbers divided n, then prime
         if (i == n)
         {
            prime = true;
         }
         n++;
      } while (!prime);

      return n - 1;
   }
}
