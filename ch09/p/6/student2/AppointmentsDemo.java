import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
/**
   Part II. Complete the AppointmentBook program.
*/
public class AppointmentsDemo
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      AppointmentBook ab = new AppointmentBook();

      System.out.println("Welcome to the Appointment Book");
      System.out.println("-------------------------------");

      boolean done = false;
      while (!done)
      {
         System.out.print("Appointments: (A)dd, (F)ind, (L)oad, (S)ave or (Q)uit: ");
         String choice = in.nextLine().toUpperCase();
         if (choice.equals("F"))
         {
            ab.findAppointments(new Scanner(System.in));
         }
         else if (choice.equals("A"))
         {
            ab.addAppointment(new Scanner(System.in));
         }
         else if (choice.equals("L"))
         {
            System.out.print("File containing appointments: ");
            String filename = in.nextLine();
            try (Scanner ain = new Scanner(new File(filename)))
            {
               ab.loadAppointments(ain);
            }
            catch (IOException e)
            {
               System.out.println("Error loading appointments from: " + filename);
            }
         }
         else if (choice.equals("S"))
         {
            System.out.print("File to save to: ");
            String filename = in.nextLine();
            try (PrintWriter out = new PrintWriter(filename))
            {
               ab.saveAppointments(out);
            }
            catch (IOException e)
            {
               System.out.println("Error saving appointments to: " + filename);
            }
         }

         done = choice.equals("Q");
      }
   }
}
