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
      Counts the number of objects accepted by a filter.
      @param values array of objects to be filtered
      @param condition the Filter object used to accept objects
      @return the number of values accepted by the condition filter
   */
   static int count(Object[] values, Filter condition)
   {
      int numAccepted = 0;
      for (Object obj : values)
      {
         if (condition.accept(obj))
         {
            numAccepted++;
         }
      }
      return numAccepted;
   }
}
