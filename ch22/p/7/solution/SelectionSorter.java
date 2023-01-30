import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
   This class sorts an array, using the selection sort 
   algorithm.  It uses the Timer class to run the algorithm
   one step at a time.
*/
public class SelectionSorter
{
   private int[] a;
   private JComponent component;
   private int markedPosition = -1;
   private int alreadySorted = -1;
   private int i = 0;
   private int j = 1;
   private int minPos = 0;
   private Timer t;
   private final int DELAY = 200;

   /**
      This class runs the next step of the algorithm and
      display the state.
   */
   class NextStep implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         runToNextStep();
         component.repaint();
      }
   }

   /**
      Constructs a selection sorter.
      @param anArray the array to sort
      @param aComponent the component to be repainted when the animation 
      pauses
   */
   public SelectionSorter(int[] anArray, JComponent aComponent)
   {
      a = anArray;
      component = aComponent;

      NextStep listener = new NextStep();
      t = new Timer(DELAY, listener);
      t.start();
   }

   /**
      Sorts the values in the array by one step.  Then, it will
      store all it's status and move to the next step until the 
      method been call again.
   */
   public void runToNextStep()
   {
      if (i < a.length - 1) // if more values need to be sorted
      {
         if (j < a.length) // if still need to find the minimum
         {
            if (a[j] < a[minPos])
               minPos = j;
            markedPosition = j;
            j++;
         }
         else
         {
            swap(minPos, i); // after finds the min, swap the values
            alreadySorted = i;
            j = i + 1;
            markedPosition = j;
            i++;
            minPos = i;
         }
      }
      else
      {
         // stops the timer, causing it to stop sending action events to its listeners.
         t.stop();
      }
   }

   /**
      Swaps two entries of the array.
      @param i the first position to swap
      @param j the second position to swap
   */
   private void swap(int i, int j)
   {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }

   /**
      Draws the current state of the sorting algorithm.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      int deltaX = component.getWidth() / a.length;
      for (int i = 0; i < a.length; i++)
      {
         if (i == markedPosition)
            g2.setColor(Color.RED);
         else if (i <= alreadySorted)
            g2.setColor(Color.BLUE);
         else
            g2.setColor(Color.BLACK);
         g2.draw(new Line2D.Double(i * deltaX, 0, i * deltaX, a[i]));
      }
   }
}
