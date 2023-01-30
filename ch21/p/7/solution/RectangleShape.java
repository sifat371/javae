import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
   A rectangle.
*/
public class RectangleShape extends GraphShape
{
   private int xtop;
   private int ytop;
   private int width;
   private int height;

   /**
      Constructs an RectangleShape object.
      @param x the x coordinate
      @param y the y coordinate
      @param w the width
      @param h the height
      @param c the color
   */
   public RectangleShape(int x, int y, int w, int h, Color c)
   {
      super(c);
      xtop = x;
      ytop = y;
      width = w;
      height = h;
   }

   /**
      Draws the rectangle.
      @param g the graphics context
   */
   public void draw(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(getColor());
      Rectangle box = new Rectangle(xtop, ytop, width, height);
      g2.draw(box);
   }
}
