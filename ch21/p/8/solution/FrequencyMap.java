/**
   A class to count the frequency of letters
*/
public class FrequencyMap
{
   private int[] freqs;
   private int total;

   /**
      Construct a FrequencyMap object.
   */
   public FrequencyMap()
   {
      total = 0;
      freqs = new int['Z' - 'A' + 1];
   }

   /**
      Gets the frequency of the specified letter.
      @param c the character to get frequency percentage
      @return the frequency
   */
   public double getFrequency(char c)

   {
      if ('A' <= c && c <= 'Z')
         return 100.0 * freqs[c - 'A'] / total;
      else
         return 0;
   }

   /**
      Adds a letter to be counted.
      @param c the letter to add
   */
   public void add(char c)
   {
      if ('A' <= c && c <= 'Z')
      {
         freqs[c - 'A']++;
         total++;
      }
   }
}
