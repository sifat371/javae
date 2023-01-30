import java.awt.Graphics;
import javax.swing.JPanel;

/**
   A panel to hold all graphics.
*/
public class GraphPanel extends JPanel
{
   private GraphData shapes;

   /**
      Constructs a GraphPanel object.
   */
   public GraphPanel()
   {
      shapes = new GraphData();
   }

   /**
      Draws all shapes and text.
      @param g the graphics context
   */
   public void paintComponent(Graphics g)
   {
      // draw shapes

      for (int i = 0; i < shapes.size(); i++)
      {
         GraphShape s = shapes.get(i);
         s.draw(g);
      }
   }

   /**
      Add a shape to the list.
      @param s the shape to add
   */
   public void addShape(GraphShape s)
   {
      shapes.add(s);
      repaint();
   }

   /**
      Gets the graph data
      @return the car data
   */
   public GraphData getGraphData()
   {
      return shapes;
   }

   /**
      Sets the graph data.
      @param s the new graph data
   */
   public void setGraphData(GraphData s)
   {
      shapes = s;
      repaint();
   }
}
