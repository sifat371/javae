/**
   This is a simplified thread safe implementation of an array list.
*/
public class ArrayList
{
   private Object[] buffer;
   private int currentSize;
   private boolean lock;

   /**
      Constructs an empty array list.
   */
   public ArrayList()
   {
      final int INITIAL_SIZE = 10;
      buffer = new Object[INITIAL_SIZE];
      currentSize = 0;
      lock = false;
   }

   /**
      Gets the size of this array list.
      @return the size
   */
   public int size()
   {
      //complete this method
   }

   /**
      Throws an IndexOutOfBoundsException if the checked index is out of bounds
      @param n the index to check
   */
   private void checkBounds(int n)
   {
      if (n < 0 || n >= currentSize)
      {
         throw new IndexOutOfBoundsException();
      }
   }

   /**
      Gets the element at a given position.
      @param pos the position
      @return the element at pos
   */
   public Object get(int pos)
   {
      //complete this method
   }

   /**
      Sets the element at a given position.
      @param pos the position
      @param element the new value
   */
   public void set(int pos, Object element)
   {
      //complete this method
   }

   /**
      Removes the element at a given position.
      @param pos the position
      @return the removed element
   */
   public Object remove(int pos)
   {
      //complete this method
   }

   /**
      Adds an element after a given position.
      @param pos the position
      @param newElement the element to add
	  @return true
   */
   public boolean add(int pos, Object newElement)
   {
      //complete this method
   }

   /**
      Adds an element after the end of the array list
      @param newElement the element to add
	  @return true
   */
   public boolean addLast(Object newElement)
   {
      //complete this method
   }

   /**
      Grows the buffer if the current size equals the buffer's capacity.
   */
   private void growBufferIfNecessary()
   {
      if (currentSize == buffer.length)
      {
         Object[] newBuffer = new Object[2 * buffer.length];
         for (int i = 0; i < buffer.length; i++)
         {
            newBuffer[i] = buffer[i];
         }
         buffer = newBuffer;
      }
   }
}
