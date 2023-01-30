import java.io.IOException;
import java.util.Scanner;

/**
   This program tests a method that reads each line of a file, using a random access file, 
   reversing each line in place.
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
      Reads each line of a file, using Random access file, and reverses it in place
	  a using random access file
      @param infile the name of the input
     */
    public static void reverseLines(String infile) throws IOException
    {          
       //complete the implementation of this method
    } 
}
