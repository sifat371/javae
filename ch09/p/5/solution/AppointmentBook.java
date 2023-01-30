//SAMPLE
import java.util.Scanner;
import java.util.ArrayList;
/**
   Improve the appointment book program of Exercise P9.3.
   Give the user the option to add new appointments.
   The user must specify the type of the appointment and
   description, and then, if required, the day or date.
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
      String type = sin.next();
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

   // Just to test the appointment book
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      AppointmentBook ab = new AppointmentBook();

      System.out.println("Welcome to the Appointment Book");
      System.out.println("-------------------------------");

      boolean done = false;
      while (!done)
      {
         System.out.print("Appointments: (F)ind, (A)dd, or (Q)uit: ");
         String choice = in.next();
         if (choice.equals("F"))
         {
            ab.findAppointments(new Scanner(System.in));
         }
         else if (choice.equals("A"))
         {
            ab.addAppointment(new Scanner(System.in));
         }
         done = choice.equals("Q");
      }
   }
}
