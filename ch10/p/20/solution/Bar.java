/**
   A horizontal bar in a bar chart.
*/
public class Bar
{
   private int width;

   /**
      Create a new bar
      @param width width of bar
   */
   public Bar(int width)
   {
      this.width = width;
   }

   /**
      Retrieve width of bar
      @return width
   */
   public int getWidth()
   {
      return width;
   }

   /**
      Set width of bar
      @param width new with of bar
   */
   public void setWidth(int width)
   {
      this.width = width;
   }
}
