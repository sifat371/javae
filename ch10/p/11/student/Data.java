public class Data
{
   /**
      Computes the average of the measures of the given objects.
      @param objects an array of objects
      @param meas the measurer for the objects
      @param filt the filter for the objects
      @return the average of the measures
   */
   public static double average(Object[] objects, Measurer meas, Filter filt)
   {
      double sum = 0;
      int num = 0;
      for (Object obj : objects)
      {
         if (filt.accept(obj))
         {
            sum = sum + meas.measure(obj);
            num++;
         }
      }
      if (num > 0)
      {
         return sum / num;
      }
      else
      {
         return 0;
      }
   }
}
