import javax.swing.JFrame;

public class BankSimulatorViewer
{
   public static void main(String[] args)
   {
      BankSimulatorFrame frame = new BankSimulatorFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("BankSimulator");
      frame.setVisible(true);
   }
}

