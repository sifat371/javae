import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
  This program tests the copyFiles method
 */
public class CopyFilesDemo 
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
            copyFiles(fromDir,toDir);
        } 
        catch (IOException e) 
        {
            System.out.println(e);
        }
    }
    
    /**
      This method copies all files (but none of the directories) from
      one directory to another.
      @param fromDir the source directory
      @param toDir the destination directory
     */
    public static void copyFiles(Path fromDir, Path toDir) throws IOException
    {
        try(Stream<Path> srcDir = Files.list(fromDir))
        {
            List<Path> srcPaths = srcDir.collect(Collectors.toList());
            Path destFile;
            for (Path srcFile: srcPaths)
            {                
                destFile = toDir.resolve(srcFile.getFileName());
                if (Files.isRegularFile(srcFile))
                {
                    Files.copy(srcFile,destFile);
                }
            }
        }
    }    
}