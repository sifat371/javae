import java.awt.Graphics;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JComponent;

/**
   A class for an animated object.
*/
public abstract class Animated
{
   private Lock lock = new ReentrantLock();
   private JComponent component;

   /**
      Run the animation.
   */
   public abstract void run();

   /**
      Draw the animation to the given graphics with the given size.
   */
   public abstract void draw(Graphics g, int width, int height);

   /**
      Lock the animation.
   */
   public void lock()
   {
      lock.lock();
   }

   /**
      Unlock the animation.
   */
   public void unlock(int steps)
   {
      lock.unlock();
   }

   /**
      Unlock the animation.
   */
   public void setComponent(JComponent component)
   {
      this.component = component;
   }
}
