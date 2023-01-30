import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarComponent extends JComponent
{
   private SmartMovingCar car1;
   private SmartMovingCar car2;

   public CarComponent()
   {
      car1 = new SmartMovingCar(50, 100, 10, 250, 500, SmartMovingCar.EAST,
            this);
      car2 = new SmartMovingCar(500, 300, 10, 250, 500, SmartMovingCar.NORTH,
            this);
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2);
      car2.draw(g2);
   }

   /**
      Starts a new animation thread.
   */
   public void startAnimation()
   {
      class AnimationRunnable implements Runnable
      {
         public AnimationRunnable(SmartMovingCar car)
         {
            this.car = car;
         }

         public void run()
         {
            try
            {
               car.animate();
            } catch (InterruptedException exception)
            {
            }
         }

         private SmartMovingCar car;
      }

      Runnable r1 = new AnimationRunnable(car1);
      Runnable r2 = new AnimationRunnable(car2);
      Thread t1 = new Thread(r1);
      Thread t2 = new Thread(r2);
      t1.start();
      t2.start();
   }
}
