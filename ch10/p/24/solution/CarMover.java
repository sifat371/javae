import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class CarMover
{
   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 400;

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("CarMover");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      final CarComponent component = new CarComponent();

      frame.add(component);

      frame.setVisible(true);

      class TimerListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            component.moveCarBy(1, 0);
            component.repaint();
         }
      }

      ActionListener listener = new TimerListener();

      final int DELAY = 100; // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, listener);
      t.start();
   }
}
