import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   A moveable rectangle shape that can be positioned anywhere on the screen.
*/
public class MoveableRectangle implements MoveableShape
{
   private int xLeft;
   private int yTop;
   private int width;
   private int height;

   /**
      Constructs a rectangle with a given top left corner, width, and height.
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
      @param w the width of the rectangle
      @param h the height of the rectangle
   */
   public MoveableRectangle(int x, int y, int w, int h)
   {
      xLeft = x;
      yTop = y;
      width = w;
      height = h;
   }

   /**
      Draws the car.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      Rectangle r = new Rectangle(xLeft, yTop, width, height);
      g2.draw(r);
   }

   /**
      Move car by delta-x and delta-y.
      @param dx change in x position
      @param dy change in y position
   */
   public void move(int dx, int dy)
   {
      xLeft += dx;
      yTop += dy;
   }
}
