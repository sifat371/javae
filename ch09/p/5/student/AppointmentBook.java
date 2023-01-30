import java.util.Scanner;
/**
   Improve the appointment book program of Exercise P9.3.
   Give the user the option to add new appointments.
   The user must specify the type of the appointment and
   description, and then, if required, the day or date.
*/
public class AppointmentBook
{
   . . .

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
      @param in the Scanner to read from.
   */
   public void findAppointments(Scanner in)
   {
      . . .

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
