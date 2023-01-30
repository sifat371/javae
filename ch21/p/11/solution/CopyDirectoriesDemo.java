import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
   This program tests the copyDirectories method
 */
public class CopyDirectoriesDemo 
{
    public static void main(String[] args) 
    {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter the source path -> ");
        Path fromDir = Paths.get(cin.next());
        System.out.print("Enter the destination path -> ");
        Path toDir = Paths.get(cin.next());
        try 
        {
            copyDirectories(fromDir,toDir);
        } 
        catch (IOException e) 
        {
            System.out.println(e);
        }
    }
    
    /**
       This method copies all files and directories from one directory 
       to another. An exception is thrown if any of the directories
	   or files already exists in the destination path.
       @param fromDir source directory
       @param toDir destination directory
     */
    public static void copyDirectories(Path fromDir, Path toDir) throws IOException
    {
        try(Stream<Path> srcDir = Files.walk(fromDir))
        {
            List<Path> srcPaths = srcDir.collect(Collectors.toList());
            Path destFile;
            srcPaths.remove(0);
            for (Path srcFile: srcPaths)
            {                
                destFile = toDir.resolve(fromDir.relativize(srcFile));
                Files.copy(srcFile,destFile);
            }
        }
    }        
}
