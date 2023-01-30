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
      Uses a lambda expression to define a Filter which accepts objects normally rejected.
      @return an inverted Filter object
   */
   default Filter invert()
   {
      Filter invertedFilter = (Object anObject) -> !accept(anObject);
      return invertedFilter;
   }
}
