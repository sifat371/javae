/**
   A onetime appointment.
*/
public class Onetime extends Appointment
{
   private int year;
   private int month;
   private int day;

   /**
      Initializes appointment for a given date.
      @param year the year
      @param month the month
      @param day the day
      @param description the text description of the appointment
   */
   public Onetime(int year, int month, int day, String description)
   {
      setDescription(description);
      this.year = year;
      this.month = month;
      this.day = day;
   }

   /**
      Determines if this appointment occurs on the given date.
      @param year the year
      @param month the month
      @param day the day
      @return true if the appointment occurs on the given date.
   */
   public boolean occursOn(int year, int month, int day)
   {
      return year == this.year && month == this.month && day == this.day;
   }
}
