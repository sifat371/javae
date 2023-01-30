/**
   A labeled point has x- and y-coordinates and a
   string label. Provide a class LabeledPoint with
   a constructor LabeledPoint(int x, int y, String label)
   and a toString method that displays x, y, and the label.
*/
public class LabeledPoint
{
   private int x;
   private int y;
   private String label;

   /**
      Constructs a labeled point at (x,y) with a given label.
      @param x the x coordinate
      @param y the y coordinate
      @param label the point label
   */
   public LabeledPoint(int x, int y, String label)
   {
      this.x = x;
      this.y = y;
      this.label = label;
   }

   /**
      Displays the (x,y) and point label.
   */
   public String toString()
   {
      return "LabeledPoint[x=" + x + ",y=" + y + ",label=" + label + "]";
   }
}

