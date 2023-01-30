import java.util.Arrays;

public class SequenceValuesTester
{
   public static void main(String[] args)
   {
      Sequence sequence = new SquareSequence();
      int[] array = sequence.values(10);
      System.out.println("Values: " + Arrays.toString(array));
      System.out.println("Expected: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]");
   }
}

