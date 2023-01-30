/**
   Implementation of tic-tac-toe game.
*/
public class TicTacToeGame implements Game
{
   private char board[][];

   private static final char BLANK = ' ';

   /**
      Create empty board.
   */
   public TicTacToeGame()
   {
      board = new char[3][3];
      for (int row = 0; row < board.length; row++)
      {
         for (int col = 0; col < board[row].length; col++)
         {
            board[row][col] = BLANK;
         }
      }
   }

   /**
      Check if a move is valid.
      @param move move in String form
      @return validity of move
   */
   public boolean isValidMove(String move)
   {
      int row = moveRow(move);
      int col = moveColumn(move);
      char mark = moveMark(move);

      return row >= 0 && row < board.length && col >= 0
            && col < board[row].length && board[row][col] == BLANK
            && isValidMark(mark);
   }

   /**
      Execute the specified move.
      @param move String representation of move
   */
   public void executeMove(String move)
   {
      int row = moveRow(move);
      int col = moveColumn(move);
      char mark = moveMark(move);

      if (isValidMove(move))
      {
         board[row][col] = mark;
      }
   }

   /**
      Determine if game has been won.
      @return true if game is over
   */
   public boolean gameOver()
   {
      return noMoves() || determineWinner() != 0;
   }

   /**
      Determine the winner if there is one.
      @return 0 if no winner, player number (1 or 2) otherwise
   */
   public int determineWinner()
   {
      for (int row = 0; row < 3; row++)
      {
         if (board[row][0] != BLANK && board[row][0] == board[row][1]
               && board[row][1] == board[row][2])
         {
            return playerNumber(board[row][0]);
         }
      }

      for (int col = 0; col < 3; col++)
      {
         if (board[0][col] != BLANK && board[0][col] == board[1][col]
               && board[1][col] == board[2][col])
         {
            return playerNumber(board[0][col]);
         }
      }

      if (board[0][0] != BLANK && board[0][0] == board[1][1]
            && board[1][1] == board[2][2])
      {
         return playerNumber(board[0][0]);
      }

      if (board[0][2] != BLANK && board[0][2] == board[1][1]
            && board[1][1] == board[2][0])
      {
         return playerNumber(board[0][2]);
      }

      return 0;
   }

   /**
      Display board game state.
   */
   public void displayBoard()
   {
      displayRow(0);
      System.out.println("-----------");
      displayRow(1);
      System.out.println("-----------");
      displayRow(2);
   }

   private int moveRow(String move)
   {
      if (move.length() < 1)
      {
         return -1;
      }
      return move.charAt(0) - '0';
   }

   private int moveColumn(String move)
   {
      if (move.length() < 2)
      {
         return -1;
      }
      return move.charAt(1) - '0';
   }

   private char moveMark(String move)
   {
      if (move.length() < 3)
      {
         return ' ';
      }
      return move.charAt(2);
   }

   private void displayRow(int row)
   {
      System.out.print(" " + board[row][0] + " ");
      System.out.print("| " + board[row][1] + " ");
      System.out.print("| " + board[row][2] + " ");
      System.out.println();
   }

   private boolean isValidMark(int mark)
   {
      return mark == 'x' || mark == 'o';
   }

   private int playerNumber(char mark)
   {
      if (mark == 'x')
      {
         return 1;
      }
      else if (mark == 'o')
      {
         return 2;
      }
      else
      {
         return 0;
      }
   }

   private boolean noMoves()
   {
      boolean availableMove = false;

      for (int row = 0; row < board.length; row++)
      {
         for (int col = 0; col < board[row].length; col++)
         {
            availableMove = availableMove || board[row][col] == BLANK;
         }
      }

      return !availableMove;
   }
}
