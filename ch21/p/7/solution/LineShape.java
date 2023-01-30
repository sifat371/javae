import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
   A line.
*/
public class LineShape extends GraphShape
{
   private int xfrom;
   private int yfrom;
   private int xto;
   private int yto;

   /**
      Constructs an LineShape object.
      @param x1 the first x coordinate
      @param y1 the first y coordinate
      @param x2 the second x coordinate
      @param y2 the second y coordinate      
      @param c the color;
   */
   public LineShape(int x1, int y1, int x2, int y2, Color c)
   {
      super(c);
      xfrom = x1;
      yfrom = y1;
      xto = x2;
      yto = y2;
   }

   /**
      Draws the line.
      @param g the graphics context
   */
   public void draw(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(getColor());
      Line2D.Double line = new Line2D.Double(xfrom, yfrom, xto, yto);
      g2.draw(line);
      g2.setColor(Color.black);
   }
}
