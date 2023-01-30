/**
   Class to summarize one of the columns from a CSV file.
   An important assumtpion is that the file contains at least one row.
*/
public class CSVcolumnSummary
{
   private CSVReader reader;
   
   /**
      Constructor accepts the name of the file to be summarized.
   */
   public CSVcolumnSummary(String fileName)
   {
      reader = new CSVReader(fileName);
   }

   /**
      Returns the average of values in a given column.
      @param col the column number to be averaged (0 is the first column)
      @return the average of the values in col
   */
   public double columnAvg(int col)
   {
     double sum = 0;
     for (int row = 0; row < reader.numberOfRows(); ++row)
     {
         sum += Double.parseDouble(reader.field(row, col));
     }
     return sum / reader.numberOfRows();
   }

   /**
      Returns the smallest of the values in a given column.
      @param col the column number to be analyzed (0 is the first column)
      @return the smallest of the values in col
   */
   public double columnMin(int col)
   {
     double min = Double.parseDouble(reader.field(0, col));
     for (int row = 1; row < reader.numberOfRows(); ++row)
     {
         double value = Double.parseDouble(reader.field(row, col));
         if (value < min)
         {
            min = value;
         }
     }
     return min;
   }
   
   /**
      Returns the largest of the values in a given column.
      @param col the column number to be analyzed (0 is the first column)
      @return the largest of the values in col
   */
   public double columnMax(int col)
   {
     double max = Double.parseDouble(reader.field(0, col));
     for (int row = 1; row < reader.numberOfRows(); ++row)
     {
         double value = Double.parseDouble(reader.field(row, col));
         if (value > max)
         {
            max = value;
         }
     }
     return max;
   }                 
}
