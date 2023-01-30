
/**
   Describes any class whose objects can filter other objects.
*/
public interface Filter
{
   /**
      Filters or accepts an object.
      @param anObject the object to potentially be filtered
      @return accept or reject
   */
   boolean accept(Object anObject);
   
   /**
      Retains array objects which meet a Filter condition.  
      The rest of the array elements are set to null.
      @param values an array of objects to be filtered
      @param condition a Filter to be used for retaining objects
   */
   static void retainAll(Object[] values, Filter condition)
   {
      Object[] accepted =  new Object[values.length];
      int num = 0;
      for (Object obj : values)
      {
         if (condition.accept(obj))
         {
            accepted[num] = obj;
            num++;
         }
      }
      for (int i = 0; i < num; i++)
      {
         values[i] = accepted[i];
      }
      for (int i = num; i < values.length; i++)
      {
         values[i] = null;
      }
   }
}
