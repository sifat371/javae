import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
   This program tests a method that reads each line of a file, using a random access file, 
   reversing each line in place.
 */
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
      This method reads each line of a file, using a random access file, 
      reversing each line in place.
      @param infile the name of the input
     */
    public static void reverseLines(String infile) throws IOException
    {          
       RandomAccessFile fileIn = new RandomAccessFile(infile,"rw"); 
       //Read each line and write it in place in reverse
       String line = null;
       long pos;
       while((line = fileIn.readLine()) != null)
       {
           pos  = fileIn.getFilePointer();           
           fileIn.seek(pos-line.length()-1);
           for (int i=line.length()-1; i>=0; i--)
           {
              fileIn.write(line.charAt(i));              
           }
           fileIn.write('\n');    
       }
       //close file stream
       fileIn.close();
    } 
}
