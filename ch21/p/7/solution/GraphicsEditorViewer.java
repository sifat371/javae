import javax.swing.JFrame;

/**
   This program is a simple graphics editor.
*/
public class GraphicsEditorViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new GraphicsEditorFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("GraphicsEditor");
      frame.setVisible(true);
   }
}
