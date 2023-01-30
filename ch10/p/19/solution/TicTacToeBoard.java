/**
   Represents a board of marks.
*/
public class TicTacToeBoard
{
   private static final int BLANK = 0;
   public static final int X_MARK = 1;
   public static final int O_MARK = 2;

   private int board[][];

   /**
      Create empty board.
   */
   public TicTacToeBoard()
   {
      board = new int[3][3];
      for (int row = 0; row < board.length; row++)
      {
         for (int col = 0; col < board[row].length; col++)
         {
            board[row][col] = BLANK;
         }
      }
   }

   /**
      Check if a square is available.
      @param row row of square
      @param col col of square
      @return availability of square
   */
   public boolean availableSquare(int row, int col)
   {
      return row >= 0 && row < 3 && col >= 0 && col < 3
            && board[row][col] == BLANK;
   }

   /**
      Determine the winner if there is one.
      @return BLANK if no winner, X_MARK or O_MARK otherwise
   */
   public int determineWinner()
   {
      for (int row = 0; row < 3; row++)
      {
         if (board[row][0] != BLANK && board[row][0] == board[row][1]
               && board[row][1] == board[row][2])
         {
            return board[row][0];
         }
      }

      for (int col = 0; col < 3; col++)
      {
         if (board[0][col] != BLANK && board[0][col] == board[1][col]
               && board[1][col] == board[2][col])
         {
            return board[0][col];
         }
      }

      if (board[0][0] != BLANK && board[0][0] == board[1][1]
            && board[1][1] == board[2][2])
      {
         return board[0][0];
      }

      if (board[0][2] != BLANK && board[0][2] == board[1][1]
            && board[1][1] == board[2][0])
      {
         return board[0][2];
      }

      return BLANK;
   }

   /**
      Retrieve mark.
      @param row row of mark
      @param col column of mark
      @return mark at board location
   */
   public int getMark(int row, int col)
   {
      if (row >= 0 && row < board.length && col >= 0 && col < board[row].length)
      {
         return board[row][col];
      }
      else
      {
         return BLANK;
      }
   }

   /**
      Set mark.
      @param row row of mark
      @param col column of mark
      @param mark mark to place on board
   */
   public void setMark(int row, int col, int mark)
   {
      if (row >= 0 && row < board.length && col >= 0 && col < board[row].length
            && validMark(mark))
      {
         board[row][col] = mark;
      }
   }

   /**
      Clear the board.
   */
   public void reset()
   {
      for (int row = 0; row < 3; row++)
      {
         for (int col = 0; col < 3; col++)
         {
            board[row][col] = BLANK;
         }
      }
   }

   private boolean validMark(int mark)
   {
      return mark == BLANK || mark == X_MARK || mark == O_MARK;
   }
}
