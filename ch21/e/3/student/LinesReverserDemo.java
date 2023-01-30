import java.io.IOException;

/**
    This program tests a method that reverses all lines in a file. It reads all 
    * the lines, reverses each line, and writes the result.
 */
//OUT mary.txt
public class LinesReverserDemo 
{
    public static void main(String[] args) 
    {
        try 
        {
            reverseLines(args[0]);
        } 
        catch (IOException ex) 
        {
            System.out.println(ex);
        }
    }
	
    /**
      Reads all lines of the file, reverses each of them, and writes
      them to another file.
      @param infile the name of the input
     */
    public static void reverseLines(String infile) throws IOException
    {          
       //Complete this method
    } 
}