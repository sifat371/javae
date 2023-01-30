import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
   Reads a data set from a file. The file must have the format
   numberOfValues
   value1
   value2
   . . .
*/
public class DataSetReader
{
   private double[] data;

   /**
      Reads a data set.
      @param filename the name of the file holding the data
      @return the data in the file
   */
   public double[] readFile(String filename) 
         throws IOException, BadDataException
   {     
      try (Scanner in = new Scanner(new File(filename)))
      {         
         readData(in);
      }
      catch (InputMismatchException e)
      {
         throw new BadDataException("Bad data");
      }
      catch (NoSuchElementException e)
      {
         throw new BadDataException("Bad data");
      }
      return data;
   }

   /**
      Reads all data.
      @param in the scanner that scans the data
   */
   private void readData(Scanner in) throws BadDataException,
         InputMismatchException, NoSuchElementException
   {
      int numberOfValues = in.nextInt();
      data = new double[numberOfValues];

      for (int i = 0; i < numberOfValues; i++)
         readValue(in, i);

      if (in.hasNext()) 
         throw new BadDataException("End of file expected");
   }

   /**
      Reads one data value.
      @param in the scanner that scans the data
      @param i the position of the value to read
   */
   private void readValue(Scanner in, int i)
         throws InputMismatchException, NoSuchElementException
   {
      data[i] = in.nextDouble();      
   }
}