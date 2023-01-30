import java.io.PrintWriter;
import java.util.Scanner;
/**
   A onetime appointment.
*/
public class Onetime extends Appointment
{
   private int year;
   private int month;
   private int day;

   /**
      Empty one-time appointment.
   */
   public Onetime() { }

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

   /**
      Saves this appointment to a PrintWriter.
      @param out the PrintWriter to save to.
      @return true if the object can be saved.
   */
   public boolean save(PrintWriter out)
   {
      try
      {
         out.println("O " + year + " " + month + " " + day + " " + super.toString());
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
         // The O is already consumed at this point
         year = in.nextInt();
         month = in.nextInt();
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
