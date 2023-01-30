import java.lang.InterruptedException;
import java.util.NoSuchElementException;

/**
   A thread safe implementation of a stack as a sequence of nodes.
*/
public class LinkedListStack
{
   private Node first;
   private boolean lock;

   /** 
      Constructs an empty stack.
   */
   public LinkedListStack()
   {
      first = null;
      lock = false;
   }

   /**
      Adds an element to the top of the stack.
      @param element the element to add
   */
   public void push(Object element)
   {
      while (lock)
      {
         try
         {
            Thread.sleep(100);
         } catch (InterruptedException e)
         {
         }
      }
      lock = true;
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
      lock = false;
   }

   /**
      Removes the element from the top of the stack.
      @return the removed element
   */
   public Object pop()
   {
      while (lock)
      {
         try
         {
            Thread.sleep(100);
         } catch (InterruptedException e)
         {
         }
      }
      lock = true;
      if (first == null)
      {
         throw new NoSuchElementException();
      }
      Object element = first.data;
      first = first.next;
      lock = false;
      return element;
   }

   /**
      Checks whether this stack is empty.
      @return true if the stack is empty
   */
   public boolean empty()
   {
      while (lock)
      {
         try
         {
            Thread.sleep(100);
         } catch (InterruptedException e)
         {
         }
      }
      return first == null;
   }

   class Node
   {
      public Object data;
      public Node next;
   }
}
