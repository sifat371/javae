//..................................................................

public class CircuitDemo
{
   public static void main(String[] args)
   {
      Parallel circuit1 = new Parallel();
      circuit1.add(new Resistor(100));
      Serial circuit2 = new Serial();
      circuit2.add(new Resistor(100));
      circuit2.add(new Resistor(200));
      circuit1.add(circuit2);
      System.out.println("Combined resistance: " + circuit1.getResistance());
   }
}
