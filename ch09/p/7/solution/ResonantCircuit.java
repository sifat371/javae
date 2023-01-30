public class ResonantCircuit
{
   private double resonantFrequency;
   private double bandwidth;
   private double gain;

   public ResonantCircuit()
   {
      resonantFrequency = 0;
      bandwidth = 0;
      gain = 0;
   }

   public ResonantCircuit(double wo, double b, double k)
   {
      resonantFrequency = wo;
      bandwidth = b;
      gain = k;
   }

   public void setResonantFrequency(double wo)
   {
      resonantFrequency = wo;
   }

   public void setBandwidth(double b)
   {
      bandwidth = b;
   }

   public void setGain(double k)
   {
      gain = k;
   }

   public double getResonantFrequency()
   {
      return resonantFrequency;
   }

   public double getBandwidth()
   {
      return bandwidth;
   }

   public double getGain()
   {
      return gain;
   }

   public void display()
   {
      System.out.println("Resonant circuit: Resonant frequency = "
            + resonantFrequency + " rad/s, bandwidth = " + bandwidth
            + " rad/s, gain = " + gain);
   }
}
