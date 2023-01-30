import java.io.PrintWriter;
import java.util.Scanner;
/**
   Daily appointment.
*/
public class Daily extends Appointment
{
   /**
      An empty Daily object
   */
   public Daily() { }

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

   /**
      Saves this appointment to a PrintWriter.
      @param out the PrintWriter to save to.
      @return true if the object can be saved.
   */
   public boolean save(PrintWriter out)
   {
      try
      {
         out.println("D " + super.toString());
      }
      catch (Exception e)
      {
         return false;
      }
      return true;
   }

   /**
      Loads this appointment from a Scanner
      @param in the Scanner to read from.
      @return true if the object is successfully loaded.
   */
   public boolean load(Scanner in)
   {
      try
      {
         // The D is already consumed at this point
         setDescription(in.nextLine().trim());
      }
      catch (Exception e)
      {
         return false;
      }
      return true;
   }
}
