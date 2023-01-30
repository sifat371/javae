import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
   This program tests a method that copies all bytes from one file to another, without using Files.copy.
*/
//OUT maryOut.txt
public class CopyDemo 
{
    public static void main(String[] args) 
    {
        try 
        {
            Scanner cin = new Scanner(System.in);
            System.out.print("Enter the name of the source file -> ");
            String infile = cin.next();
            System.out.print("Enter the name of the destination file -> ");
            String outfile = cin.next();
            copy(infile,outfile);
        } 
        catch (IOException ex) 
        {
            System.out.println(ex);
        }
            
        
    }
    
    /**
        Copies a source file to a destination file.
        @param infile the name of the input/source file
        @param outfile the name of the output/destination file
        @throws java.io.FileNotFoundException
    */
    public static void copy(String infile, String outfile) throws FileNotFoundException, IOException
    {          
        //complete this method
    }
    
}