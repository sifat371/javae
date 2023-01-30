//SAMPLE
import java.util.Scanner;
/**
   Demonstration of the appointment classes
*/
public class AppointmentDemo
{
   public static void main(String[] args)
   {
      Appointment[] appointments = new Appointment[5];
      appointments[0] = new Daily("Brush your teeth.");
      appointments[1] = new Monthly(1, "Visit grandma.");
      appointments[2] = new Onetime(2015, 11, 1, "Dentist appointment.");
      appointments[3] = new Onetime(2015, 10, 31, "Trick or Treat.");
      appointments[4] = new Daily("Write some code.");

      Scanner in = new Scanner(System.in);
      System.out.print("Enter a date (like 2015 10 31): ");
      int year = in.nextInt();
      int month = in.nextInt();
      int day = in.nextInt();

      System.out.println("Your appointments on " + month + "/" + day + "/" + year + ":");
      for (Appointment a : appointments)
      {
         if (a.occursOn(year, month, day))
         {
            System.out.println(a);
         }
      }
   }
}
