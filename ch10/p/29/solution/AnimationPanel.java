import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.ArrayList;

/**
   This component animates MoveableShale objects.
*/
public class AnimationPanel extends JPanel
{
   private ArrayList<MoveableShape> shapes;

   public AnimationPanel(ArrayList<MoveableShape> s)
   {
      this.shapes = s;
      class TimerListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            for (MoveableShape shape : AnimationPanel.this.shapes)
            {
               shape.move(1, 0);
            }
            repaint();
         }
      }

      ActionListener listener = new TimerListener();

      final int DELAY = 100; // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, listener);
      t.start();
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      for (MoveableShape shape : shapes)
      {
         shape.draw(g2);
      }
   }
}
