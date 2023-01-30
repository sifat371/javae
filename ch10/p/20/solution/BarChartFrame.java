import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
   Allows the user to create a bar chart by varying the size of bars,
   adding, and removing bars.
 */
public class BarChartFrame extends JFrame
{
   private BarChartComponent component;

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 400;

   private static final int BAR_HEIGHT = 20;
   private static final int BAR_SEP = 5;
   private static final int BAR_TOTAL_HEIGHT = BAR_HEIGHT + BAR_SEP;

   public BarChartFrame()
   {
      component = new BarChartComponent(BAR_HEIGHT, BAR_SEP);

      // add mouse click listener
      class MousePressedListener implements MouseListener
      {
         public void mousePressed(MouseEvent event)
         {
            int mouseX = event.getX();
            int mouseY = event.getY();

            int barNum = mouseY / BAR_TOTAL_HEIGHT;

            component.updateBar(barNum, mouseX);
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

      MousePressedListener listener = new MousePressedListener();
      component.addMouseListener(listener);
      add(component);

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }
}
