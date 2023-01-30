import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
    This program tests a method that reverses all lines in a file. It reads all 
    * the lines, reverses each line, and writes the result.
 */
//ARGS mary.txt
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
       FileInputStream fileIn = new FileInputStream(infile); 
       Path srcPath = Paths.get(infile);
       //Read all lines
       List<String> lines = Files.readAllLines(srcPath);
       fileIn.close();
        //reverse each line and write the result
       FileOutputStream fileOut = new FileOutputStream(infile);
       for (String line : lines) 
       {
            for (int j = line.length()-1; j >= 0; j--) 
            {
                fileOut.write(line.charAt(j));
            }
            fileOut.write('\n');
        }    
       //close file streams
       fileOut.close();
    } 
}