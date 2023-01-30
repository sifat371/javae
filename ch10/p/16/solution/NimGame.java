/**
   Implementation of Nim game.
*/
public class NimGame implements Game
{
   private int winner;
   private int heaps[];

   /**
      Create a new Nim game.
   */
   public NimGame()
   {
      winner = 0;
      heaps = new int[3];
      heaps[0] = 3;
      heaps[1] = 4;
      heaps[2] = 5;
   }

   /**
      Check if a move is valid.
      @param move move in String form
      @return validity of move
   */
   public boolean isValidMove(String move)
   {
      int heap = moveHeap(move);
      int take = moveTake(move);
      int player = movePlayer(move);

      return heap >= 0 && heap < 3 && take > 0 && take <= heaps[heap]
            && (player == 1 || player == 2);
   }

   /**
      Execute the specified move.
      @param move String representation of move
   */
   public void executeMove(String move)
   {
      int heap = moveHeap(move);
      int take = moveTake(move);
      int player = movePlayer(move);

      if (isValidMove(move))
      {
         heaps[heap] = heaps[heap] - take;
         if (gameOver())
         {
            winner = player;
         }
      }
   }

   /**
      Determine if game has been won.
      @return true if game is over
   */
   public boolean gameOver()
   {
      boolean gameOver = true;
      for (int i = 0; i < heaps.length; i++)
      {
         gameOver = gameOver && heaps[i] == 0;
      }

      return gameOver;
   }

   /**
      Display board game state.
   */
   public void displayBoard()
   {
      System.out.println("Heaps");
      System.out.println("A B C");
      System.out.println(heaps[0] + " " + heaps[1] + " " + heaps[2]);
   }

   /**
      Determine the winner if there is one.
      @return 0 if no winner, player number (1 or 2) otherwise
   */
   public int determineWinner()
   {
      return winner;
   }

   private int moveHeap(String move)
   {
      if (move.length() < 1)
      {
         return -1;
      }
      return move.charAt(0) - '0';
   }

   private int moveTake(String move)
   {
      if (move.length() < 2)
      {
         return -1;
      }
      return move.charAt(1) - '0';
   }

   private int movePlayer(String move)
   {
      if (move.length() < 3)
      {
         return -1;
      }
      return move.charAt(2) - '0';
   }
}
