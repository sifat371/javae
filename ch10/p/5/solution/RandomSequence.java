import java.util.Random;

public class RandomSequence implements Sequence
{
   public int next()
   {
      Random generator = new Random();
      return generator.nextInt(Integer.MAX_VALUE);
   }
}
