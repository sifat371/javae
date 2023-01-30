/**
   Complete the Daily class. Read the Appointment class
   comments for the details.
*/
public class Daily extends Appointment
{
   /**
      Constructs a Daily Appointment
      @param description the text description of the appointment
   */
   public Daily(String description)
   {
      setDescription(description);
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
      return true;
   }
}
