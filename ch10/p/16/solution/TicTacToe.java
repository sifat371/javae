/**
   Tic-tac-toe game.
*/
public class TicTacToe
{
   public static void main(String[] args)
   {
      GamePlayer gamePlayer = new GamePlayer(new TicTacToeGame());
      gamePlayer.play();
   }
}
