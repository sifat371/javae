import java.util.Arrays;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.Timer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JColorChooser;

/**
   Scrolling message frame.
 */
public class ScrollingFrame extends JFrame
{
   private ScrollingComponent message;
   private Timer timer;

   private static final int INITIAL_DELAY = 100; // ms between timer ticks
   private static final int DELAY_INC = 10;

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 500;
   private static final int NUM_TEXT_COLS = 30;

   private static final String fontNames[] = { Font.SANS_SERIF, Font.SERIF,
         Font.MONOSPACED, Font.DIALOG };
   private static final String fontStyleNames[] = { "Plain", "Bold", "Italic",
         "Bold Italic" };
   private static final int fontStyles[] = { Font.PLAIN, Font.BOLD,
         Font.ITALIC, Font.BOLD | Font.ITALIC };
   private static final int fontSizes[] = { 12, 16, 18, 20, 24, 28 };

   public ScrollingFrame()
   {
      final JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

      message = new ScrollingComponent("Scrolling Message ...", 0, 20);

      JButton directionButton = new JButton("Change Direction");
      ActionListener directionListener = new DirectionListener();
      directionButton.addActionListener(directionListener);

      JButton fasterButton = new JButton("Increase Speed");
      ActionListener fasterListener = new FasterListener();
      fasterButton.addActionListener(fasterListener);

      JButton slowerButton = new JButton("Decrease Speed");
      ActionListener slowerListener = new SlowerListener();
      slowerButton.addActionListener(slowerListener);

      JPanel panel3 = new JPanel();
      panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
      panel3.add(slowerButton);
      panel3.add(fasterButton);

      JTextField textfield = new JTextField(NUM_TEXT_COLS);
      ActionListener textListener = new MessageTextListener(textfield);
      textfield.addActionListener(textListener);

      JButton foregroundButton = new JButton("Change Foreground Color");
      ActionListener foregroundListener = new ForegroundListener(this);
      foregroundButton.addActionListener(foregroundListener);

      JButton backgroundButton = new JButton("Change Background Color");
      ActionListener backgroundListener = new BackgroundListener(this);
      backgroundButton.addActionListener(backgroundListener);

      JPanel panel4 = new JPanel();
      panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
      panel4.add(foregroundButton);
      panel4.add(backgroundButton);

      JComboBox fontNameBox = new JComboBox(fontNames);
      fontNameBox.addActionListener(new FontNameListener(fontNameBox));

      JComboBox fontStyleBox = new JComboBox(fontStyleNames);
      fontStyleBox.addActionListener(new FontStyleListener(fontStyleBox));

      JComboBox fontSizeBox = new JComboBox();
      for (int size : fontSizes)
      {
         fontSizeBox.addItem(Integer.toString(size));
      }
      fontSizeBox.addActionListener(new FontSizeListener(fontSizeBox));

      JPanel panel5 = new JPanel();
      panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));
      panel5.add(fontNameBox);
      panel5.add(fontStyleBox);
      panel5.add(fontSizeBox);

      JPanel panel2 = new JPanel();

      panel2.add(textfield);
      panel2.add(directionButton);
      panel2.add(panel3);
      panel2.add(panel4);
      panel2.add(panel5);
      panel.add(message);
      panel.add(panel2);
      add(panel);

      ScrollUpdate listener = new ScrollUpdate();

      timer = new Timer(INITIAL_DELAY, listener);
      timer.start();

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   private class ScrollUpdate implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         message.advancePosition();
         repaint();
      }
   }

   private class DirectionListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         message.changeDirection();
         repaint();
      }
   }

   private class FasterListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         int delay = timer.getDelay() - DELAY_INC;
         if (delay <= 0)
         {
            delay = 1;
         }
         timer.setDelay(delay);
      }
   }

   private class SlowerListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         timer.setDelay(timer.getDelay() + DELAY_INC);
      }
   }

   private class ForegroundListener implements ActionListener
   {
      private Component component;

      public ForegroundListener(Component component)
      {
         this.component = component;
      }

      public void actionPerformed(ActionEvent event)
      {
         Color color = JColorChooser.showDialog(component, "Foreground Color",
               Color.BLACK);
         if (color != null)
         {
            message.setForeground(color);
            repaint();
         }
      }
   }

   private class BackgroundListener implements ActionListener
   {
      private Component component;

      public BackgroundListener(Component component)
      {
         this.component = component;
      }

      public void actionPerformed(ActionEvent event)
      {
         Color color = JColorChooser.showDialog(component, "Background Color",
               Color.WHITE);
         if (color != null)
         {
            message.setBackground(color);
            repaint();
         }
      }
   }

   private class MessageTextListener implements ActionListener
   {
      private JTextField field;

      public MessageTextListener(JTextField field)
      {
         this.field = field;
      }

      public void actionPerformed(ActionEvent event)
      {
         message.setMessage(field.getText());
         repaint();
      }
   }

   private class FontNameListener implements ActionListener
   {
      private JComboBox combo;

      public FontNameListener(JComboBox combo)
      {
         this.combo = combo;
      }

      public void actionPerformed(ActionEvent e)
      {
         Font font = message.getFont();
         message.setFont(new Font(fontNames[combo.getSelectedIndex()], font
               .getStyle(), font.getSize()));
         repaint();
      }
   }

   private class FontStyleListener implements ActionListener
   {
      private JComboBox combo;

      public FontStyleListener(JComboBox combo)
      {
         this.combo = combo;
      }

      public void actionPerformed(ActionEvent e)
      {
         Font font = message.getFont();
         message.setFont(new Font(font.getFamily(), fontStyles[combo
               .getSelectedIndex()], font.getSize()));
         repaint();
      }
   }

   private class FontSizeListener implements ActionListener
   {
      private JComboBox combo;

      public FontSizeListener(JComboBox combo)
      {
         this.combo = combo;
      }

      public void actionPerformed(ActionEvent e)
      {
         Font font = message.getFont();
         message.setFont(new Font(font.getFamily(), font.getStyle(),
               fontSizes[combo.getSelectedIndex()]));
         repaint();
      }
   }
}
