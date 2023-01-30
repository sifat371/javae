import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
   Allows the user to specify a triangle with three mouse clicks.
 */
public class TriangleDrawerFrame extends JFrame
{
   private TriangleDrawerComponent component;

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 400;

   public TriangleDrawerFrame()
   {
      component = new TriangleDrawerComponent();

      final int MAX_CLICKS = 3;

      // add mouse click listener
      class MousePressedListener implements MouseListener
      {
         public void mousePressed(MouseEvent event)
         {
            if (clicks >= MAX_CLICKS)
            {
               component.clearPoints();
               clicks = 0;
            }

            int mouseX = event.getX();
            int mouseY = event.getY();

            if (clicks == 0)
            {
               component.setFirstPoint(mouseX, mouseY);
            }
            else if (clicks == 1)
            {
               component.setSecondPoint(mouseX, mouseY);
            }
            else if (clicks == 2)
            {
               component.setThirdPoint(mouseX, mouseY);
            }
            repaint();
            clicks++;
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

         private int clicks = 0;
      }

      MousePressedListener listener = new MousePressedListener();
      component.addMouseListener(listener);

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      add(component);
   }
}
