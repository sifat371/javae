//..................................................................

public class ResonantDemo
{
   public static void main(String[] args)
   {
      SeriesResonantCircuit circuit1 = new SeriesResonantCircuit(2500, 500,
            0.01);
      circuit1.display();
      ParallelResonantCircuit circuit2 = new ParallelResonantCircuit(60000,
            3000, 10000);
      circuit2.display();
      circuit2.setResonantFrequency(14130);
      circuit2.setBandwidth(14130.0 / 14);
      circuit2.setGain(4000);
      circuit2.display();
   }
}
