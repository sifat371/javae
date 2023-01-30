//..................................................................

import java.util.ArrayList;

public class Serial extends Circuit
{
   private ArrayList<Circuit> circuits;

   public Serial()
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
         sum = sum + circuits.get(i).getResistance();
      }
      return sum;
   }
}
