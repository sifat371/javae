import java.io.PrintWriter;
import java.util.Scanner;
/**
   Monthly appointment.
*/
public class Monthly extends Appointment
{
   private int day;

   /**
      An empty Monthly appointment.
   */
   public Monthly() { }

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

   /**
      Saves this appointment to a PrintWriter.
      @param out the PrintWriter to save to.
      @return true if the object can be saved.
   */
   public boolean save(PrintWriter out)
   {
      try
      {
         out.println("M " + day + " " + super.toString());
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
         // The M is already consumed at this point
         day = in.nextInt();
         setDescription(in.nextLine().trim());
      }
      catch (Exception e)
      {
         return false;
      }
      return true;
   }
}
