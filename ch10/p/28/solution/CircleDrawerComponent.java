import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;

/**
   This component displays a circle.
*/
public class CircleDrawerComponent extends JComponent
{
   private double x;
   private double y;
   private double radius;

   public CircleDrawerComponent()
   {
   }

   public void setPositionAndSize(double x, double y, double radius)
   {
      this.x = x;
      this.y = y;
      this.radius = radius;
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      Ellipse2D.Double circle = new Ellipse2D.Double(x - radius, y - radius,
            radius * 2, radius * 2);

      g2.draw(circle);

      repaint();
   }
}
