//HIDE
import java.io.PrintWriter;
import java.util.Scanner;
/**
   Improve the appointments program of Exercise P9.3 and P9.4
   by letting the user save the appointment data to a file
   and reload the data from a file.
   The saving part is straightforward: Override the save method
   from the revised abstrct Appointment class below.
   - Save the type (D, M, O) and the day or date (as appropriate)
     along with the description, to a file.
   - The loading part is not so easy. First determine the type
     of the appointment to be loaded by reading the type (only)
     from the file. Then, create an object of that type and
     call call the load method to load the data.

   Part I. Complete the Daily, Monthly and Onetime classes.
*/
public abstract class Appointment
{
   private String description;

   /**
      Constructs an appointment without a description.
   */
   public Appointment()
   {
      description = "";
   }

   /**
      Sets the description of this appointment.
      @param description the text description of the appointment
   */
   public void setDescription(String description)
   {
      this.description = description;
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
      return false;
   }

   /**
      Converts appointment to string description.
   */
   public String toString()
   {
      return description;
   }

   /**
      Saves this appointment to a PrintWriter.
      @param out the PrintWriter to save to.
      @return true if the object can be saved.
   */
   public abstract boolean save(PrintWriter out);

   /**
      Loads this appointment from a Scanner
      @param in the Scanner to read from.
      @return true if the object is successfully loaded.
   */
   public abstract boolean load(Scanner in);

}
