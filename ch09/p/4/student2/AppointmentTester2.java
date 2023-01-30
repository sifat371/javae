public class AppointmentTester2
{
   public static void main(String[] args)
   {
      Appointment obj = new Monthly(15, "pay the bills");
      System.out.println(obj.occursOn(2016, 8, 15));
      System.out.println("Expected: true");
      obj = new Onetime(2016, 11, 1, "Dentist appointment.");
      System.out.println(obj.occursOn(2016, 10, 1));
      System.out.println("Expected: false");
      System.out.println(obj.occursOn(2016, 11, 1));
      System.out.println("Expected: true");
   }
}
