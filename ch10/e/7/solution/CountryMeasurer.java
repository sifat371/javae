/**
   Objects of this class measure countries by area.
*/
public class CountryMeasurer implements Measurer
{
   public double measure(Object anObject)
   {
      Country aCountry = (Country) anObject;
      return aCountry.getArea();
   }
}
