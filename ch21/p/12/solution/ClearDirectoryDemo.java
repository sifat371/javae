import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
  This program tests the clearDirectory method
 */
public class ClearDirectoryDemo 
{
    public static void main(String[] args) 
    {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter the directory path -> ");
        Path dir = Paths.get(cin.next());
        try 
        {
            clearDirectory(dir);
        } 
        catch (IOException e) 
        {
            System.out.println(e);
        }
    }
    
    /**
       This method removes all files from a directory but does not remove
       subdirectories and their contents
       @param dir the directory
     */
    public static void clearDirectory(Path dir) throws IOException
    {
        try(Stream<Path> srcDir = Files.list(dir))
        {
            List<Path> srcPaths = srcDir.collect(Collectors.toList());
            
            for (Path srcFile: srcPaths)
            {                
                if (Files.isRegularFile(srcFile))
                {
                    Files.delete(srcFile);
                }
            }
        }
    }     
}
