import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;

/**
   This component implements a tic-tac-toe board with marks
*/
public class TicTacToeComponent extends JComponent
{
   private TicTacToeBoard board;
   private int squareDim;
   private int leftPad;
   private int topPad;

   private static final int MARK_PAD = 10;

   /**
      Create a new tic-tac-toe component with specified square dimension.
      @param squareDim dimension of board squares
      @param leftPad padding to left of board
      @param topPad padding above board
   */
   public TicTacToeComponent(TicTacToeBoard board, int squareDim, int leftPad,
         int topPad)
   {
      this.squareDim = squareDim;
      this.leftPad = leftPad;
      this.topPad = topPad;
      this.board = board;
   }

   /**
      Paint the component
      @param g graphics device
   */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      int xLeft = leftPad + squareDim + 1;
      int xRight = xLeft + squareDim + 1;
      int yTop = topPad + squareDim + 1;
      int yBot = yTop + squareDim + 1;
      int height = 3 * squareDim + 2;
      int width = 3 * squareDim + 2;

      Line2D.Double vertLeft = new Line2D.Double(xLeft, topPad, xLeft, topPad
            + height);
      Line2D.Double vertRight = new Line2D.Double(xRight, topPad, xRight,
            topPad + height);
      Line2D.Double horizTop = new Line2D.Double(leftPad, yTop,
            leftPad + width, yTop);
      Line2D.Double horizBot = new Line2D.Double(leftPad, yBot,
            leftPad + width, yBot);

      g2.draw(vertLeft);
      g2.draw(vertRight);
      g2.draw(horizTop);
      g2.draw(horizBot);

      for (int row = 0, y = topPad; row < 3; row++)
      {
         int x = leftPad;
         for (int col = 0; col < 3; col++)
         {
            drawMark(g2, x, y, board.getMark(row, col));
            x += squareDim + 1;
         }
         y += squareDim + 1;
      }
   }

   private void drawMark(Graphics2D g, int x, int y, int mark)
   {
      if (mark == TicTacToeBoard.X_MARK)
      {
         Line2D.Double line1 = new Line2D.Double(x + MARK_PAD, y + MARK_PAD, x
               + squareDim - MARK_PAD, y + squareDim - MARK_PAD);
         Line2D.Double line2 = new Line2D.Double(x + squareDim - MARK_PAD, y
               + MARK_PAD, x + MARK_PAD, y + squareDim - MARK_PAD);

         g.draw(line1);
         g.draw(line2);
      }
      else if (mark == TicTacToeBoard.O_MARK)
      {
         Ellipse2D.Double circle = new Ellipse2D.Double(x + MARK_PAD, y
               + MARK_PAD, squareDim - 2 * MARK_PAD, squareDim - 2 * MARK_PAD);

         g.draw(circle);
      }
   }
}
