import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
   A general shape.
*/
public abstract class GraphShape implements Serializable
{
   private Color color;

   /**
      Constructs a GraphShape object.
      @param c the color
   */
   public GraphShape(Color c)
   {
      color = c;
   }

   /**
      Draws a shape.
      @param g the graphics context
   */
   public abstract void draw(Graphics g);

   /**
      Gets the color.
      @return the color
   */
   public Color getColor()
   {
      return color;
   }
}
