//..................................................................

public class SeriesResonantCircuit extends ResonantCircuit
{
   private double resistance;
   private double inductance;
   private double capacitance;

   /**
      Constructs an SeriesResonantCircuit.
      @param wo the resonant frequency.
      @param b the bandwidth.
      @param k the gain at the resonant frequency.
   */
   public SeriesResonantCircuit(double wo, double b, double k)
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
      Calculates the values of the resistance, inductance and capacitance;
   */
   public void design()
   {
      resistance = 1.0 / getGain();
      inductance = resistance / getBandwidth();
      double w = getResonantFrequency();
      capacitance = 1.0 / inductance / w / w;
   }

   /**
      Displays a description of the SeriesResonantCircuit.
   */
   public void display()
   {
      System.out.println("Series resonant circuit: Resonant frequency = "
            + getResonantFrequency() + " rad/s, bandwidth = " + getBandwidth()
            + " rad/s, gain = " + getGain());
      System.out.println("R = " + resistance + " Ohms , L = " + inductance
            + " H, C = " + capacitance + " F.");
   }
}
