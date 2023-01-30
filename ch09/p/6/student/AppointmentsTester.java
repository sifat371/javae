import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class AppointmentsTester
{
   public static void main(String[] args)
   {
      try (PrintWriter out = new PrintWriter("appointments.txt"))
      {
         Appointment daily = new Daily("brush your teeth");
         Appointment monthly = new Monthly(15, "pay the bills");
         Appointment onetime = new Onetime(2016, 10, 22, "remember anniversary");
         System.out.println(daily.save(out));
         System.out.println("Expected: true");
         System.out.println(monthly.save(out));
         System.out.println("Expected: true");
         System.out.println(onetime.save(out));
         System.out.println("Expected: true");
      }
      catch (Exception e)
      {
         System.out.println("Error: " + e.toString());
      }

      try (Scanner in = new Scanner(new File("appointments.txt")))
      {
         String type = in.next();
         System.out.println(type);
         System.out.println("Expected: D");
         Appointment daily2 = new Daily();
         System.out.println(daily2.load(in));
         System.out.println("Expected: true");
         System.out.println(daily2.toString());
         System.out.println("Expected: brush your teeth");
         type = in.next();
         System.out.println(type);
         System.out.println("Expected: M");
         Appointment monthly2 = new Monthly();
         System.out.println(monthly2.load(in));
         System.out.println("Expected: true");
         System.out.println(monthly2.toString());
         System.out.println("Expected: pay the bills");
         System.out.println(monthly2.occursOn(2016, 11, 15));
         System.out.println("Expected: true");
         type = in.next();
         System.out.println(type);
         System.out.println("Expected: O");
         Appointment onetime2 = new Onetime();
         System.out.println(onetime2.load(in));
         System.out.println("Expected: true");
         System.out.println(onetime2.toString());
         System.out.println("Expected: remember anniversary");
         System.out.println(onetime2.occursOn(2016, 10, 22));
         System.out.println("Expected: true");
         // No more data - we only wrote three appointments
         Appointment dummy = new Monthly();
         System.out.println(dummy.load(in));
         System.out.println("Expected: false");
      }
      catch (Exception e)
      {
         System.out.println("Error: " + e.toString());
      }
   }
}
