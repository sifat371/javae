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
}
