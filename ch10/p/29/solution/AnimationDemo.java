import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.ArrayList;

public class AnimationDemo
{
   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 400;

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Animation Demo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      ArrayList<MoveableShape> shapes = new ArrayList<MoveableShape>();
      shapes.add(new Car(0, 10));
      shapes.add(new MoveableRectangle(20, 130, 20, 10));
      shapes.add(new Car(40, 90));
      shapes.add(new MoveableRectangle(20, 50, 100, 20));

      AnimationPanel panel = new AnimationPanel(shapes);

      frame.add(panel);

      frame.setVisible(true);
   }
}
