/**
 * Tests the alarm feature of the Clock class.
 */
public class ClockDemo
{
   public static void main(String[] args)
   {
      //test the AlarmClock
      Clock clock = new Clock();   
      System.out.println("Hours:" + clock.getHours());
      System.out.println("Minutes: " + clock.getMinutes());
      System.out.println("Time: " + clock.getTime());
      
      //test AlarmClock with alarm
      int h = Integer.parseInt(clock.getHours());
      int m = Integer.parseInt(clock.getMinutes());
      
      clock.setAlarm(h, m - 1);   
      System.out.println("Time:" + clock.getTime());
      //test to see if the Alarm is cleared.
      System.out.println("Time: " + clock.getTime());
   }
}
