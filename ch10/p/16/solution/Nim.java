/**
   Nim game.
*/
public class Nim
{
   public static void main(String[] args)
   {
      GamePlayer gamePlayer = new GamePlayer(new NimGame());
      gamePlayer.play();
   }
}
