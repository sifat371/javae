//..................................................................

import java.util.ArrayList;

public class Parallel extends Circuit
{
   private ArrayList<Circuit> circuits;

   public Parallel()
   {
      circuits = new ArrayList<Circuit>();
   }

   public void add(Circuit circuit)
   {
      circuits.add(circuit);
   }

   public double getResistance()
   {
      double sum = 0;
      for (int i = 0; i < circuits.size(); i++)
      {
         sum = sum + 1 / circuits.get(i).getResistance();
      }
      return 1 / sum;
   }
}
