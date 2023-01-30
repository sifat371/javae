import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarComponent extends JComponent
{
   private Car car1;
   private Car car2;

   public CarComponent()
   {
      car1 = new Car(50, 100);
      car2 = new Car(500, 300);
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2);
      car2.draw(g2);
   }

   /**
      Starts the animation threads.
   */
   public void startAnimation()
   {
      class AnimationRunnable implements Runnable
      {
         public AnimationRunnable(Car car, int dx, int dy)
         {
            this.car = car;
            this.dx = dx;
            this.dy = dy;
         }

         public void run()
         {
            final int DELAY = 50;
            final int STEPS = 500;
            try
            {
               for (int i = 0; i < STEPS; i++)
               {
                  car.move(dx, dy);
                  CarComponent.this.repaint();
                  Thread.sleep(DELAY);
               }
            } catch (InterruptedException exception)
            {
            }
         }

         Car car;
         int dx;
         int dy;
      }

      Runnable r1 = new AnimationRunnable(car1, 1, 0);
      Runnable r2 = new AnimationRunnable(car2, 0, -1);
      Thread t1 = new Thread(r1);
      Thread t2 = new Thread(r2);
      t1.start();
      t2.start();
   }
}
