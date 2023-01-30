import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JFileChooser;

/**
   A frame for the graphics editor.
*/
public class GraphicsEditorFrame extends JFrame
{
   private GraphPanel graphPanel;
   private int currentShape;
   private Color currentColor;
   private int lastMouseX;
   private int lastMouseY;

   private static final int RECTANGLE = 1;
   private static final int ELLIPSE = 2;
   private static final int LINE = 3;

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 500;

   private static final int PANEL_WIDTH = 350;
   private static final int PANEL_HEIGHT = 300;

   /**
      Constructs the frame.
   */
   public GraphicsEditorFrame()
   {
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      graphPanel = new GraphPanel();
      graphPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

      JMenuBar menuBar = new JMenuBar();
      menuBar.add(createIOMenu());
      menuBar.add(createShapeMenu());
      menuBar.add(createColorMenu());
      setJMenuBar(menuBar);

      add(graphPanel);

      lastMouseX = -1;

      currentColor = Color.RED;
      currentShape = RECTANGLE;

      class MouseClickListener extends MouseAdapter
      {
         public void mousePressed(MouseEvent event)
         {
            int mouseX = event.getX();
            int mouseY = event.getY();

            if (lastMouseX == -1)
            {
               lastMouseX = mouseX;
               lastMouseY = mouseY;
               return;
            }

            int minX = Math.min(mouseX, lastMouseX);
            int maxX = Math.max(mouseX, lastMouseX);
            int minY = Math.min(mouseY, lastMouseY);
            int maxY = Math.max(mouseY, lastMouseY);

            if (currentShape == RECTANGLE)
            {
               graphPanel.addShape(new RectangleShape(minX, minY, maxX - minX,
                     maxY - minY, currentColor));
            }
            if (currentShape == ELLIPSE)
            {
               graphPanel.addShape(new EllipseShape(minX, minY, maxX - minX,
                     maxY - minY, currentColor));
            }
            if (currentShape == LINE)
            {
               graphPanel.addShape(new LineShape(lastMouseX, lastMouseY,
                     mouseX, mouseY, currentColor));
            }

            lastMouseX = -1;
         }
      }

      MouseClickListener listener = new MouseClickListener();
      graphPanel.addMouseListener(listener);
   }

   private JMenu createIOMenu()
   {
      JMenu menu = new JMenu("File");

      JMenuItem newMenuItem = new JMenuItem("New");

      class NewListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            graphPanel.setGraphData(new GraphData());
            repaint();
         }
      }

      newMenuItem.addActionListener(new NewListener());
      menu.add(newMenuItem);

      JMenuItem openMenuItem = new JMenuItem("Open");

      class OpenListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            try
            {
               JFileChooser chooser = new JFileChooser();
               if (chooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION)
               {
                  return;
               }

               ObjectInputStream in = new ObjectInputStream(
                     new FileInputStream(chooser.getSelectedFile()));
               GraphData data = (GraphData) in.readObject();
               in.close();
               graphPanel.setGraphData(data);
            } catch (IOException e)
            {
               e.printStackTrace();
            } catch (ClassNotFoundException e)
            {
               e.printStackTrace();
            }
         }
      }

      openMenuItem.addActionListener(new OpenListener());
      menu.add(openMenuItem);

      JMenuItem saveMenuItem = new JMenuItem("Save");

      class SaveListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            try
            {
               JFileChooser chooser = new JFileChooser();
               if (chooser.showSaveDialog(null) == JFileChooser.CANCEL_OPTION)
               {
                  return;
               }

               ObjectOutputStream out = new ObjectOutputStream(
                     new FileOutputStream(chooser.getSelectedFile()));
               out.writeObject(graphPanel.getGraphData());
               out.close();
            } catch (IOException e)
            {
               e.printStackTrace();
            }
         }
      }

      saveMenuItem.addActionListener(new SaveListener());
      menu.add(saveMenuItem);

      return menu;
   }

   private JMenu createShapeMenu()
   {
      JMenu menu = new JMenu("Shape");
      menu.add(createShapeMenuItem("Rectangle", RECTANGLE));
      menu.add(createShapeMenuItem("Ellipse", ELLIPSE));
      menu.add(createShapeMenuItem("Line", LINE));
      return menu;
   }

   private JMenuItem createShapeMenuItem(String label, final int shape)
   {
      JMenuItem item = new JMenuItem(label);

      class ShapeChangeListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            currentShape = shape;
         }
      }

      item.addActionListener(new ShapeChangeListener());
      return item;
   }

   private JMenu createColorMenu()
   {
      JMenu menu = new JMenu("Color");
      menu.add(createColorMenuItem("Red", Color.RED));
      menu.add(createColorMenuItem("Green", Color.GREEN));
      menu.add(createColorMenuItem("Blue", Color.BLUE));
      menu.add(createColorMenuItem("Yellow", Color.YELLOW));
      return menu;
   }

   private JMenuItem createColorMenuItem(String label, final Color color)
   {
      JMenuItem item = new JMenuItem(label);

      class ColorChangeListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            currentColor = color;
         }
      }

      item.addActionListener(new ColorChangeListener());
      return item;
   }
}
