/**
   Program to test the CSVcolumnSummary class.
*/
public class CSVcolumnSummaryTester
{
   public static void main(String[] args)
   {
      CSVcolumnSummary summary = new CSVcolumnSummary("att2007.csv");
      System.out.printf("The avg volume is: %.2f\n", summary.columnAvg(5));
      System.out.println("Expected: 166560.75");
      System.out.printf("The min volume is: %.2f\n", summary.columnMin(5));
      System.out.println("Expected: 22100.00");
      System.out.printf("The max volume is: %.2f\n", summary.columnMax(5));
      System.out.println("Expected: 8841040.00");
      System.out.printf("The avg price is: %.2f\n", summary.columnAvg(6));
      System.out.println("Expected: 22.63");
      System.out.printf("The min price is: %.2f\n", summary.columnMin(6));
      System.out.println("Expected: 20.77");
      System.out.printf("The max price is: %.2f\n", summary.columnMax(6));
      System.out.println("Expected: 23.73");
   }
}