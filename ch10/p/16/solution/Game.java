/**
   Interface for two-player board games.
*/
public interface Game
{
   boolean isValidMove(String move);

   void executeMove(String move);

   boolean gameOver();

   void displayBoard();

   int determineWinner();
}
