import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class MergeSorter
{
   private int[] a;

   // for animation
   private int markedPosition = -1;
   private int startPosition = -1;
   private int endPosition = -1;

   private JComponent component;
   private static final int DELAY = 100;

   public MergeSorter(int[] anArray, JComponent aComponent)
   {
      a = anArray;
      component = aComponent;
   }

   /**
      Sorts the array managed by this merge sorter
   */
   public void sort() throws InterruptedException
   {
      mergeSort(0, a.length - 1);
   }

   /**
      Sorts a range of the array, using the merge sort
      algorithm.
      @param from the first index of the range to sort
      @param to the last index of the range to sort
   */
   public void mergeSort(int from, int to) throws InterruptedException
   {
      if (from == to)
         return;
      int mid = (from + to) / 2;
      // sort the first and the second half
      mergeSort(from, mid);
      mergeSort(mid + 1, to);
      merge(from, mid, to);
   }

   /**
      Merges two adjacent subranges of the array
      @param from the index of the first element of the first range
      @param mid the index of the last element of the first range
      @param to the index of the last element of the second range
   */
   public void merge(int from, int mid, int to) throws InterruptedException
   {
      startPosition = from;
      endPosition = to;

      int n = to - from + 1;
      // size of the range to be merged

      // merge both halves into a temporary array b 
      int[] b = new int[n];

      int i1 = from;
      // next element to consider in the first range
      int i2 = mid + 1;
      // next element to consider in the second range
      int j = 0;
      // next open position in b

      // as long as neither i1 nor i2 past the end, move
      // the smaller element into b
      while (i1 <= mid && i2 <= to)
      {
         if (a[i1] < a[i2])
         {
            b[j] = a[i1];
            markedPosition = i1;
            i1++;
         }
         else
         {
            b[j] = a[i2];
            markedPosition = i2;
            i2++;
         }

         pause(4);
         j++;
      }

      // note that only one of the two while loops
      // below is executed

      // copy any remaining entries of the first half
      while (i1 <= mid)
      {
         b[j] = a[i1];
         markedPosition = i1;
         pause(2);
         i1++;
         j++;
      }

      // copy any remaining entries of the second half
      while (i2 <= to)
      {
         b[j] = a[i2];
         markedPosition = i2;
         pause(2);
         i2++;
         j++;
      }

      // copy back from the temporary array
      for (j = 0; j < n; j++)
      {
         a[from + j] = b[j];
         markedPosition = from + j;
         pause(2);
      }
   }

   public void draw(Graphics2D g2)
   {
      if (a == null)
         return;
      int deltaX = component.getWidth() / a.length;
      for (int i = 0; i < a.length; i++)
      {
         if (i == markedPosition)
            g2.setColor(Color.red);
         else if (startPosition <= i && i <= endPosition)
            g2.setColor(Color.blue);
         else
            g2.setColor(Color.black);
         g2.draw(new Line2D.Double(i * deltaX, 0, i * deltaX, a[i]));
      }
   }

   public void pause(int steps) throws InterruptedException
   {
      if (Thread.interrupted())
         throw new InterruptedException();
      component.repaint();
      Thread.sleep(steps * DELAY);
   }
}
