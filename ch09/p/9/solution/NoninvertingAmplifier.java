//..................................................................

public class NoninvertingAmplifier extends Amplifier
{
   private double inputResistance;
   private double feedbackResistance;

   /**
      Constructs an NoninvertingAmplifier having input resistance r1 and
      feedback resistance r2.
   */
   public NoninvertingAmplifier(double r1, double r2)
   {
      inputResistance = r1;
      feedbackResistance = r2;
   }

   public double getGain()
   {
      return 1 + feedbackResistance / inputResistance;
   }

   public String getDescription()
   {
      return "Noninverting Amplifier: R1 = " + inputResistance + ", R2 = "
            + feedbackResistance;
   }
}
