public class SequenceProcessTester
{
   public static void main(String[] args)
   {
      Sequence sequence = new SquareSequence();
      sequence.process(1000);
      System.out.println("Expected: [100, 200, 0, 0, 200, 100, 200, 0, 0, 200]");
   }
}
