/**
 * PART II.
 * Provide a subclass of Clock namded WorldClock whose constructor
 * accepts a time offset. For example, if you live in California,
 * a new WorldClock(3) should show the time in New York, three
 * time zones ahead. You should not override getTime.
 */
public class WorldClock extends Clock
{
   int timeZoneOffset;

   /**
    * Constructs WorldClock with offset
    * @param offset time zone offset
    */
   public WorldClock(int offset )
   {
      timeZoneOffset = offset;
   }

   /**
    * Gets hours after applying offset
    * @return hours of current time in string after applying offset
    */
   @Override
   public String getHours()
   {
      //get current hours
      int hours = Integer.parseInt(super.getHours());

      //apply the offset
      hours = hours + timeZoneOffset;
      if (hours > 24)
      {
         hours = hours - 24;
      }
      else if (hours < 0)
      {
         hours = hours + 24;
      }

      //convert to String
      return Integer.toString(hours);
   }
}
