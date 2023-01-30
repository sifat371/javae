import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
/**
   Part I: Implement a class Clock whose getHours, getMinutes and
   getTime methods return the current time at your location.
   Return the time as a string.

   There are two ways to retrieve the current time as a String:

   1) Before Java 8 use new Date().toString()
   2) With Java 8, you can use 3 classes in the java.time package:
      Instant, LocalDateTime and ZoneId. Here's how you do it:
      String timeString = LocalDateTime.ofInstant(Instant.now(),
                              ZoneId.systemDefault()).toString()

   With either method, you'll need to extract the hours and
   minutes as a substring.
*/
public class Clock
{
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
    * gets current time composed of hours and minutes
    * @return time in string;
    */
   public String getTime()
   {
        return getHours() + ":" + getMinutes();
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
