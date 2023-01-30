import java.io.*;
import java.util.*;

public class RiseTime
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      try (Scanner inFile = new Scanner(new File("rc.txt")))
      {
         ArrayList<Double> times = new ArrayList<Double>();
         ArrayList<Double> voltages = new ArrayList<Double>();

         while (inFile.hasNextLine())
         {
            Scanner lineScanner = new Scanner(inFile.nextLine());

            times.add(lineScanner.nextDouble());
            voltages.add(lineScanner.nextDouble());
         }

         double b = voltages.get(voltages.size() - 1);
         double v1 = b * 0.05;
         double v2 = b * 0.95;

         double t1 = 0;
         double t2 = 0;
         double minDelta1 = b;
         double minDelta2 = b;
         for (int i = 0; i < voltages.size(); i++)
         {
            double delta1 = Math.abs(voltages.get(i) - v1);
            if (delta1 < minDelta1)
            {
               minDelta1 = delta1;
               t1 = times.get(i);
            }
            double delta2 = Math.abs(voltages.get(i) - v2);
            if (delta2 < minDelta2)
            {
               minDelta2 = delta2;
               t2 = times.get(i);
            }
         }
         System.out.println("Rise time: " + (t2 - t1));
      } 
      catch (FileNotFoundException e)
      {
         System.out.println("File not found!");
      }
   }
}
