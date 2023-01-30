import javax.swing.JFrame;

public class TicTacToe
{
   public static void main(String[] args)
   {
      JFrame frame = new TicTacToeFrame();

      frame.setTitle("Tic-Tac-Toe");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
