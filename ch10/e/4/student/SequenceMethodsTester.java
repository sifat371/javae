public class SequenceMethodsTester
{
   public static void main(String[] args)
   {
      final int values = 10;
      
      Sequence multiples = Sequence.multiplesOf(3);
      System.out.print("Multiples: ");
      for (int i = 0; i < values; i++)
         System.out.print(multiples.next() + " ");
      System.out.println("\nExpected: 3 6 9 12 15 18 21 24 27 30 ");

      Sequence squares = Sequence.powersOf(2);
      System.out.print("Squares: ");
      for (int i = 0; i < values; i++)
         System.out.print(squares.next() + " ");
      System.out.println("\nExpected: 1 4 9 16 25 36 49 64 81 100 ");
      
      Sequence cubes = Sequence.powersOf(3);
      System.out.print("Cubes: ");
      for (int i = 0; i < values; i++)
         System.out.print(cubes.next() + " ");
      System.out.println("\nExpected: 1 8 27 64 125 256 343 512 729 1000 ");
   }
}
