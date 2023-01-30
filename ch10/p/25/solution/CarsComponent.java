import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
   This component displays cars that move in opposite directions.
*/
public class CarsComponent extends JComponent
{
   private ArrayList<Car> cars;

   public CarsComponent()
   {
      cars = new ArrayList<Car>();
   }

   /**
      Add a car to the component.
      @param car new car to add
   */
   public void add(Car car)
   {
      cars.add(car);
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      for (Car car : cars)
      {
         car.draw(g2);
      }
   }
}
