import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SortViewer
{
   public static void main(String[] args)
   {
      JFrame mergeFrame = new JFrame();
      JFrame selectionFrame = new JFrame();

      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 400;

      mergeFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      selectionFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      mergeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      selectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      int[] values = ArrayUtil.randomIntArray(30, 300);
      int[] valuesCopy = new int[values.length];
      System.arraycopy(values, 0, valuesCopy, 0, values.length);

      final MergeSortComponent mergeComponent = new MergeSortComponent(values);
      mergeFrame.add(mergeComponent, BorderLayout.CENTER);
      mergeFrame.setTitle("Merge Sort");
      mergeFrame.setLocation(0, 0);

      final SelectionSortComponent selectionComponent = new SelectionSortComponent(
            valuesCopy);
      selectionFrame.add(selectionComponent, BorderLayout.CENTER);
      selectionFrame.setTitle("Selection Sort");
      selectionFrame.setLocation(350, 0);

      mergeFrame.setVisible(true);
      selectionFrame.setVisible(true);
      mergeComponent.startAnimation();
      selectionComponent.startAnimation();
   }
}
