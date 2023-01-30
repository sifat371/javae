import java.io.IOException;
import java.util.Scanner;

/**
   This program tests a method that reads each line of a file, reverses it and writes it to a
   temporary file, deletes the file and then move the temporary file to the original file. 

 */
 //OUT mary.txt
public class LinesReverserDemo 
{
    public static void main(String[] args) 
    {
        try 
        {
            Scanner cin = new Scanner(System.in);
            System.out.print("Enter the name of the file -> ");
            String infile = cin.next();
            reverseLines(infile);
        } 
        catch (IOException ex) 
        {
            System.out.println(ex);
        }
    }
	
   /**
      Reads all lines of the file, reverses each of them, and writes
      them to a temporary file, delete the original file and move the
      temporary file to the original file.
      @param infile the name of the input/source file
     */
    public static void reverseLines(String infile) throws IOException
    {          
		//Complete this method
    }  
}

