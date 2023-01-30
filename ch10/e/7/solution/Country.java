public class Country
{
   private String name;
   private double area;

   /**
      Construct a country with name and area.
      @param name country's name
      @param area total area of country
   */
   public Country(String name, double area)
   {
      this.name = name;
      this.area = area;
   }

   /**
      Country's area.
      @return the area
   */
   public double getArea()
   {
      return area;
   }

   /**
      Country's name.
      @return the name
   */
   public String getName()
   {
      return name;
   }
}
