import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
/**
 * Add an alarm feature to the Clock class. 
 * When setAlarm(hours, minutes) is called, the clock 
 * stores the alarm. When you call getTime, and the alarm
 * time has been reached or exceeded, return the time followed 
 * by the string "Alarm" and clear the alarm.
 */
public class Clock 
{
   . . .
      
      
   /**
    * Sets the alarm.
    * @param hours hours for alarm
    * @param minutes minutes for alarm
    */
   public void setAlarm(int hours, int minutes)
   {
      // Complete this method
      . . .
         
         
   }
   
   /**
    * gets current time composed of hours and minutes
    * @return time in string;
    */
   public String getTime()
   {
      // Complete this method
      . . .
         
         
         
   }
   
   /**
    * gets hours
    * @return hours of current time in string
   */
   public String getHours()
   {
      final int HOUR_START = 11;
      return currentTime().substring(HOUR_START, HOUR_START + 2);
   }

   /**
    * gets minutes
    * @return hours of current time in string
   */
   public String getMinutes()
   {
      final int MINUTE_START = 14;
      return currentTime().substring(MINUTE_START, MINUTE_START + 2);
   }

   /**
      Returns the current Date and Time as a String.
   */
   private String currentTime()
   {
      return LocalDateTime.ofInstant(Instant.now(),
         ZoneId.systemDefault()).toString();
   }
}
