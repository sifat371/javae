//..................................................................

public class InvertingAmplifier extends Amplifier
{
   private double inputResistance;
   private double feedbackResistance;

   /**
      Constructs an InvertingAmplifier having input resistance r1 and
      feedback resistance r2.
   */
   public InvertingAmplifier(double r1, double r2)
   {
      inputResistance = r1;
      feedbackResistance = r2;
   }

   public double getGain()
   {
      return -feedbackResistance / inputResistance;
   }

   public String getDescription()
   {
      return "Inverting Amplifier: R1 = " + inputResistance + ", R2 = "
            + feedbackResistance;
   }
}
