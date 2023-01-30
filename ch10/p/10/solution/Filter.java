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
      Determines whether an object is rejected by the filter.
      @param x the object to be tested
      @return true if the object is rejected, false otherwise
   */
   default boolean reject(Object x)
   {
      return !accept(x);
   }
}
