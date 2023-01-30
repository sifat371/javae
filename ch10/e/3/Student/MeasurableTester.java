/**
   This program demonstrates the measurable Country class.
*/
public class MeasurableTester
{
   public static void main(String[] args)
   {
      Measurable[] countries = new Measurable[3];
      countries[0] = new Country("Uruguay", 176220);
      countries[1] = new Country("Thailand", 513120);
      countries[2] = new Country("Belgium", 30510);

      Measurable maxCountry = Measurable.largest(countries);
      System.out.println("Maximum area: " + maxCountry.getMeasure());
      System.out.println("Expected: 513120");
      Measurable minCountry = Measurable.smallest(countries);
      System.out.println("Minimum area: " + minCountry.getMeasure());
      System.out.println("Expected: 30510");
   }
}
