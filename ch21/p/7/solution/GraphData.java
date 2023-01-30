import java.util.ArrayList;
import java.io.Serializable;

/**
   A data set that contains an array list of graph shapes.
*/
public class GraphData implements Serializable
{
   private ArrayList<GraphShape> data;

   /**
      Constructs a GraphData object.
   */
   public GraphData()
   {
      data = new ArrayList<>();
   }

   /**
      Sets the shape.
	  @param s the shape
   */
   public void add(GraphShape s)
   {
      data.add(s);
   }

   /**
      Returns the size of the array list.
      @return size of array list.
   */
   public int size()
   {
      return data.size();
   }

   /**
      Gets a graph shape.
      @param n the index to the shape.
      @return the shape with the given index.
   */
   public GraphShape get(int n)
   {
      return data.get(n);
   }
}
