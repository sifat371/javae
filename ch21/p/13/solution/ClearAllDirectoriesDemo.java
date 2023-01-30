import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
  This program tests the clearAllDirectories method
 */
public class ClearAllDirectoriesDemo
{
    public static void main(String[] args) 
    {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter the directory path -> ");
        Path dir = Paths.get(cin.next());
        try 
        {
            clearAllDirectories(dir);
        } 
        catch (IOException e) 
        {
            System.out.println(e);
        }
    }
    
    /**
       This method removes all files and subdirectories from a directory
       @param dir the directory
     */
    public static void clearAllDirectories(Path dir) throws IOException
    {
        try(Stream<Path> srcDir = Files.walk(dir))
        {
            List<Path> srcPaths = srcDir.collect(Collectors.toList());            
            for (int i = srcPaths.size()-1; i>0; i--)
            {               
                    Files.delete(srcPaths.get(i));
            }
        }
    } 
}