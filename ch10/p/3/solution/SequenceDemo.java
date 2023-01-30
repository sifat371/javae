public class SequenceDemo
{
   public static void main(String[] args)
   {
      PrimeSequence primes = new PrimeSequence();

      for (int i = 0; i < 100; i++)
      {
         System.out.println(primes.next());
      }
   }
}
