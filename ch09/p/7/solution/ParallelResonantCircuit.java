//..................................................................

public class ParallelResonantCircuit extends ResonantCircuit
{
   private double resistance;
   private double inductance;
   private double capacitance;

   /**
      Constructs a ParallelResonantCircuit.
      @param wo the resonant frequency.
      @param b the bandwidth.
      @param k the gain at the resonant frequency.
   */
   public ParallelResonantCircuit(double wo, double b, double k)
   {
      super(wo, b, k);
      design();
   }

   public void setResonantFrequency(double wo)
   {
      super.setResonantFrequency(wo);
      design();
   }

   public void setBandwidth(double b)
   {
      super.setBandwidth(b);
      design();
   }

   public void setGain(double k)
   {
      super.setGain(k);
      design();
   }

   /**
      Calculates the values of the resistance, inductance and capacitance.
   */
   public void design()
   {
      resistance = getGain();
      capacitance = 1.0 / resistance / getBandwidth();
      double w = getResonantFrequency();
      inductance = 1.0 / capacitance / w / w;
   }

   public void display()
   {
      System.out.println("Parallel resonant circuit: Resonant frequency = "
            + getResonantFrequency() + " rad/s, bandwidth = " + getBandwidth()
            + " rad/s, gain = " + getGain());
      System.out.println("R = " + resistance + " Ohms, L = " + inductance
            + " H , C = " + capacitance + " F.");
   }
}
