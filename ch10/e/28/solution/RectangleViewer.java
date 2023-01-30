import javax.swing.JFrame;

/**
   This program displays a list of rectangles that can be added to with the
   mouse. 
*/
public class RectangleViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new RectangleFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
