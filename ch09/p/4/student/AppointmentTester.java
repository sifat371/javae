//HIDE
public class AppointmentTester
{
   public static void main(String[] args)
   {
      System.out.print("Daily is subclass of Appointment: ");
      System.out.println(Daily.class.getSuperclass() == Appointment.class);
      System.out.println("Expected: true");
      System.out.print("Daily appointments have no extra fields:");
      System.out.println(Daily.class.getDeclaredFields().length == 0);
      System.out.println("Expected: true");

      // Try some appointments
      Appointment obj = new Daily("walk the dog");
      System.out.println("Checking daily appointment: " + obj);
      System.out.println("Expected: walk the dog");
      System.out.println(obj.occursOn(2016, 12, 25));
      System.out.println("Expected: true");
   }
}
