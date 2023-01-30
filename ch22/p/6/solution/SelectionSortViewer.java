import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionSortViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 450;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      final SelectionSortComponent component = new SelectionSortComponent();
      frame.add(component, BorderLayout.CENTER);

      final JButton button = new JButton("Start");
      class ButtonListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            button.setEnabled(false);
            component.startAnimation();
         }
      }

      ActionListener listener = new ButtonListener();
      button.addActionListener(listener);

      frame.add(button, BorderLayout.SOUTH);
      frame.setVisible(true);
   }
}
