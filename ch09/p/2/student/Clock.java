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
   // Your work goes here
   . . .











}
