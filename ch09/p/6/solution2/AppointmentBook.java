//SAMPLE
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
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
   private ArrayList<Appointment> appointments = new ArrayList<>();

   /**
      Adds a new Appointment object based on user input.
      @param in the Scanner to read from.
   */
   public void addAppointment(Scanner in)
   {
      System.out.print("Enter type [(D)aily, (M)onthly, (O)netime] and description: ");
      String input = in.nextLine();
      Scanner sin = new Scanner(input);
      String type = sin.next().toUpperCase();
      String description = sin.nextLine().trim();

      if (type.equals("D"))
      {
         appointments.add(new Daily(description));
      }
      else if (type.equals("M"))
      {
         System.out.print("Enter the day of the appointment: ");
         int day = in.nextInt();
         in.nextLine(); // eat the newline
         appointments.add(new Monthly(day, description));
      }
      else if (type.equals("O"))
      {
         System.out.print("Enter the date of the appointment (mm dd yyyy) :");
         // Sure easier in C++
         int month = in.nextInt();
         int day = in.nextInt();
         int year = in.nextInt();
         in.nextLine(); // eat the end line

         appointments.add(new Onetime(year, month, day, description));
      }
      else
      {
         System.out.println("Did not recognize the type: " + type);
      }
   }

   /**
      Method to print all appointments on a certain date.
      @param in the Scanner to read from
   */
   public void findAppointments(Scanner in)
   {
      System.out.print("Enter the date (mm, dd, yyyy) to search: ");
      int month = in.nextInt();
      int day = in.nextInt();
      int year = in.nextInt();
      in.nextLine(); // eat the end
      for (Appointment a : appointments)
      {
         if (a.occursOn(year, month, day))
         {
            System.out.println(a);
         }
      }
   }

   /**
      Save the appointments to a file.
   */
   public void saveAppointments(PrintWriter out)
   {
      try
      {
         for (Appointment a : appointments)
         {
            a.save(out);
         }
      }
      catch (Exception e)
      {
         System.out.println("Error saving appointments");
      }
   }

   /**
      Load appointments from a file.
   */
   public void loadAppointments(Scanner in)
   {
      try
      {
         appointments.clear(); // get rid of the old ones
         while (in.hasNext())
         {
            Appointment a = null;
            String type = in.next();
            if (type.equals("D")) { a = new Daily(); }
            else if (type.equals("M")) { a = new Monthly(); }
            else if (type.equals("O")) { a = new Onetime(); }
            else { throw new IOException("Don't recognize object type: " + type); }

            if (! a.load(in))
            {
               throw new IOException("Error loading appointment.");
            }
            appointments.add(a);
         }
      }
      catch (Exception e)
      {
         System.out.println("Error: " + e.getMessage());
      }
   }
}
