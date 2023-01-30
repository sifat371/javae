public class FormatIntsDemo
{
   /**
		Accepts an array of int values and a NumberFormatter object.
		Displays each number according to the NumberFormatter, one per line.
   */
   public static void formatInts(int[] values, NumberFormatter numFormat)
   {
      for (int value: values)
      {
         System.out.printf("%20s\n", numFormat.format(value));
      }
   }
   
   /**
		Demonstrates the formatInts method using a DefaultFormatter object.
   */
   public static void main(String[] args)
   {
      int[] values = { 5, -40, 12345, 1000 };
            
      System.out.println("Default Formatting:");
      formatInts(values, new DefaultFormatter());                      
   }
}
