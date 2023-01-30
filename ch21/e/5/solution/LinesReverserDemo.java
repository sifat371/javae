import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
   This program tests a method that reads each line of a file, reverses it and writes it to a
   temporary file, deletes the file and then move the temporary file to the original file. 

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
      Reads all lines of the file, reverses each of them, and writes
      them to a temporary file, delete the original file and move the
      temporary file to the original file.
      @param infile the name of the input/source file
     */
    public static void reverseLines(String infile) throws IOException
    {          
       FileInputStream fileIn = new FileInputStream(infile); 
       Path srcPath = Paths.get(infile);
       //Read all lines from the file and close the file stream
       List<String> lines = Files.readAllLines(srcPath);
       fileIn.close();
       //create a temporary file stream
       String prefix="tmp";
       String extension=".txt";
       Path tempFilePath = Files.createTempFile(prefix, extension);
       String destFile = tempFilePath.getFileName().toString();
       FileOutputStream tmpFile = new FileOutputStream(destFile);       
       //reverse each line and write the result
       for (String line : lines) 
       {
            for (int j = line.length()-1; j >= 0; j--) 
            {
                tmpFile.write(line.charAt(j));
            }
            tmpFile.write('\n');
        }    
       //close the temporary file stream
       tmpFile.close();
       //obtain path of the original and temporary files
       Path origPath = Paths.get(infile);
       Path tmpPath = Paths.get(destFile);
       //delete the original file and move the new file to the original
       Files.delete(origPath);
       origPath = Paths.get(infile);
       Files.move(tmpPath,origPath);          
    }  
}

