import java.io.*;
import java.util.*;

public class CapacitorVoltage
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      try (Scanner inFile = new Scanner(new File("params.txt"));  
           PrintWriter out = new PrintWriter("rc.txt"))
      {    
         double b = inFile.nextDouble();
         double r = inFile.nextDouble();
         double c = inFile.nextDouble();
         double t1 = inFile.nextDouble();
         double t2 = inFile.nextDouble();

         final int NSTEPS = 100;
         double stepSize = (t2 - t1) / NSTEPS;

         for (int step = 0; step <= NSTEPS; step++)
         {
            double t = t1 + step * stepSize;
            out.println(t + " " + b * (1 - Math.exp(-t / (r * c))));
         }
      } 
      catch (FileNotFoundException e)
      {
         System.out.println("File not found!");
      }
   }
}
