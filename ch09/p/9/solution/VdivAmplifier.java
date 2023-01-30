//..................................................................

public class VdivAmplifier extends Amplifier
{
   private double seriesResistance;
   private double shuntResistance;

   /**
      Constructs an VdivAmplifier having series resistance r1 and
      shunt resistance r2.
   */
   public VdivAmplifier(double r1, double r2)
   {
      seriesResistance = r1;
      shuntResistance = r2;
   }

   public double getGain()
   {
      return shuntResistance / (seriesResistance + shuntResistance);
   }

   public String getDescription()
   {
      return "Voltage Divider and Voltage Follower: R1 = " + seriesResistance
            + ", R2 = " + shuntResistance;
   }
}
