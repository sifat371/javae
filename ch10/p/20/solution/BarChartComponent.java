import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
   This component displays a bar chart.
*/
public class BarChartComponent extends JComponent
{
   private int barHeight;
   private int totalHeight;
   private ArrayList<Bar> bars;

   private static final int MIN_WIDTH = 3;

   /**
      Create a new bar chart component with specified bar height and separation
      spacing
      @param height height of bar
      @param sep space between bars
   */
   public BarChartComponent(int height, int sep)
   {
      this.barHeight = height;
      this.totalHeight = height + sep;
      this.bars = new ArrayList<Bar>();
   }

   /**
      Updates or adds bar with specified width
      @param barNum assumed bar number
      @param width width of bar
   */
   public void updateBar(int barNum, int width)
   {
      if (barNum < bars.size())
      {
         if (width < MIN_WIDTH)
         {
            bars.remove(barNum);
         }
         else
         {
            bars.get(barNum).setWidth(width);
         }
      }
      else
      {
         bars.add(new Bar(width));
      }
   }

   /**
      Paint the component
      @param g graphics device
   */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      int i = 0;
      for (Bar bar : bars)
      {
         Rectangle2D.Double rect = new Rectangle2D.Double(0, i * totalHeight,
               bar.getWidth(), barHeight);

         g2.draw(rect);
         i++;
      }
   }
}
