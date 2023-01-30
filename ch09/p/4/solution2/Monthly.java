/**
   Monthly appointment.
*/
public class Monthly extends Appointment
{
   private int day;

   /**
      Initializes appointment for a given date.
      @param day the day of the month
      @param description the text description of the appointment
   */
   public Monthly(int day, String description)
   {
      setDescription(description);
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
      return day == this.day;
   }
}
