/**
   This program demonstrates the CountryMeasurer class.
*/
public class MeasurerTester
{
   public static void main(String[] args)
   {
      Country[] countries = new Country[3];
      countries[0] = new Country("Uruguay", 176220);
      countries[1] = new Country("Thailand", 513120);
      countries[2] = new Country("Belgium", 30510);

      Country maxCountry = (Country) Data.max(countries, new CountryMeasurer());
      System.out.println("Largest Country: " + maxCountry.getName());
      System.out.println("Expected: Thailand");
   }
}
