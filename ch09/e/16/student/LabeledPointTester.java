public class LabeledPointTester
{
   public static void main(String[] args) throws Exception
   {
      LabeledPoint obj = new LabeledPoint(7, 19, "Don't click here");
      System.out.println(obj);
      System.out.println("Expected: LabeledPoint[x=7,y=19,label=Don't click here]");
   }
}
