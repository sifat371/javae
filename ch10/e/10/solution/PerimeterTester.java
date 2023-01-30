import java.awt.Rectangle;

/**
   This program tests the measurement of rectangles by perimeter.
*/
public class PerimeterTester
{
   public static void main(String[] args)
   {
      class PerimeterMeasurer implements Measurer
      {
         public double measure(Object anObject)
         {
            Rectangle aRectangle = (Rectangle) anObject;
            double perimeter = (2 * aRectangle.getWidth())
                  + (2 * aRectangle.getHeight());
            return perimeter;
         }
      }

      Measurer m = new PerimeterMeasurer();

      Rectangle rects[] = new Rectangle[3];

      rects[0] = new Rectangle(5, 10, 20, 30);
      rects[1] = new Rectangle(10, 20, 30, 40);
      rects[2] = new Rectangle(20, 30, 5, 10);

      System.out.println("Average perimeter: " + Data.average(rects, m));
      System.out.println("Expected: 90.0");
      Rectangle max = (Rectangle) Data.max(rects, m);
      System.out.println("Largest perimeter: " + max);
      System.out
            .println("Expected: java.awt.Rectangle[x=10,y=20,width=30,height=40]");
   }
}
