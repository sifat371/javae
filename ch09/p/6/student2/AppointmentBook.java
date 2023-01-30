import java.util.Scanner;
import java.util.PrintWriter;
/**
   Improve the appointment book program of Exercise
   P9.3 and P9.4 by letting the user save the appointment
   data to a file and reload the data from a file. The saving
   part is straightforward: Make a method to save.
   Save the type, description, and date to a file. The loading
   part is not so easy. First determine the type of the
   appointment to be loaded, create an object of that type,
   and then call a load method to load the data.

   Use the Appointment, Daily, Monthly and Ontime classes
   from Part I of this assignment.
*/
public class AppointmentBook
{
   /**
      Adds a new Appointment object based on user input.
      @param in the Scanner to read from.
   */
   public void addAppointment(Scanner in)
   {
      . . .

   }

   /**
      Method to print all appointments on a certain date.
      @param in the Scanner to read from
   */
   public void findAppointments(Scanner in)
   {
      . . .

   }

   /**
      Save the appointments to a file.
      @param out the output stream to save to.
   */
   public void saveAppointments(PrintWriter out)
   {
      . . .

   }

   /**
      Load appointments from a file.
      @param in the Scanner to read from
   */
   public void loadAppointments(Scanner in)
   {
      . . .

   }
}
