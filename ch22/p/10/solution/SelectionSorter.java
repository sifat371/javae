import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JComponent;

/**
   This class sorts an array, using the selection sort algorithm.
*/
public class SelectionSorter extends Animated
{
   private int[] a;
   private int markedPosition = -1;
   private int alreadySorted = -1;

   public SelectionSorter(int[] anArray)
   {
      a = anArray;
   }

   public void run()
   {
      for (int i = 0; i < a.length - 1; i++)
      {
         int minPos = minimumPosition(i);
         lock();
         ArrayUtil.swap(a, minPos, i);
         alreadySorted = i;
         unlock(2);
      }
   }

   private int minimumPosition(int from)
   {
      int minPos = from;
      for (int i = from + 1; i < a.length; i++)
      {
         lock();
         if (a[i] < a[minPos])
         {
            minPos = i;
         }
         markedPosition = i;
         unlock(2);
      }
      return minPos;
   }

   public void draw(Graphics g, int width, int height)
   {
      Graphics2D g2 = (Graphics2D) g;

      int deltaX = width / a.length;
      for (int i = 0; i < a.length; i++)
      {
         if (i == markedPosition)
         {
            g2.setColor(Color.RED);
         }
         else if (i <= alreadySorted)
         {
            g2.setColor(Color.BLUE);
         }
         else
         {
            g2.setColor(Color.BLACK);
         }
         Line2D.Double line = new Line2D.Double(i * deltaX, 0, i * deltaX, a[i]);
         g2.draw(line);
      }
   }
}
