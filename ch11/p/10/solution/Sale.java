/**
   Represents a single sale.
*/
public class Sale
{
   private String name;
   private String service;
   private double amount;
   private String date;

   /**
      Constructs a Sale.
      @param name client name
      @param service service category
      @param amount cost of service
      @param date date of service
   */
   public Sale(String name, String service, double amount, String date)
   {
      this.name = name;
      this.service = service;
      this.amount = amount;
      this.date = date;
   }

   /**
      Retrieve client name.
      @return name
   */
   public String getName()
   {
      return name;
   }

   /**
      Retrieve service category.
      @return service category
   */
   public String getServiceCategory()
   {
      return service;
   }

   /**
      Retrieve amount.
      @return cost of service
   */
   public double getAmount()
   {
      return amount;
   }

   /**
      Retrieve date.
      @return date of service
   */
   public String getDate()
   {
      return date;
   }
}
