import java.awt.Point;

/**
   A class to represent a labeled point.
*/
public class LabeledPoint
{
   private Point p;
   private String label;

   /**
      Constructs a labeled point at (x,y) with a given label.
      @param x the x coordinate
      @param y the y coordinate
      @param label the point label
   */
   public LabeledPoint(int x, int y, String label)
   {
      p = new Point(x, y);
      this.label = label;
   }

   /**
      Displays the (x,y) and point label
   */
   public String toString()
   {
      return p.toString() + " label=" + label;
   }
}
