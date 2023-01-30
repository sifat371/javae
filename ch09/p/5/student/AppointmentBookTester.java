//HIDE
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
/**
   Improve the appointment book program of Exercise P9.3.
   Give the user the option to add new appointments.
   The user must specify the type of the appointment and
   description, and then, if required, the day or date.
*/
public class AppointmentBookTester
{
   // Just to test the appointment book
   public static void main(String[] args)
   {
      try (Scanner in = new Scanner(new File("test.txt")))
      {
         AppointmentBook ab = new AppointmentBook();
         PrintStream oldOut = System.out;
         System.setOut(new PrintStream(new ByteArrayOutputStream()));
         ab.addAppointment(in);
         ab.addAppointment(in);
         ab.addAppointment(in);
         ab.addAppointment(in);
         System.setOut(oldOut);

         ab.findAppointments(in);
         System.out.println("Expected: remember anniversary");
         ab.findAppointments(in);
         System.out.println("Expected: pay the bills");
         ab.findAppointments(in);
         System.out.println("Expected: write some code");
      }
      catch (IOException e)
      {
         System.err.println("Cannot open test.txt");
      }
   }
}
