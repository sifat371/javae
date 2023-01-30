import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
   Tests a method that, given a Path to a file that doesn’t yet exist, 
   creates all intermediate directories and the file.
 */
public class PathCreatorDemo 
{
    public static void main(String[] args) 
    {
        try
        {
            Scanner cin = new Scanner(System.in);
            System.out.print("Enter the full path of the file ->");
            String infile = cin.next();
            createFilePath(Paths.get(infile));
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    
    /**
      Creates a file that doesn't yet exist along with intermediate directories
      that do not exist.
      @param path the path for the file
      Note: If the file already exists a FileAreadyExistsException is thrown
     */
    public static void createFilePath(Path path) throws IOException
    {
       Path parent = path.getParent().toAbsolutePath();
       Path current=parent.getRoot();
       for (Path p: parent)
       {
          current = current.resolve(p);
              //create the directory if it doesn't already exist
          if (!Files.exists(current))
          {      
             Files.createDirectory(current);
          }          
       }
       //Note: A FileAreadyExistsException is thrown if the file already exists
       Files.createFile(path);                     
    }       
}
