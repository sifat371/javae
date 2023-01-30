import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.font.TextLayout;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
   This component implements a scrolling message
*/
public class ScrollingComponent extends JComponent
{
   private String message;
   private int x;
   private int y;
   private int direction;

   /**
      Create a scrolling message at position x, y.
      @param message message to scroll
      @param x initial x position
      @param y y position
   */
   public ScrollingComponent(String message, int x, int y)
   {
      this.message = message;
      this.x = x;
      this.y = y;
      this.direction = -1;
   }

   /**
      Paint the component
      @param g graphics device
   */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      FontRenderContext frc = g2.getFontRenderContext();
      TextLayout layout = new TextLayout(message, getFont(), frc);

      Rectangle2D bounds = layout.getBounds();
      if (x + bounds.getWidth() <= 0)
      {
         x = getWidth();
      }
      else if (x > getWidth())
      {
         x = (int) -bounds.getWidth();
      }

      bounds.setRect(bounds.getX() + x, bounds.getY() + y, bounds.getWidth(),
            bounds.getHeight());
      g2.setColor(getBackground());
      g2.fill(layout.getLogicalHighlightShape(0, message.length(), bounds));

      g2.setColor(getForeground());
      layout.draw(g2, x, y);
   }

   /**
      Advance the message one step in the current direction
   */
   public void advancePosition()
   {
      x += direction;
   }

   /**
      Change direction of scrolling message
   */
   public void changeDirection()
   {
      direction = -1 * direction;
   }

   /**
      Change the message.
      @param message new message to scroll
   */
   public void setMessage(String message)
   {
      this.message = message;
   }
}
