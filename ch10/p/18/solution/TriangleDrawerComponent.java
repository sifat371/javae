import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   This component displays a triangle.
*/
public class TriangleDrawerComponent extends JComponent
{
   private Point2D points[];
   private int numPoints;

   private static final int MAX_POINTS = 3;

   /**
      Create a new triangle drawer component
   */
   public TriangleDrawerComponent()
   {
      points = new Point2D[MAX_POINTS];
      numPoints = 0;
   }

   /**
      Set the coordinates of the first point
      @param x x-coordinate
      @param y y-coordinate
   */
   public void setFirstPoint(int x, int y)
   {
      setPoint(x, y, 0);
   }

   /**
      Set the coordinates of the second point
      @param x x-coordinate
      @param y y-coordinate
   */
   public void setSecondPoint(int x, int y)
   {
      setPoint(x, y, 1);
   }

   /**
      Set the coordinates of the third point
      @param x x-coordinate
      @param y y-coordinate
   */
   public void setThirdPoint(int x, int y)
   {
      setPoint(x, y, 2);
   }

   /**
      Set the coordinates of the idx point
      @param x x-coordinate
      @param y y-coordinate
   */
   private void setPoint(int x, int y, int idx)
   {
      if (idx >= 0 && idx < MAX_POINTS)
      {
         points[idx] = new Point2D.Double(x, y);
         numPoints++;
      }
   }

   /**
      Clear the points
   */
   public void clearPoints()
   {
      numPoints = 0;
   }

   /**
      Paint the component
      @param g graphics device
   */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      if (numPoints > 0)
      {
         g2.draw(new Ellipse2D.Double(points[0].getX(), points[0].getY(), 1, 1));
      }
      if (numPoints > 1)
      {
         g2.draw(new Line2D.Double(points[0], points[1]));
      }
      if (numPoints > 2)
      {
         g2.draw(new Line2D.Double(points[1], points[2]));
         g2.draw(new Line2D.Double(points[2], points[0]));
      }
   }
}
