import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
   Tic-tac-toe game.
 */
public class TicTacToeFrame extends JFrame
{
   private TicTacToeComponent component;
   private int player;
   private JLabel turnLabel;

   private boolean done;
   private TicTacToeBoard board;

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 500;

   private static final int PANEL_HEIGHT = 50;

   private static final int SQUARE_DIM = 100;
   private static final int LEFT_PAD = 30;
   private static final int TOP_PAD = 50;

   private static final int BLANK = 0;
   private static final int X_PLAYER = 1;
   private static final int O_PLAYER = 2;

   public TicTacToeFrame()
   {
      done = false;
      board = new TicTacToeBoard();

      final JPanel panel = new JPanel();
      BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
      panel.setLayout(layout);

      player = X_PLAYER;
      turnLabel = new JLabel("X's turn.");

      component = new TicTacToeComponent(board, SQUARE_DIM, LEFT_PAD, TOP_PAD);

      JButton button = new JButton("Reset Game");

      ActionListener buttonListener = new ResetListener();
      button.addActionListener(buttonListener);

      MousePressedListener listener = new MousePressedListener();
      component.addMouseListener(listener);

      JPanel panel2 = new JPanel();
      panel2.setMaximumSize(new Dimension(FRAME_WIDTH, PANEL_HEIGHT));
      panel2.add(button);
      panel2.add(turnLabel);
      panel.add(panel2);
      panel.add(component);
      add(panel);

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   private void selectSquare(int row, int col)
   {
      board.setMark(row, col, getMark());
   }

   private int computeRow(int y)
   {
      if (y - TOP_PAD < 0)
      {
         return -1;
      }

      return (y - TOP_PAD) / (SQUARE_DIM + 1);
   }

   private int computeCol(int x)
   {
      if (x - LEFT_PAD < 0)
      {
         return -1;
      }

      return (x - LEFT_PAD) / (SQUARE_DIM + 1);
   }

   private void reset()
   {
      board.reset();
      player = X_PLAYER;
      setTurnLabel();
      done = false;
   }

   private void switchPlayer()
   {
      if (player == X_PLAYER)
      {
         player = O_PLAYER;
      }
      else
      {
         player = X_PLAYER;
      }
      setTurnLabel();
   }

   private void setWinner()
   {
      if (player == X_PLAYER)
      {
         turnLabel.setText("X wins!");
      }
      else
      {
         turnLabel.setText("O wins!");
      }
      done = true;
   }

   private void setTurnLabel()
   {
      if (player == X_PLAYER)
      {
         turnLabel.setText("X's turn.");
      }
      else
      {
         turnLabel.setText("O's turn.");
      }
   }

   private int getMark()
   {
      if (player == X_PLAYER)
      {
         return TicTacToeBoard.X_MARK;
      }
      else
      {
         return TicTacToeBoard.O_MARK;
      }
   }

   private class MousePressedListener implements MouseListener
   {
      public void mousePressed(MouseEvent event)
      {
         int mouseX = event.getX();
         int mouseY = event.getY();

         int row = computeRow(mouseY);
         int col = computeCol(mouseX);

         if (!done && board.availableSquare(row, col))
         {
            selectSquare(row, col);
            if (board.determineWinner() != BLANK)
            {
               setWinner();
            }
            else
            {
               switchPlayer();
            }
         }

         repaint();
      }

      // Do-nothing methods
      public void mouseReleased(MouseEvent event)
      {
      }

      public void mouseClicked(MouseEvent event)
      {
      }

      public void mouseEntered(MouseEvent event)
      {
      }

      public void mouseExited(MouseEvent event)
      {
      }
   }

   private class ResetListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         reset();
         repaint();
      }
   }
}
